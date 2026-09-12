public class assign4 {
    public static void main(String[] args) {
        String raw1 = " pen2026004251 ";
        System.out.println("Input: \"" + raw1 + "\"");
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));

        String raw2 = "12N2026004251";
        System.out.println("\nInput: \"" + raw2 + "\"");
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));
    }

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        
        if (trimmed.length() >= 3) {
            String first3 = trimmed.substring(0, 3).toUpperCase();
            String rest = trimmed.substring(3);
            return first3 + rest;
        }
        
        return trimmed.toUpperCase();
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: length must be exactly 13 characters";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }
        
        String pubCode = code.substring(0, 3);
        String yearPart = code.substring(3, 7);
        String catalogPart = code.substring(7, 13);
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] YEAR: ").append(yearPart);
        formatted.append(" | CATALOG: ").append(catalogPart);
        
        return formatted.toString();
    }
}
