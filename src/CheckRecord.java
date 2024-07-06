import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckRecord implements Serializable {
    private List<CheckOutEntry> entries = new ArrayList<>();

    public List<CheckOutEntry> getEntries() {
        return entries;
    }
    public void addEntry(CheckOutEntry checkOutEntry){
        this.entries.add(checkOutEntry);
    }
}
