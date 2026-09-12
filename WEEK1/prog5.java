import java.util.Scanner;

public class prog5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        
        // Hardcoded example if input is empty
        if (name.isEmpty()) {
            name = "Sunil";
        }
        
        System.out.println("Original Name: " + name);
        String reversed = reverseCustomerName(name);
        System.out.println("Reversed Name: " + reversed);
        
        scanner.close();
    }

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        
        char[] nameArray = customerName.toCharArray();
        char[] reversedArray = new char[nameArray.length];
        
        for (int i = 0; i < nameArray.length; i++) {
            reversedArray[i] = nameArray[nameArray.length - 1 - i];
        }
        
        return new String(reversedArray);
    }
}
