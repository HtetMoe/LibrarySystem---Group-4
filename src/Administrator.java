import java.io.Serializable;
import java.util.List;

public class Administrator extends Role implements Serializable {
    /*
        - add new book
        - create new member
        - edit member info
     */


    public static boolean addNewBook(String ISBN,String title,
                              String id, String firstName,String lastName, String phone,
                              String street,String city,String state, String zip,String credential, String bio,
                              int copies, int borrowDuration){
        Book book = Book.createBookWithAuthor(ISBN,title,id,firstName,lastName,phone,street,city,state,zip,credential,bio,copies,borrowDuration);
        return DataAccessFacade.getInstance().addBook(ISBN,book);

    }


    public static boolean addMember(String id, String firstName,String lastName, String phone,
                                String street,String city,String state, String zip,
                                AuthorizationLevel level){
        Person person = Person.createMember(id,firstName,lastName,phone,street,city,state,zip,level);
        return DataAccessFacade.getInstance().addPerson(id, person);
    }
    public Person editMember(String id){

        return DataAccessFacade.getInstance().findPersonById(id);

        // in ui will show person, and there is button ok and it will call addMember() from administrator
    }

    public static void main(String[] args) {
        Administrator administrator = new Administrator();
//        boolean b = administrator.addNewBook("111","Love",
//                "001","dd","last","64155",
//                "street","city","state","zip",
//                "credential","bio",2,10);
//        List<Book> book = DataAccessFacade.getInstance().getBooks();
//        System.out.println(book.getFirst().getBorrowedDuration());
//        boolean memberAdded1 = administrator.addMember("001", "John", "Doe", "1234567890",
//                "123 Main St", "Anytown", "Anystate", "12345", AuthorizationLevel.ADMIN);
//
//        // Verifying if the member was added successfully
//        if (memberAdded1) {
//            System.out.println("Member 1 added successfully.");
//        } else {
//            System.out.println("Failed to add member 1.");
//        }
        DataAccessFacade.getInstance().retrieveObject();
        System.out.println(DataAccessFacade.getInstance().findPersonById("001").getRole());
        System.out.println(DataAccessFacade.getInstance().findBookByISBN("111").getBorrowedDuration());
        boolean bookAdded = administrator.addNewBook("121", "Hate",
                "001", "dd", "last", "64155",
                "street", "city", "state", "zip",
                "credential", "bio", 2, 15);
        System.out.println(DataAccessFacade.getInstance().findBookByISBN("121").getBorrowedDuration());
        //DataAccessFacade.getInstance().saveObject();

    }
}
