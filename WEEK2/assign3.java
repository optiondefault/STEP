public class assign3 {
    public static void main(String[] args) {
        String csv1 = "Wireless Mouse,WM-2201,150";
        System.out.println("Input: \"" + csv1 + "\"");
        parseInventoryRecord(csv1);

        String csv2 = "Wireless Mouse,150";
        System.out.println("\nInput: \"" + csv2 + "\"");
        parseInventoryRecord(csv2);
    }

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length == 3) {
            System.out.println("Product: " + fields[0].trim() + " | SKU: " + fields[1].trim() + " | Qty: " + fields[2].trim());
        } else {
            System.out.println("Invalid Record");
        }
    }
}
