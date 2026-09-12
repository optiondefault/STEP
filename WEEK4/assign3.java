public class assign3 {
    static class Canteen implements Comparable<Canteen> {
        String canteenCode;
        String canteenName;
        int trustScore;

        public Canteen(String canteenCode, String canteenName, int trustScore) {
            this.canteenCode = canteenCode;
            this.canteenName = canteenName;
            this.trustScore = trustScore;
        }

        public Canteen(String canteenCode, String canteenName) {
            this(canteenCode, canteenName, 3);
        }

        @Override
        public int compareTo(Canteen other) {
            if (this.trustScore != other.trustScore) {
                // Descending score
                return Integer.compare(other.trustScore, this.trustScore);
            }
            // Tie-breaker 1: Case-insensitive ascending alphabetical code
            int codeCompare = this.canteenCode.compareToIgnoreCase(other.canteenCode);
            if (codeCompare != 0) return codeCompare;
            
            // Tie-breaker 2: Name length
            return Integer.compare(this.canteenName.length(), other.canteenName.length());
        }
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        Canteen[] sorted = new Canteen[canteens.length];
        System.arraycopy(canteens, 0, sorted, 0, canteens.length);
        
        // Stable Bubble Sort
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j].compareTo(sorted[j + 1]) > 0) {
                    Canteen temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Canteen[] canteens = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("hb1-c", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats") // Defaults to score 3
        };
        
        Canteen[] ranked = rankCanteens(canteens);
        System.out.print("[");
        for (int i = 0; i < ranked.length; i++) {
            System.out.print("\"" + ranked[i].canteenCode + "\"" + (i < ranked.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
