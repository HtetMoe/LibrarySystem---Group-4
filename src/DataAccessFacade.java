import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAccessFacade implements DataAccess{

    private Map<String, Person> personMap;
    private Map<String, Book> bookMap;
    private CheckRecord checkRecord;

    private static DataAccessFacade instance;

    DataAccessFacade(){
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
        personMap.put("member", new Person("member", "123"));
        personMap.put("admin", new Person("admin","123" ));
        personMap.put("librarian", new Person("librarian", "123"));
//
//         Adding sample books and copies
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

    @Override
    public boolean addPerson(String id, Person person){
        if(personMap.containsKey(id)){
            return false;
        }
        personMap.put(id, person);
        return true;
    }

    @Override
    public boolean addBook(String id, Book book){
        if(bookMap.containsKey(id)){
            return false;
        }
        bookMap.put(id, book);
        return true;
    }

    @Override
    public CheckRecord getCheckRecord() {
       return this.checkRecord;
    }
    public List<Book> getBooks(){
        List<Book> temp = new ArrayList<>();
        bookMap.forEach((_,v)-> temp.add(v));
        return temp;
    }
}
