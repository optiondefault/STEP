public class assign2 {
    public static void main(String[] args) {
        String original = "hello world";
        String typed1 = "hello worlt";
        System.out.println("original=\"" + original + "\", typed=\"" + typed1 + "\"");
        checkTypingAccuracy(original, typed1);

        String typed2 = "coding";
        String original4Typed2 = "coding";
        System.out.println("\noriginal=\"" + original4Typed2 + "\", typed=\"" + typed2 + "\"");
        checkTypingAccuracy(original4Typed2, typed2);
    }

    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char originalMismatchChar = '\0';
        char typedMismatchChar = '\0';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else {
                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i + 1; // 1-based indexing for output
                    originalMismatchChar = original.charAt(i);
                    typedMismatchChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matchedCount / original.length()) * 100;

        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                matchedCount, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n", 
                matchedCount, original.length(), accuracy, firstMismatchPosition, originalMismatchChar, typedMismatchChar);
        }
    }
}
