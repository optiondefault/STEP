public class assign5 {
    static class DeliveryAccount {
        String studentId;
        double orderValue;
        
        static double flatRateSurge;

        static {
            flatRateSurge = 5.0; // Flat-rate version logic
        }

        public DeliveryAccount(String studentId, double orderValue) {
            this.studentId = studentId;
            this.orderValue = orderValue;
        }

        public DeliveryAccount(String studentId) {
            this(studentId, 300.0);
        }

        public final double calculateSurgeFee(int delayMinutes) {
            if (delayMinutes <= 0) return 0.0;
            return flatRateSurge * delayMinutes;
        }
    }

    static class PremiumAccount extends DeliveryAccount {
        public PremiumAccount(String studentId, double orderValue) {
            super(studentId, orderValue);
        }
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts == null || amounts == null || delayMinutesArray == null) {
            System.out.println("Invalid batch: Arrays cannot be null");
            return;
        }
        
        // Defensive bounds check for unequal array lengths
        int len = Math.min(accounts.length, Math.min(amounts.length, delayMinutesArray.length));
        
        int processed = 0;
        int nullSkipped = 0;
        int premium = 0;
        int regular = 0;
        double totalSurgeFees = 0;

        for (int i = 0; i < len; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }
            
            if (accounts[i] instanceof PremiumAccount) {
                premium++;
            } else {
                regular++;
            }
            
            processAccount(accounts[i], amounts[i], delayMinutesArray[i]);
            totalSurgeFees += accounts[i].calculateSurgeFee(delayMinutesArray[i]);
            processed++;
        }

        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + premium + " premium | " + regular + " regular | grand total surge fees = " + totalSurgeFees);
    }
    
    public static void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        // mock processing method
    }

    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumAccount("STU001", 500), 
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delayMinutesArray = {10, 5, 0};
        
        processBatch(accounts, amounts, delayMinutesArray);
    }
}
