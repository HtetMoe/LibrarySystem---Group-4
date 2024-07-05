import java.util.List;

public class CheckRecord {
    private List<CheckOutEntry> entries;

    public List<CheckOutEntry> getEntries() {
        return entries;
    }
    public void addEntry(CheckOutEntry checkOutEntry){
        this.entries.add(checkOutEntry);
    }
}
