public abstract class Role {

    public Role() {
    }

    public static Role createPersonFactory(AuthorizationLevel level) {
        return switch (level) {
            case ADMIN -> new Administrator();
            case LIBRARIAN -> new Librarian();
            case MEMBER -> new Member();
        };
    }
}
