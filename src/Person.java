import java.io.Serializable;

public class Person implements Serializable {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private Role role;


    protected Person(String id,String firstName, String lastName, String phone,Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public static Person createMember(String id, String firstName, String lastName, String phone, String street, String city, String state, String zip, AuthorizationLevel level){
        Address address = new Address(street,city,state,zip);
        Person person = new Person(id,firstName,lastName,phone,address);
        person.CreateRole(level);
        return person;
    }
    public static Author createAuthor(String id, String firstName, String lastName, String phone, String street, String city, String state, String zip,String credential, String bio){
        Address address = new Address(street,city,state,zip);
        Author author = new Author(id,firstName,lastName,phone,address,credential,bio);
        return author;
    }
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void CreateRole(AuthorizationLevel level) {
        this.role = Role.createPersonFactory(level);
    }

    public static Person login(String id, String password){
        DataAccess dataAccess = DataAccessFacade.getInstance();
        Person person = dataAccess.findPersonById(id);

        if (person != null && person.getPassword().equals(password)) {
            return person;
        }
        return null;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
