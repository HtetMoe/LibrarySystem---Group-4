public class Author extends Person {
    private String credentials;
    private String bio;

    public Author(String id, String firstName, String lastName, String phone, Address address) {
        super(id, firstName, lastName, phone, address);
    }
}
