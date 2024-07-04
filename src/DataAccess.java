public interface DataAccess {
  
    Person findPersonById(String id);

    Book findBookByISBN(String isbn);
}
