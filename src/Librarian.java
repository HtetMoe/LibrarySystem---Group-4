import java.util.List;

public class Librarian extends Role{

    /*
    checkout book by Librarian
    ask memberId and ISBN for input
     */

    public void checkoutBook(String id, String ISBN){
        DataAccess dataAccess = DataAccessFacade.getInstance();
        Person person = dataAccess.findPersonById(id);
        Book book = null;
        if (person.getRole() instanceof Member){
             book = dataAccess.findBookByISBN(ISBN);
            Member member = (Member) person.getRole();
            member.checkoutBook(book);
        }

    }

    /*

     */
    public List<Book> findOverdue(){
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
}
