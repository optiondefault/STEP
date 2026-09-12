public class prog5 {
    static class BusTicketAccount {
        String bookingId;
        double ticketFare;
        
        static double flatRatePenalty;

        static {
            flatRatePenalty = 10.0; // Flat-rate version for simplicity
        }

        public BusTicketAccount(String bookingId, double ticketFare) {
            this.bookingId = bookingId;
            this.ticketFare = ticketFare;
        }

        public BusTicketAccount(String bookingId) {
            this(bookingId, 1000.0);
        }

        public final double calculatePenalty(int minutesLate) {
            if (minutesLate <= 0) return 0.0;
            return flatRatePenalty * minutesLate;
        }
    }

    static class SleeperAccount extends BusTicketAccount {
        public SleeperAccount(String bookingId, double ticketFare) {
            super(bookingId, ticketFare);
        }
    }

    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        if (accounts == null || amounts == null || minutesLateArray == null) {
            System.out.println("Invalid batch: Arrays cannot be null");
            return;
        }
        
        // Handle mismatched lengths defensively
        int len = Math.min(accounts.length, Math.min(amounts.length, minutesLateArray.length));
        
        int processed = 0;
        int nullSkipped = 0;
        int sleeper = 0;
        int regular = 0;
        double totalPenalties = 0;

        for (int i = 0; i < len; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }
            
            if (accounts[i] instanceof SleeperAccount) {
                sleeper++;
            } else {
                regular++;
            }
            
            processAccount(accounts[i], amounts[i], minutesLateArray[i]);
            totalPenalties += accounts[i].calculatePenalty(minutesLateArray[i]);
            processed++;
        }

        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + sleeper + " sleeper | " + regular + " regular | grand total penalties = " + totalPenalties);
    }
    
    public static void processAccount(BusTicketAccount account, double amount, int minutesLate) {
        // mock processing
    }

    public static void main(String[] args) {
        BusTicketAccount[] accounts = {
            new SleeperAccount("BK001", 2000), 
            null,
            new BusTicketAccount("BK002", 1200)
        };
        double[] amounts = {1200, 900, 700};
        int[] minutesLateArray = {10, 5, 0};
        
        processBatch(accounts, amounts, minutesLateArray);
    }
}
