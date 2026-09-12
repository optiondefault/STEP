public class assign2 {
    public static void main(String[] args) {
        String sentence = "hello club";
        System.out.println("Input: \"" + sentence + "\"");
        System.out.println(reverseEachWord(sentence));
    }

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]).reverse();
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
