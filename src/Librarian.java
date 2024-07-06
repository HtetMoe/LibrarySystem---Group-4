import java.io.Serializable;
import java.util.List;

public class Librarian extends Role implements Serializable {

    /*
    checkout book by Librarian
    ask memberId and ISBN for input
     */

    public static boolean checkoutBook(String id, String ISBN){
        DataAccess dataAccess = DataAccessFacade.getInstance();
        Person person = dataAccess.findPersonById(id);
        if (person == null){
            return false;
        }
        Book book = null;
        if (person.getRole() instanceof Member){
             book = dataAccess.findBookByISBN(ISBN);
            Member member = (Member) person.getRole();
            return member.checkoutBook(book);
        }
        return false;
    }

    /*

     */
    public static List<Book> findOverdue(){
        List<Book> temp = null;
        DataAccess dataAccess = DataAccessFacade.getInstance();
        List<Book> books = dataAccess.getBooks();
        for (Book book:books){
            if (book.isOverDue()) {
                temp.add(book);
            }
        }
        return temp;
    }

    public static void addBookCopy(String ISBN){
        Book book = DataAccessFacade.getInstance().findBookByISBN(ISBN);
        book.addCopy(BookCopy.createBookCopy(book.getCopies().size(),true));
    }
}
