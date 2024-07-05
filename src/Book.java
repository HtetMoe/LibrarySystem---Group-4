import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private String ISBN;
    private List<Author> authors;
    private List<BookCopy> copies;
    private final int borrowedDuration;

    private Book(String title, String ISBN, List<Author> authors, List<BookCopy> copies, int borrowedDuration) {
        this.title = title;
        this.ISBN = ISBN;
        this.authors = authors;
        this.copies = copies;
        this.borrowedDuration = borrowedDuration;
    }

    public static Book createBookWithAuthor(String ISBN,String title,
                                     String id, String firstName,String lastName, String phone,
                                     String street,String city,String state, String zip,String credential,String bio,
                                     int copies, int borrowDuration){
        List<Author> authorList = new ArrayList<>();
        authorList.add(Person.createAuthor(id,firstName,lastName,phone,street,city,state,zip,credential,bio));
        List<BookCopy> bookCopies = new ArrayList<>();
        for (int i = 1; i<=copies;i++){
            BookCopy bookCopy = new BookCopy(i,true);
            bookCopies.add(bookCopy);
        }
        return new Book(title,ISBN,authorList,bookCopies,borrowDuration);
    }

    //check out entry
    public void checkout() {

    }

    //check availability
    public boolean isAvailable() {
        return true;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public BookCopy getAvailableBookCopy() {
        for (BookCopy bookCopy : copies) {
            if (bookCopy.isAvailable()) return bookCopy;
        }
        return null;
    }

    //add copy
    public void addCopy(BookCopy copy) {
        copies.add(copy);

        //save
    }

    public int getBorrowedDuration() {
        return borrowedDuration;
    }

    public boolean isOverDue() {
        for (BookCopy bookCopy : copies) {
            if (bookCopy.isOverdue()) return true;
        }
        return false;
    }
}
