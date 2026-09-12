public class assign3 {
    public static void main(String[] args) {
        String log1 = "RRGGGYRR";
        System.out.println("Input: \"" + log1 + "\"");
        findLongestStreak(log1);

        String log2 = "RRRRYYGG";
        System.out.println("\nInput: \"" + log2 + "\"");
        findLongestStreak(log2);
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Check the last streak
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreak + " times");
    }
}
