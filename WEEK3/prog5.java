class FeeAccount {
    String regNo;
    double totalFee;
    double amountPaid;

    public FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = 0;
    }

    public void pay(double amount) {
        if (amount > 0) {
            this.amountPaid += amount;
        } else {
            System.out.println("Payment rejected: non-positive amount.");
        }
    }

    public double getDue() {
        return totalFee - amountPaid;
    }
}

class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount(String regNo, double totalFee) {
        super(regNo, totalFee);
    }
}

class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    public HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    public void allot(String name) {
        if (occupied < beds) {
            occupied++;
        }
    }
}

class SrmStudent {
    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;
    
    static int totalStudents = 0;

    public SrmStudent(String name, String regNo, HostelFeeAccount feeAccount) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        totalStudents++;
    }

    public void assignRoom(HostelRoom room) {
        this.room = room;
        if (room != null) {
            room.allot(this.name);
        }
    }

    public String fullStatus() {
        String roomDisplay = (room != null) ? room.roomNo : "unallotted";
        double due = (feeAccount != null) ? feeAccount.getDue() : 0.0;
        return name + " | Due: Rs " + due + " | Room: " + roomDisplay;
    }
}

public class prog5 {
    public static void main(String[] args) {
        System.out.println("3 students; rooms allotted to 2 of them;\none payment rejected (negative amount)\n");
        
        HostelRoom room1 = new HostelRoom("C-214", 2, 0);
        HostelRoom room2 = new HostelRoom("C-507", 2, 0);

        SrmStudent s1 = new SrmStudent("Ravi", "R1", new HostelFeeAccount("R1", 200000));
        SrmStudent s2 = new SrmStudent("Anitha", "R2", new HostelFeeAccount("R2", 200000));
        SrmStudent s3 = new SrmStudent("Karthik", "R3", new HostelFeeAccount("R3", 200000));

        s1.assignRoom(room1);
        s2.assignRoom(room2);
        // s3 intentionally left unallotted

        s1.feeAccount.pay(60000);
        s2.feeAccount.pay(20000);
        s3.feeAccount.pay(-500); // rejected payment

        System.out.println(s1.fullStatus());
        System.out.println(s2.fullStatus());
        System.out.println(s3.fullStatus());

        System.out.println("Total students: " + SrmStudent.totalStudents);
    }
}
