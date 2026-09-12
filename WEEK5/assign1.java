public class assign1 {
    static class LibraryMember {
        private String membershipId;
        String branchCode;
        protected double finesOwed;
        public String displayName;

        public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
            if (membershipId == null || membershipId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid membershipId");
            }
            this.membershipId = membershipId.trim();
            this.branchCode = branchCode;
            this.finesOwed = finesOwed;
            this.displayName = displayName;
        }
    }

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) return "ALLOWED";
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }
        if ("default".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
        }
        if ("protected".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privAllow = 0, privDeny = 0;
        int defAllow = 0, defDeny = 0;
        int protAllow = 0, protDeny = 0;
        int pubAllow = 0, pubDeny = 0;

        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String ctx = attempt[1];
            String result = classifyAccess(mod, ctx);
            boolean allowed = "ALLOWED".equals(result);

            switch (mod) {
                case "private": if (allowed) privAllow++; else privDeny++; break;
                case "default": if (allowed) defAllow++; else defDeny++; break;
                case "protected": if (allowed) protAllow++; else protDeny++; break;
                case "public": if (allowed) pubAllow++; else pubDeny++; break;
            }
        }

        return String.format("private: %d allowed / %d denied | default: %d allowed / %d denied | protected: %d allowed / %d denied | public: %d allowed / %d denied",
                privAllow, privDeny, defAllow, defDeny, protAllow, protDeny, pubAllow, pubDeny);
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        
        String[][] attempts = {
            {"private","SAME_CLASS"},
            {"private","SAME_PACKAGE"},
            {"default","SAME_PACKAGE"},
            {"default","DIFFERENT_PACKAGE"},
            {"protected","SAME_PACKAGE"},
            {"protected","SAME_CLASS"},
            {"public","DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(attempts));
        
        try {
            new LibraryMember("LB9", "BR1", 0, "Priya Nair");
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
    }
}
