// Justify why classAverage is static while isEligible is not:
// classAverage operates on a collection of students and calculates an aggregate metric for the entire class, not tied to any single student instance.
// isEligible evaluates a specific student's attendance, relying on the instance's unique state (the attendance field).

class SrmStudent {
    String name;
    String regNo;
    int attendance;

    public SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public boolean isEligible() {
        return this.attendance >= 75;
    }

    public void addAttendanceUpdate(int newAttendance) {
        this.attendance = newAttendance;
    }

    public static double classAverage(SrmStudent[] students) {
        if (students.length == 0) return 0.0;
        int sum = 0;
        for (SrmStudent s : students) {
            sum += s.attendance;
        }
        return (double) sum / students.length;
    }
}

public class prog1 {
    public static void main(String[] args) {
        SrmStudent[] students = new SrmStudent[5];
        students[0] = new SrmStudent("Ravi", "RA1", 82);
        students[1] = new SrmStudent("Anitha", "RA2", 68);
        students[2] = new SrmStudent("Karthik", "RA3", 91);
        students[3] = new SrmStudent("Meera", "RA4", 74);
        students[4] = new SrmStudent("Suresh", "RA5", 60);

        for (SrmStudent s : students) {
            String status = s.isEligible() ? "Eligible" : "Detained";
            System.out.println(s.name + " - " + s.attendance + "% - " + status);
        }

        System.out.println("Class average: " + SrmStudent.classAverage(students) + "%");
    }
}
