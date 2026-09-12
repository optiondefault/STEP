// Justify why totalFineCollected is static while fineAmount is not:
// totalFineCollected operates on an array of multiple BookIssue objects to compute a global sum, not tied to a single instance.
// fineAmount computes the fine for a single specific BookIssue based on its individual daysOverdue property.

class BookIssue {
    String title;
    String borrowerName;
    int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        return (daysOverdue > 0) ? daysOverdue * 5.0 : 0.0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    public static double totalFineCollected(BookIssue[] issues) {
        double total = 0.0;
        for (BookIssue issue : issues) {
            total += issue.fineAmount();
        }
        return total;
    }
}

public class assign1 {
    public static void main(String[] args) {
        BookIssue[] issues = new BookIssue[5];
        issues[0] = new BookIssue("Clean Code", "Alice", 18);
        issues[1] = new BookIssue("Effective Java", "Bob", 5);
        issues[2] = new BookIssue("Refactoring", "Charlie", 0);
        issues[3] = new BookIssue("DSA Handbook", "David", 21);
        issues[4] = new BookIssue("Design Patterns", "Eve", 9);

        System.out.println("5 books, daysOverdue:");
        for (BookIssue issue : issues) {
            String status = issue.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(issue.title + " - " + issue.daysOverdue + " days - " + status);
        }

        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(issues));
    }
}
