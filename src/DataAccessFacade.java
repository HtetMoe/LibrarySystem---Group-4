import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAccessFacade implements DataAccess{

    private Map<String, Person> personMap;
    private Map<String, Book> bookMap;
    private CheckRecord checkRecord = new CheckRecord();

    private static DataAccessFacade instance;

    enum SaveType{
        CHECKRECORD, PERSONMAP, BOOKMAP;
    }

    public static final String OUTPUTDIR = System.getProperty("user.dir") + "\\save";

    public  void saveObject(){
        FileOutputStream fileOutputStreamCheckRecord = null;
        FileOutputStream fileOutputStreamBookMap = null;
        FileOutputStream fileOutputStreamPersonMap = null;
        String checkRecord = SaveType.CHECKRECORD.toString()+".bin";
        String bookmap = SaveType.BOOKMAP.toString()+".bin";
        String personMap = SaveType.PERSONMAP.toString()+".bin";
        try{
            fileOutputStreamBookMap = new FileOutputStream(bookmap);
            fileOutputStreamCheckRecord = new FileOutputStream(checkRecord);
            fileOutputStreamPersonMap = new FileOutputStream(personMap);
            ObjectOutputStream objectOutputStreamBookMap = new ObjectOutputStream(fileOutputStreamBookMap);
            ObjectOutputStream objectOutputStreamCheckRecord = new ObjectOutputStream(fileOutputStreamCheckRecord);
            ObjectOutputStream objectOutputStreamPersonMap = new ObjectOutputStream(fileOutputStreamPersonMap);
            objectOutputStreamPersonMap.writeObject(this.personMap);
            objectOutputStreamCheckRecord.writeObject(this.checkRecord);
            objectOutputStreamBookMap.writeObject(this.bookMap);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void retrieveObject(){
        FileInputStream fileInputStreamCheckRecord = null;
        FileInputStream fileInputStreamBookMap = null;
        FileInputStream fileInputStreamPersonMap = null;
        String checkRecord = SaveType.CHECKRECORD.toString()+".bin";
        String bookmap = SaveType.BOOKMAP.toString()+".bin";
        String personMap = SaveType.PERSONMAP.toString()+".bin";
        try {
            fileInputStreamBookMap = new FileInputStream(bookmap);
            fileInputStreamCheckRecord = new FileInputStream(checkRecord);
            fileInputStreamPersonMap = new FileInputStream(personMap);

            if (fileInputStreamBookMap.available() == 0 || fileInputStreamCheckRecord.available() == 0 || fileInputStreamPersonMap.available() == 0) {
                throw new IOException("One of the files is empty or corrupted");
            }


            ObjectInputStream objectInputStreamBookMap = new ObjectInputStream(fileInputStreamBookMap);
            ObjectInputStream objectInputStreamCheckRecord = new ObjectInputStream(fileInputStreamCheckRecord);
            ObjectInputStream objectInputStreamPersonMap = new ObjectInputStream(fileInputStreamPersonMap);
            this.personMap = (Map<String, Person>) objectInputStreamPersonMap.readObject();
            this.bookMap = (Map<String, Book>) objectInputStreamBookMap.readObject();
            this.checkRecord = (CheckRecord) objectInputStreamCheckRecord.readObject();
        } catch (FileNotFoundException e) {
            this.personMap = new HashMap<String, Person>();
            this.bookMap = new HashMap<String, Book>();
            this.checkRecord = new CheckRecord();
            //throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


//        ObjectInputStream in = null;
//        Object retVal = null;
//        try{
//            Path path = FileSystems.getDefault().getPath(OUTPUTDIR, type.toString());
//            in = new ObjectInputStream(Files.newInputStream(path));
//            retVal = in.readObject();
//            return retVal;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return retVal;
    }

    public DataAccessFacade(){
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
//        personMap.put("user1", new Person("user1", "password1", .MEMBER));
//        personMap.put("admin", new Person("admin", "adminpass", Role.ADMIN));
//        personMap.put("librarian", new Person("librarian", "libpass", Role.LIBRARIAN));

        // Adding sample books and copies
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
//        if(personMap.containsKey(id)){
//            return false;
//        }
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

    public List<Person> getAllPeople() {
       List<Person> persons = new ArrayList<>();
       personMap.forEach((_,v)-> persons.add(v));
       return persons;
    }

    //delete below

    public void print(){
        this.bookMap.forEach((k,v)->
                System.out.println(k+" book map"+v.getAuthor().toString()));
        this.personMap.forEach((k,v)-> System.out.println(k+" person "+v.getId()));
    }
}
