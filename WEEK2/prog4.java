public class prog4 {
    public static void main(String[] args) {
        String phone1 = "9876543210";
        System.out.println("Input: \"" + phone1 + "\"");
        System.out.println(maskPhoneNumber(phone1));

        String phone2 = "98765";
        System.out.println("\nInput: \"" + phone2 + "\"");
        System.out.println(maskPhoneNumber(phone2));
    }

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        StringBuilder masked = new StringBuilder("XXXXXX");
        String last4 = phone.substring(6);
        
        masked.insert(masked.length(), "-");
        masked.append(last4);
        
        return masked.toString();
    }
}
