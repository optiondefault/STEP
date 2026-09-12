// Explanation of static misuse:
// static String name: The name is unique to each member. Making it static means all members share the same name, and the last one created overwrites it for everyone.
// static String memberId: Each member needs a unique ID. Making it static means all members share the same ID.
// static int booksIssued: Books issued are per member. Static makes it a global count of books issued across all members rather than tracking individual issues.

class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(String n, String id, int books) {
        name = n;
        memberId = id;
        booksIssued = books;
    }
}

class FixedLibraryMember {
    String name;
    String memberId;
    int booksIssued;
    
    static String libraryName = "City Library";
    static int memberCount = 0;

    public FixedLibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-100" + memberCount;
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class assign4 {
    public static void main(String[] args) {
        System.out.println("Broken version:");
        BrokenLibraryMember m1 = new BrokenLibraryMember("Aditi", "LM1", 2);
        BrokenLibraryMember m2 = new BrokenLibraryMember("Rohan", "LM2", 5);
        System.out.println(BrokenLibraryMember.name);
        System.out.println(BrokenLibraryMember.name);
        System.out.println("(Aditi's data was overwritten — both members now show \"Rohan\")");

        System.out.println("\nFixed version: same two members created");
        FixedLibraryMember f1 = new FixedLibraryMember("Aditi", 2);
        FixedLibraryMember f2 = new FixedLibraryMember("Rohan", 5);
        f1.printMemberCard();
        f2.printMemberCard();
        FixedLibraryMember.printTotalMembers();
    }
}
