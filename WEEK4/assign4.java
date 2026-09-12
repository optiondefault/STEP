public class assign4 {
    final static class SurgeFeeCalculator {
        private final double minimumSurgePercent;

        public SurgeFeeCalculator(double minimumSurgePercent) {
            this.minimumSurgePercent = minimumSurgePercent;
        }

        public final double calculateSurgeFee(double orderValue, int delayMinutes) {
            if (orderValue < 0 || delayMinutes < 0) {
                throw new IllegalArgumentException("Negative inputs not allowed");
            }
            if (delayMinutes == 0) {
                return 0.0;
            }

            double surge = 0.0;
            
            // Minutes 1-5
            int tier1Mins = Math.min(delayMinutes, 5);
            surge += tier1Mins * (0.005 * orderValue);
            
            // Minutes 6-15
            if (delayMinutes > 5) {
                int tier2Mins = Math.min(delayMinutes - 5, 10);
                surge += tier2Mins * (0.01 * orderValue);
            }
            
            // Minutes 16+
            if (delayMinutes > 15) {
                int tier3Mins = delayMinutes - 15;
                surge += tier3Mins * (0.02 * orderValue);
            }

            double floorSurge = orderValue * (minimumSurgePercent / 100.0);
            return Math.max(surge, floorSurge);
        }
    }

    public static void main(String[] args) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
        System.out.println("Rs " + calc.calculateSurgeFee(500, 0));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 1));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 16));
    }
}
