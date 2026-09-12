public class assign4 {
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        
        System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
        analyzeInventory(sectionA, sectionB);
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Sections must have the same number of items.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        
        int highestQuantity = -1;
        String highestSection = "";
        int highestItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1; // 1-based indexing for "Item"
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemIndex);
    }
}
