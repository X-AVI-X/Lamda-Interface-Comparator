import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> catalog;

    public Library() {
        this.catalog = new ArrayList<>();
    }

    public void addBook(Book book){
        catalog.add(book);
    }
    public List<Book> getBooks(BookPredicate predicate){
        return catalog.stream().filter(predicate::test).collect(Collectors.toList());

    }
    public void removeBooks(BookPredicate predicate){
        catalog.removeIf(predicate::test);
    }
}
