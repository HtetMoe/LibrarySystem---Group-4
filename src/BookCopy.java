import java.io.Serializable;

public class BookCopy implements Serializable {
    private int copyNumber;
    private boolean isAvailable;
    private CheckOutEntry checkOutEntry = new CheckOutEntry();

    public BookCopy(int copyNumber, boolean isAvailable) {
        this.copyNumber = copyNumber;
        this.isAvailable = isAvailable;
    }
    public static BookCopy createBookCopy(int copyNumber, boolean isAvailable){
        return new BookCopy(copyNumber, isAvailable);
    }

    //getters
    public int getCopyNumber() {
        return copyNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setCheckOutEntry(CheckOutEntry checkOutEntry){
        this.checkOutEntry = checkOutEntry;
    }
    public boolean isOverdue(){
        if (this.checkOutEntry == null){
        return checkOutEntry.isOverdue();
        }
        return false;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
