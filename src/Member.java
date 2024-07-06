import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Member extends Role implements Serializable {
    private CheckOutEntry checkOutEntry;

    //1. check book is available
    public static boolean checkAvailability(String ISBN) {
        Book book = DataAccessFacade.getInstance().findBookByISBN(ISBN); // retrieve book

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

    //2. checkout book, self-checkout
    public boolean checkoutBook(String ISBN) {
        Book book = getBook(ISBN); // retrieve book
        return checkoutBook(book);
    }

    /*
        - CheckoutEntry is association class between Member and book copy
     */

    //3. checkout by librarian
    public boolean checkoutBook(Book book) {
        //Most books may be borrowed for 21 days, but some books only for 7 days.
        int duration = book.getBorrowedDuration();
        BookCopy bookCopy = book.getAvailableBookCopy();

        if (bookCopy == null) {
            System.out.println("No book available.");
            return false;
        }

        CheckOutEntry checkOutEntry = CheckOutEntry.createNewCheckoutEntry(bookCopy, this, LocalDate.now(), LocalDate.now().plusDays(duration));

        //make association with CheckoutEntry and BookCopy
        this.checkOutEntry = checkOutEntry;
        bookCopy.setCheckOutEntry(checkOutEntry);

        //update status
        bookCopy.setAvailable(false);

        //save
        DataAccess dataAccess = DataAccessFacade.getInstance();
        CheckRecord checkRecord = dataAccess.getCheckRecord();
        checkRecord.addEntry(checkOutEntry);
        return true;
    }

    //retrieve book
    private Book getBook(String ISBN) {
        Book book = DataAccessFacade.getInstance().findBookByISBN(ISBN);
        return book;
    }
}
