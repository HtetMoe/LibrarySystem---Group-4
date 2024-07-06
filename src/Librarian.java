import java.io.Serializable;
import java.util.List;

public class Librarian extends Role implements Serializable {

    /*
    checkout book by Librarian
    ask memberId and ISBN for input
     */

    public static boolean checkoutBook(String id, String ISBN){
        Person person = DataAccessFacade.getInstance().findPersonById(id);
        if (person == null){
            return false;
        }
        Book book = null;
        Role role = person.getRole();
        if (role instanceof Member){
             book = DataAccessFacade.getInstance().findBookByISBN(ISBN);
            Member member = (Member) role;
            return member.checkoutBook(book);
        }
        return false;
    }

    /*

     */
    public static List<Book> findOverdue(){
        List<Book> temp = null;
        List<Book> books = DataAccessFacade.getInstance().getBooks();
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
