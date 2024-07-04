import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DataAccessFacade implements DataAccess{

    private Map<String, Person> personMap;
    private Map<String, Book> bookMap;

    private static DataAccessFacade instance;

    private DataAccessFacade(){
        personMap = new HashMap<String, Person>();
        bookMap = new HashMap<>();
        initializeData();
    }

    public static DataAccessFacade getInstance(){
        if(instance == null){
            instance = new DataAccessFacade();
        }
        return instance;
    }

    private void initializeData() {
        // Adding some sample data
//        personMap.put("user1", new Person("user1", "password1", .MEMBER));
//        personMap.put("admin", new Person("admin", "adminpass", Role.ADMIN));
//        personMap.put("librarian", new Person("librarian", "libpass", Role.LIBRARIAN));

        // Adding sample books and copies
//        Book book1 = new Book("book1", "Sample Book 1");
//        book1.addCopy(new BookCopy("copy1", true));
//        book1.addCopy(new BookCopy("copy2", false));
//        bookMap.put("book1", book1);
//
//        Book book2 = new Book("book2", "Sample Book 2");
//        book2.addCopy(new BookCopy("copy1", false));
//        bookMap.put("book2", book2);
    }

    @Override
    public Person findPersonById(String id) {
        return personMap.get(id);
    }


    @Override
    public Book findBookByISBN(String isbn) {
        return bookMap.get(isbn);
    }
}
