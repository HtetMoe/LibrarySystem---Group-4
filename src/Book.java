import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private String ISBN;
    private List<Author> authors;
    private List<BookCopy> copies;

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
