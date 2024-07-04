public class Person {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private Role role;

    public Person(String id, String firstName, String lastName, String phone, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public void CreateRole(AuthorizationLevel level) {
        this.role = Role.createPersonFactory(level);
    }

    public void login(){

    }
}
