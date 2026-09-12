public class prog2 {
    static class FareSplitter {
        private String tripId;
        private double totalFare;
        private int passengerCount;

        public FareSplitter(String tripId, double totalFare, int passengerCount) {
            if (totalFare < 0) {
                throw new IllegalArgumentException("Fare cannot be negative");
            }
            if (passengerCount <= 0) {
                throw new IllegalArgumentException("Passenger count must be positive");
            }
            this.tripId = tripId;
            this.totalFare = totalFare;
            this.passengerCount = passengerCount;
        }

        public FareSplitter(String tripId, double totalFare) {
            this(tripId, totalFare, 1);
        }

        public FareSplitter(String tripId) {
            this(tripId, 0.0, 1);
        }

        public double[] fareBreakdown() {
            if (passengerCount <= 0) return new double[0];
            double[] shares = new double[passengerCount];
            // Compute in exact integer paisa to avoid float division loss
            long totalPaisa = Math.round(totalFare * 100);
            long baseSharePaisa = totalPaisa / passengerCount;
            long remainderPaisa = totalPaisa % passengerCount;

            for (int i = 0; i < passengerCount; i++) {
                long sharePaisa = baseSharePaisa;
                // Distribute leftover paisas starting from the end
                if (i >= passengerCount - remainderPaisa) {
                    sharePaisa++;
                }
                shares[i] = sharePaisa / 100.0;
            }
            return shares;
        }

        public boolean isConfirmationOverdue(int confirmed, int expected) {
            return confirmed < expected;
        }
    }

    public static void main(String[] args) {
        FareSplitter fs1 = new FareSplitter("TRIP001", 100000, 3);
        double[] bd1 = fs1.fareBreakdown();
        System.out.print("[");
        for(int i = 0; i < bd1.length; i++) {
            System.out.print(bd1[i] + (i < bd1.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        FareSplitter fs2 = new FareSplitter("TRIP003");
        double[] bd2 = fs2.fareBreakdown();
        System.out.print("[");
        for(int i = 0; i < bd2.length; i++) {
            System.out.print(bd2[i] + (i < bd2.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
