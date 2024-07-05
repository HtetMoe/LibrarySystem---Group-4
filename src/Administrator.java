import java.util.List;

public class Administrator extends Role{
    /*
        - add new book
        - create new member
        - edit member info
     */

    public boolean addNewBook(String ISBN, String title, List<Author> authors, List<BookCopy> copies){
        return DataAccessFacade.getInstance().addBook(ISBN, new Book(title, ISBN, authors ,copies));
    }
    public boolean addNewMember(String id, Person person, AuthorizationLevel level){
        person.CreateRole(level);
        return DataAccessFacade.getInstance().addPerson(id, person);
    }
    public boolean editMember(String id, Person person, AuthorizationLevel level){
        if(DataAccessFacade.getInstance().findPersonById(id) == null)
            return false;
        return addNewMember(id, person, level);
    }
}
