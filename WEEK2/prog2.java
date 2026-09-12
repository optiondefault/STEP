public class prog2 {
    public static void main(String[] args) {
        String csv1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("Input: \"" + csv1 + "\"");
        parseStudentRecord(csv1);

        String csv2 = "Ananya Verma,CSE";
        System.out.println("\nInput: \"" + csv2 + "\"");
        parseStudentRecord(csv2);
    }

    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length == 3) {
            String formatted = "Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim() + " | Dept: " + fields[2].trim();
            System.out.println(formatted);
        } else {
            System.out.println("Invalid Record");
        }
    }
}
