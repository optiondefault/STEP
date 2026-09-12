public class assign1 {
    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.println("Input: {101, 102, 103, 102, 105}");
        checkDuplicateSeats(seats1);

        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.println("\nInput: {101, 102, 103, 104, 105}");
        checkDuplicateSeats(seats2);
    }

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    // Depending on requirements, we might want to break here to avoid 
                    // printing the same duplicate multiple times, but this is simple enough.
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
