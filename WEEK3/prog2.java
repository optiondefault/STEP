class FeeAccount {
    private String regNo;
    private double totalFee;
    private double amountPaid;

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

    public void payInTwoInstallments(double amount) {
        if (amount > 0) {
            pay(amount / 2);
            pay(amount / 2);
        }
    }
}

class ScholarshipFeeAccount extends FeeAccount {
    private double scholarshipPercent;

    public ScholarshipFeeAccount(String regNo, double totalFee, double scholarshipPercent) {
        super(regNo, totalFee);
        this.scholarshipPercent = scholarshipPercent;
    }

    public double effectiveDue() {
        double due = getDue();
        return due - (due * scholarshipPercent / 100.0);
    }
}

public class prog2 {
    public static void main(String[] args) {
        FeeAccount plain = new FeeAccount("R1", 150000);
        plain.pay(150000);

        FeeAccount hostel = new HostelFeeAccount("R2", 200000);
        hostel.pay(60000);

        FeeAccount scholarship = new ScholarshipFeeAccount("R3", 180000, 20);

        FeeAccount[] accounts = {plain, hostel, scholarship};

        for (FeeAccount acc : accounts) {
            if (acc instanceof ScholarshipFeeAccount) {
                System.out.println("Scholarship account effective due: Rs " + ((ScholarshipFeeAccount) acc).effectiveDue());
            } else if (acc instanceof HostelFeeAccount) {
                System.out.println("Hostel account due: Rs " + acc.getDue());
            } else {
                System.out.println("Plain account due: Rs " + acc.getDue());
            }
        }
    }
}
