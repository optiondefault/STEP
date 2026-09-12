// Explanation of static misuse:
// static String name: Makes 'name' shared across all instances. If one student's name is set, it overwrites the name for everyone.
// static String regNo: Same reason as above. Each student needs a unique registration number, so it must be an instance variable.
// static int attendance: Same reason as above. Attendance is individual.
// Static is only suitable for data shared class-wide, like the university name or total admission count.

class BrokenSrmStudent {
    static String name;
    static String regNo;
    static int attendance;

    public BrokenSrmStudent(String n, String r, int a) {
        name = n;
        regNo = r;
        attendance = a;
    }
}

class FixedSrmStudent {
    String name;
    String regNo;
    int attendance;
    
    static String university = "SRM";
    static int admissionCount = 0;

    public FixedSrmStudent(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        admissionCount++;
        this.regNo = "RA23110030101" + admissionCount;
    }

    public void printIdCard() {
        System.out.println(name + " | " + regNo);
    }

    public static void printTotalAdmissions() {
        System.out.println("Students admitted so far: " + admissionCount);
    }
}

public class prog4 {
    public static void main(String[] args) {
        System.out.println("Broken version:");
        BrokenSrmStudent s1 = new BrokenSrmStudent("Ravi", "RA1", 82);
        BrokenSrmStudent s2 = new BrokenSrmStudent("Meera", "RA2", 74);
        System.out.println(BrokenSrmStudent.name); // Will print Meera
        System.out.println(BrokenSrmStudent.name); // Will print Meera
        System.out.println("(Ravi's data was overwritten — both students now show \"Meera\")");

        System.out.println("\nFixed version: same two students created");
        FixedSrmStudent f1 = new FixedSrmStudent("Ravi", 82);
        FixedSrmStudent f2 = new FixedSrmStudent("Meera", 74);
        f1.printIdCard();
        f2.printIdCard();
        FixedSrmStudent.printTotalAdmissions();
    }
}
