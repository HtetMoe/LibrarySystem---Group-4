import java.io.Serializable;

import static java.lang.StringTemplate.STR;

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
    public static Author createAuthor(String firstName, String lastName, String phone, String street, String city, String state, String zip,String credential, String bio){
        Address address = new Address(street,city,state,zip);
        Author author = new Author("Author",firstName,lastName,phone,address,credential,bio);
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    //will delete below

    public Person(){

    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return STR."userID : \{getId()}, password : \{getPassword()}, role : \{getRole().getClass().getSimpleName()}";
    }
}
