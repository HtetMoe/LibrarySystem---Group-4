import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private String ISBN;
    private List<Author> authors;
    private List<BookCopy> copies;
    public Book(String title, String ISBN, List<Author> authors, List<BookCopy> copies) {
        this.title = title;
        this.ISBN = ISBN;
        this.authors = authors;
        this.copies = copies;
    }



    //check out entry
    public void checkout(){

    }

    //check availability
    public boolean isAvailable(){
        return true;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    //add copy
    public void addCopy(BookCopy copy){
        copies.add(copy);
    }
}
