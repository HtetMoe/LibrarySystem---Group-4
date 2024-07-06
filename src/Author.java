public class Author extends Person {
    private String credentials;
    private String bio;

    public Author(String id, String firstName, String lastName, String phone, Address address,
                  String credentials, String bio) {
        super(id, firstName, lastName, phone, address);
        this.credentials = credentials;
        this.bio = bio;
    }
}
