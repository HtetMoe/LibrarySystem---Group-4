import java.time.LocalDate;
import java.util.List;

public class Member extends Role {
    private CheckOutEntry checkOutEntry;

    //check book is available
    public boolean checkAvailability(String ISBN) {
        Book book = getBook(ISBN);

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
        Book book = getBook(ISBN);
        checkoutBook(book);
    }

    public void checkoutBook(Book book) {
        int duration = book.getMaxLengthForRent();
        BookCopy bookCopy = book.getAvailableBookCopy();

        if (bookCopy == null) {
            System.out.println("No book available.");
            return;
        }

        CheckOutEntry checkOutEntry = new CheckOutEntry(bookCopy, this, LocalDate.now(), LocalDate.now().plusDays(duration));
        this.checkOutEntry = checkOutEntry;
        bookCopy.setCheckOutEntry(checkOutEntry);
        bookCopy.setAvailable(false);

        //save
        DataAccess dataAccess = DataAccessFacade.getInstance();
        CheckRecord checkRecord = dataAccess.getCheckRecord();
        checkRecord.addEntry(checkOutEntry);
    }

    private Book getBook(String ISBN) {
        Book book = DataAccessFacade.getInstance().findBookByISBN(ISBN);
        return book;
    }
}
