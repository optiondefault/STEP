public class prog1 {
    public static void main(String[] args) {
        String input = "Java Programming";
        System.out.println("Input: \"" + input + "\"");
        countVowelsAndConsonants(input);
    }

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lowerText = text.toLowerCase();
        
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            // Ignore spaces and non-alphabet characters
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
}
