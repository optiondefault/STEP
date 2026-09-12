import java.util.HashSet;
import java.util.Set;

public class prog1 {
    static class BusTicket {
        private String passengerName;
        private String destination;
        private boolean isCheckedIn;

        public BusTicket(String passengerName, String destination) {
            if (passengerName == null || passengerName.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid passenger name");
            }
            // Check for valid characters (meaningful name without digits)
            if (!passengerName.matches("^[a-zA-Z\\s]+$")) {
                throw new IllegalArgumentException("Name contains invalid characters");
            }
            if (destination == null || destination.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid destination");
            }
            this.passengerName = passengerName.trim();
            this.destination = destination.trim();
            this.isCheckedIn = false;
        }

        public void markCheckedIn() {
            if (isCheckedIn) {
                System.out.println("Warning: Already checked in.");
            } else {
                isCheckedIn = true;
            }
        }

        public String getBookingKey() {
            return passengerName.toLowerCase() + "|" + destination.toLowerCase();
        }
    }

    public static void processBatch(String[][] rawBookings) {
        int validCount = 0;
        int rejectedCount = 0;
        int duplicateCount = 0;
        Set<String> acceptedKeys = new HashSet<>();

        for (String[] raw : rawBookings) {
            if (raw == null || raw.length != 2) {
                rejectedCount++;
                continue;
            }
            try {
                BusTicket ticket = new BusTicket(raw[0], raw[1]);
                String key = ticket.getBookingKey();
                if (acceptedKeys.contains(key)) {
                    duplicateCount++;
                } else {
                    acceptedKeys.add(key);
                    validCount++;
                }
            } catch (IllegalArgumentException e) {
                rejectedCount++;
            }
        }
        System.out.println("Valid: " + validCount + " | Rejected: " + rejectedCount + " | Duplicates skipped: " + duplicateCount);
    }

    public static void main(String[] args) {
        String[][] rawBookings = {
            {"Divya", "Chennai"},
            {"", "Bangalore"},
            {"Ravi123", "Pune"},
            {"Divya", "Chennai"},
            {" ", " "}
        };
        processBatch(rawBookings);
    }
}
