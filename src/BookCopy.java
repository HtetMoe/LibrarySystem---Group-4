public class BookCopy {
    private String copyNumber;
    private boolean isAvailable;

    public BookCopy(String copyNumber, boolean isAvailable) {
        this.copyNumber = copyNumber;
        this.isAvailable = isAvailable;
    }

    //getters
    public String getCopyNumber() {
        return copyNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
