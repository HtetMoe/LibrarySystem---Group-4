public class CheckOutEntry {

    private Book book;
    private Member member;

    private String checkoutDate;
    private String dueDate;
    private String datePaid;
    private double fineAmount;

    public boolean isOverdue(){
        return true;
    }
}
