public class prog4 {
    final static class BoardingPenaltyCalculator {
        private final double minimumPenaltyPercent;

        public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
            this.minimumPenaltyPercent = minimumPenaltyPercent;
        }

        public final double calculatePenalty(double ticketFare, int minutesLate) {
            if (ticketFare < 0 || minutesLate < 0) {
                throw new IllegalArgumentException("Negative inputs not allowed");
            }
            if (minutesLate == 0) {
                return 0.0;
            }

            double penalty = 0.0;
            
            // Tier 1: Minutes 1-5 (0.5%)
            int tier1Mins = Math.min(minutesLate, 5);
            penalty += tier1Mins * (0.005 * ticketFare);
            
            // Tier 2: Minutes 6-15 (1%)
            if (minutesLate > 5) {
                int tier2Mins = Math.min(minutesLate - 5, 10);
                penalty += tier2Mins * (0.01 * ticketFare);
            }
            
            // Tier 3: Minutes 16+ (2%)
            if (minutesLate > 15) {
                int tier3Mins = minutesLate - 15;
                penalty += tier3Mins * (0.02 * ticketFare);
            }

            double floorPenalty = ticketFare * (minimumPenaltyPercent / 100.0);
            return Math.max(penalty, floorPenalty);
        }
    }

    public static void main(String[] args) {
        BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
        System.out.println("Rs " + calc.calculatePenalty(1000, 0));
        System.out.println("Rs " + calc.calculatePenalty(1000, 1));
        System.out.println("Rs " + calc.calculatePenalty(1000, 16));
    }
}
