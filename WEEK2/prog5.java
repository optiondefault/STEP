public class prog5 {
    public static void main(String[] args) {
        String ref1 = " hdf03022600042 ";
        System.out.println("Input: \"" + ref1 + "\"");
        String normalized1 = normalizeReference(ref1);
        System.out.println(validateAndFormat(normalized1));

        String ref2 = "12F03022600042";
        System.out.println("\nInput: \"" + ref2 + "\"");
        String normalized2 = normalizeReference(ref2);
        System.out.println(validateAndFormat(normalized2));
    }

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        
        if (trimmed.length() >= 3) {
            String first3 = trimmed.substring(0, 3).toUpperCase();
            String rest = trimmed.substring(3);
            return first3 + rest;
        }
        
        return trimmed.toUpperCase();
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: length must be exactly 14 characters";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }
        
        String bankCode = reference.substring(0, 3);
        String datePart = reference.substring(3, 9);
        String seqPart = reference.substring(9, 14);
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] DATE: ");
        formatted.append(datePart.substring(0, 2)).append("/");
        formatted.append(datePart.substring(2, 4)).append("/");
        formatted.append(datePart.substring(4, 6));
        formatted.append(" | SEQ: ").append(seqPart);
        
        return formatted.toString();
    }
}
