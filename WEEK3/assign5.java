class Employee {
    String empId;
    String empName;
    double salary;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class ManagerEmployee extends Employee {
    private double teamBonus;

    public ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    public double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}

class InternEmployee extends Employee {
    private double stipendCap;

    public InternEmployee(String empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    public double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}

class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public void allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
        }
    }
}

class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;
    
    static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId, Employee employee) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        totalRecords++;
    }

    public void assignSlot(ParkingSlot slot) {
        this.slot = slot;
        if (slot != null) {
            slot.allot(empId);
        }
    }

    public String fullProfile() {
        String slotDisplay = (slot != null) ? slot.slotNo : "no parking assigned";
        double effectivePay = 0.0;
        
        if (employee instanceof ManagerEmployee) {
            effectivePay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            effectivePay = ((InternEmployee) employee).effectiveSalary();
        } else if (employee != null) {
            effectivePay = employee.getSalary();
        }
        
        return name + " | Pay: Rs " + effectivePay + " | Slot: " + slotDisplay;
    }
}

public class assign5 {
    public static void main(String[] args) {
        System.out.println("3 records; parking allotted to 2 of them\n");
        
        ParkingSlot slot1 = new ParkingSlot("A1", 1, 0);
        ParkingSlot slot2 = new ParkingSlot("A2", 1, 0);

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "E1", new ManagerEmployee("E1", "Divya", 70000, 8000));
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E2", new Employee("E2", "Karan", 40000));
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "E3", new InternEmployee("E3", "Meera", 12000, 10000));

        r1.assignSlot(slot1);
        r2.assignSlot(slot2);
        // r3 is left unallotted

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());

        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
