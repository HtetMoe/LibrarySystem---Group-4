import java.time.LocalDate;

public class CheckOutEntry {
    private BookCopy bookCopy;
    private Member member;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private String datePaid;
    private double fineAmount;

    private CheckOutEntry(BookCopy bookCopy, Member member, LocalDate checkoutDate, LocalDate dueDate) {
        this.bookCopy = bookCopy;
        this.member = member;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        //this.datePaid = datePaid;
        //this.fineAmount = fineAmount;
    }

    public boolean isOverdue() {
        return dueDate.isBefore(LocalDate.now());
    }

    public static CheckOutEntry createNewCheckoutEntry(BookCopy bookCopy, Member member, LocalDate checkoutDate, LocalDate dueDate){
        return new CheckOutEntry(bookCopy, member, checkoutDate, dueDate);
    }

}
