public class assign1 {
    static class FoodOrder {
        private String studentName;
        private String dishName;
        private boolean isDelivered;

        public FoodOrder(String studentName, String dishName) {
            if (studentName == null || studentName.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid student name");
            }
            if (dishName == null || dishName.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid dish name");
            }
            this.studentName = studentName.trim();
            this.dishName = dishName.trim();
            this.isDelivered = false;
        }

        public void markDelivered() {
            if (isDelivered) {
                System.out.println("Warning: Order for " + studentName + " was already marked delivered!");
            } else {
                isDelivered = true;
            }
        }
    }

    public static void processBatch(String[][] rawOrders) {
        int validCount = 0;
        int rejectedCount = 0;

        for (String[] raw : rawOrders) {
            if (raw == null || raw.length != 2) {
                rejectedCount++;
                continue;
            }
            try {
                new FoodOrder(raw[0], raw[1]);
                validCount++;
            } catch (IllegalArgumentException e) {
                rejectedCount++;
            }
        }
        System.out.println("Valid: " + validCount + " | Rejected: " + rejectedCount);
    }

    public static void main(String[] args) {
        String[][] rawOrders = {
            {"Ravi", "Paneer Butter Masala"},
            {"", "Chole Bhature"},
            {"Meera", " "},
            {"Divya", "Veg Biryani"}
        };
        processBatch(rawOrders);
    }
}
