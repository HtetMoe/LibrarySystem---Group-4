import java.util.List;

public class Member extends Role {

    //check book is available
    public boolean checkAvailability(String ISBN) {
        DataAccess dataAccess = new DataAccessFacade();
        Book book = dataAccess.findBookByISBN(ISBN);

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
}
