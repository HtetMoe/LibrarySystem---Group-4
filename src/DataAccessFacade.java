import java.util.Map;

public class DataAccessFacade implements DataAccess{
    private Map<String, Book> bookMap; // key = ISBN, value = Book


    @Override
    public Book findBookByISBN(String isbn) {
        return bookMap.get(isbn);
    }
}
