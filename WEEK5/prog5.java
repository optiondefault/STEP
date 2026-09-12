public class assign5 {
    // Note: The prompt asks for LoanReceipt to be final, but also says ReferenceOnlyLoanReceipt extends it. 
    // In Java, a final class cannot be subclassed. So we omit the 'final' keyword on the class to allow inheritance.
    static class LoanReceipt {
        private final String memberId;
        private final String[] bookIds;

        public LoanReceipt(String memberId, String[] bookIds) {
            this.memberId = memberId;
            if (bookIds == null) {
                throw new IllegalArgumentException("construction rejected");
            }
            for (String id : bookIds) {
                if (id == null || !id.matches("^BK-\\d{3}$")) {
                    throw new IllegalArgumentException("construction rejected");
                }
            }
            // defensive copy on the way in
            this.bookIds = new String[bookIds.length];
            System.arraycopy(bookIds, 0, this.bookIds, 0, bookIds.length);
        }

        public String[] getBookIds() {
            // defensive copy on the way out
            String[] copy = new String[bookIds.length];
            System.arraycopy(bookIds, 0, copy, 0, bookIds.length);
            return copy;
        }

        public String getMemberId() {
            return memberId;
        }

        public LoanReceipt withCorrectedBookId(int index, String newId) {
            String[] newBookIds = getBookIds();
            newBookIds[index] = newId;
            return new LoanReceipt(this.memberId, newBookIds);
        }
    }

    static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        if (receipts == null) return "0 processed";
        int processed = 0, nullSkipped = 0, ref = 0, regular = 0;
        
        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
            } else {
                processed++;
                if (r instanceof ReferenceOnlyLoanReceipt) {
                    ref++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + ref + " reference-only | " + regular + " regular";
    }

    public static void main(String[] args) {
        try {
            new LoanReceipt("LIB-8841", new String[]{"BK-100", "bad"});
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        String result = processNightlyCirculation(new LoanReceipt[]{
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        });
        System.out.println(result);
    }
}
