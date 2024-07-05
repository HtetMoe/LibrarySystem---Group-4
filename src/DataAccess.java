public interface DataAccess {
  
    Person findPersonById(String id);
    boolean addPerson(String id, Person person);
    boolean addBook(String id, Book book);
    Book findBookByISBN(String isbn);
}
