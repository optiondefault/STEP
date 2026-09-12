import java.util.Scanner;

public class prog2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check for palindrome: ");
        String text = scanner.nextLine();
        
        String iterativeResult = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recursiveResult = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrayReversalResult = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";
        
        System.out.println("\"" + text + "\" Iterative: " + iterativeResult + " | Recursive: " + recursiveResult + " | Array Reversal: " + arrayReversalResult);
        
        scanner.close();
    }

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanText.length() - 1;
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursive(cleanText);
    }
    
    private static boolean checkRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return checkRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = cleanText.toCharArray();
        char[] reversedArray = new char[charArray.length];
        
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }
        
        String reversedText = new String(reversedArray);
        return cleanText.equals(reversedText);
    }
}
