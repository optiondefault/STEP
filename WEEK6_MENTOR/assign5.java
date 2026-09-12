public class assign5 {
    static class DischargeSummary {
        private final String patientId;
        private final String[] medicationCodes;

        public DischargeSummary(String patientId, String[] medicationCodes) {
            this.patientId = patientId;
            if (medicationCodes == null) {
                throw new IllegalArgumentException("construction rejected");
            }
            for (String code : medicationCodes) {
                if (code == null || !code.matches("^MED-[A-Z]$")) {
                    throw new IllegalArgumentException("construction rejected");
                }
            }
            this.medicationCodes = new String[medicationCodes.length];
            System.arraycopy(medicationCodes, 0, this.medicationCodes, 0, medicationCodes.length);
        }

        public String[] getMedicationCodes() {
            String[] copy = new String[medicationCodes.length];
            System.arraycopy(medicationCodes, 0, copy, 0, medicationCodes.length);
            return copy;
        }
        
        public String getPatientId() {
            return patientId;
        }

        public DischargeSummary withCorrectedMedication(int index, String newCode) {
            String[] newCodes = getMedicationCodes();
            newCodes[index] = newCode;
            return new DischargeSummary(this.patientId, newCodes);
        }
    }

    static class CriticalCareDischargeSummary extends DischargeSummary {
        private final int icuDays;

        public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
            super(patientId, medicationCodes);
            this.icuDays = icuDays;
        }
    }

    public static String processNightlyBatch(DischargeSummary[] summaries) {
        if (summaries == null) return "0 processed";
        int processed = 0, nullSkipped = 0, critical = 0, routine = 0;
        
        for (DischargeSummary s : summaries) {
            if (s == null) {
                nullSkipped++;
            } else {
                processed++;
                if (s instanceof CriticalCareDischargeSummary) {
                    critical++;
                } else {
                    routine++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + critical + " critical-care | " + routine + " routine";
    }

    public static void main(String[] args) {
        try {
            new DischargeSummary("MT2026-0142", new String[]{"MED-A", "bad"});
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
        
        DischargeSummary d = new DischargeSummary("MT2026-0142", new String[]{"MED-A", "MED-B"});
        String[] codes = d.getMedicationCodes();
        codes[0] = "TAMPERED";
        System.out.println(d.getMedicationCodes()[0]);
        
        String result = processNightlyBatch(new DischargeSummary[]{
            new CriticalCareDischargeSummary("MT001", new String[]{"MED-X"}, 4),
            null,
            new DischargeSummary("MT002", new String[]{"MED-Y"})
        });
        System.out.println(result);
    }
}
