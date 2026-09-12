import java.util.*;

public class assign5 {
    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + feedback + "\"\n");
        printFilteredWordFrequency(feedback);
    }

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) return;
        
        // Normalize: convert to lowercase and strip punctuation
        String cleaned = feedback.toLowerCase().replace(",", "").replace(".", "");
        String[] words = cleaned.split("\\s+");
        
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());
        
        // Sort descending by value
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
