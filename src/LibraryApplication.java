import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryApplication {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Book1", "Author1", "Genre1", 2001));
        library.addBook(new Book("Book2", "Author2", "Genre2", 1996));
        library.addBook(new Book("Book3", "Author1", "Genre3", 2012));
        library.addBook(new Book("Book4", "Author3", "Genre2", 2023));
        library.addBook(new Book("Book5", "Author2", "Genre1", 2016));

        System.out.println("\n All 5 books: \n"+library.getBooks((book)-> true));

        List<Book> books = library.getBooks((book)->true);

        Collections.sort(books, (book1,book2)->book2.getAuthor().compareTo(book1.getAuthor()));
        System.out.println("\n All 5 books after sorting by author name:\n"+ books);

        Collections.sort(books, (book1,book2)->{
            if (book1.getYearPublished() == book2.getYearPublished()) {
                return 0;
            } else if (book2.getYearPublished() > book1.getYearPublished()) {
                return 1;
            } else
            return -1;
        });
        System.out.println("\n All 5 books after sorting by year published:\n"+ books);

        System.out.println("\nBooks of Genre1: \n"+library.getBooks((book)->book.getGenre().equals("Genre1")));
        System.out.println("\nBooks of Author1: \n"+library.getBooks((book)->book.getAuthor().equals("Author1")));
        System.out.println("\nBooks published after year 2010: \n"+library.getBooks((book)->book.getYearPublished()>2010));

        library.removeBooks((book)-> book.getYearPublished() >= 2015);
        
        System.out.println("\nRemoved books published on or after 2015, Remaining books:\n"+library.getBooks((book)->true));


    }
}