import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private String ISBN;
    private List<Author> authors;
    private List<BookCopy> copies;
    private final int borrowedDuration;

    public Book(String title, String ISBN, List<Author> authors, List<BookCopy> copies, int maxLengthForRent) {
        this.title = title;
        this.ISBN = ISBN;
        this.authors = authors;
        this.copies = copies;
        this.borrowedDuration = maxLengthForRent;
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
