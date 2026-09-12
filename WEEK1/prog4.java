import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class prog4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to find the first non-repeating character: ");
        String text = scanner.nextLine();
        
        char result = findFirstNonRepeatingChar(text);
        
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        
        scanner.close();
    }

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0'; // Return null character if string is empty
        }
        
        Map<Character, Integer> charCounts = new HashMap<>();
        
        // Compute frequency of every character
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        
        // Scan string left to right for first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }
        
        return '\0'; // Return null character if no non-repeating character found
    }
}
