public class CheckOutEntry {
    private BookCopy bookCopy;
    private Member member;
    private String checkoutDate;
    private String dueDate;
    private String datePaid;
    private double fineAmount;
    public boolean isOverdue(){
        return "today".equals( dueDate);
    }

    public CheckOutEntry(BookCopy bookCopy, Member member, String checkoutDate, String dueDate) {
        this.bookCopy = bookCopy;
        this.member = member;
        this.checkoutDate = checkoutDate;
//        this.dueDate = dueDate;
//        this.datePaid = datePaid;
//        this.fineAmount = fineAmount;
    }
}
