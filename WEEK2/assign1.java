public class assign1 {
    public static void main(String[] args) {
        String pin1 = "482";
        System.out.println("Input: \"" + pin1 + "\"");
        checkPinLength(pin1);

        String pin2 = "4820";
        System.out.println("\nInput: \"" + pin2 + "\"");
        checkPinLength(pin2);
    }

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
