public class assign5 {
    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review + "\"");
        classifyWordLengths(review);
    }

    public static void classifyWordLengths(String review) {
        if (review == null || review.isEmpty()) {
            System.out.println("Review is empty.");
            return;
        }

        // Split by spaces. In a real scenario, you might want to handle punctuation better,
        // e.g., review.replaceAll("[^a-zA-Z ]", "").split("\\s+")
        String[] words = review.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
}
