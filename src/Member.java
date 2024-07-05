import java.util.List;

public class Member extends Role {
    //checkoutentry
    private CheckOutEntry checkOutEntry;



    //check book is available
    public boolean checkAvailability(String ISBN) {
        Book book = DataAccessFacade.getInstance().findBookByISBN(ISBN);

        if (book != null) {
            List<BookCopy> copies = book.getCopies();
            for (BookCopy copy : copies) {
                if (copy.isAvailable()) {
                    return true;
                }
            }
        }
        return false;
    }

    //checkout book
    public void checkoutBook(String ISBN) {
    }
    public void checkoutBook(Book book){
        int getMaxLength = book.getMaxLengthForRent();
        BookCopy bookCopy = book.getAvailableBookCopy();
        if (bookCopy == null){
            return;
        }
        CheckOutEntry checkOutEntry = new CheckOutEntry(bookCopy,this,"today","book.getMaxLength+today");
        this.checkOutEntry = checkOutEntry;
        bookCopy.setCheckOutEntry(checkOutEntry);
        bookCopy.setAvailable(false);
        DataAccess dataAccess = DataAccessFacade.getInstance();
        CheckRecord checkRecord = dataAccess.getCheckRecord();
        checkRecord.addEntry(checkOutEntry);
    }
}
