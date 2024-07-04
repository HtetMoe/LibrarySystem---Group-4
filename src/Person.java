public class Person {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private Role role;

    public Person(String id, String firstName, String lastName, String phone, Address address, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
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

//        if(person = null){}
        if (person != null && person.getPassword().equals(password)) {
            return person;
        }
        return null;
    }
}
