package tests;

import library.Library;
import library.models.Book;
import library.models.BookInstance;
import library.models.Reader;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by vadim on 10.04.2017.
 */
class MainTest {

    private static Library library;

    @AfterEach
    public void clearAll(){
        library = new Library();
    }

    @BeforeAll
    public static void init(){
        library = new Library();
    }

    @Test
    public void buyBookTestCatalog(){
        library.buyBook("Intro to Java", "Schildt", "1241241ada", 5, 2017);
        assertEquals(1, library.getCatalog().size());

        Book book = new Book("Schildt", "Intro to Java", 2017, "1241241ada");
        Book bookFromCatalog = library.getCatalog().iterator().next();

        assertTrue(library.getCatalog().contains(book));

        assertTrue(book.getTitle().equals(bookFromCatalog.getTitle()));
        assertTrue(book.getAuthor().equals(bookFromCatalog.getAuthor()));
        assertTrue(book.getIsbn().equals(bookFromCatalog.getIsbn()));
        assertTrue(book.getYear()==bookFromCatalog.getYear());
    }

    @Test
    public void buyBookTestStore () {
        library.buyBook ( "Intro to Java", "Schildt", "1241241ada", 5, 2017 );
        assertEquals ( 5, library.getStore ().size ());
        Book book = new Book ( "Schildt", "Intro to Java", 2017, "1241241ada" );

        for (BookInstance instance:
                library.getStore ()) {

            Book bookFromStore = instance.getBook ();
            assertTrue ( book.getTitle().equals ( bookFromStore.getTitle() ) );
            assertTrue ( book.getAuthor().equals ( bookFromStore.getAuthor() ) );
            assertTrue ( book.getIsbn().equals ( bookFromStore.getIsbn() ) );
            assertTrue ( book.getYear() == ( bookFromStore.getYear() ) );
        }
    }

    @Test
    public void takeBookReadersTest(){
        Reader reader = new Reader("John", "Connor", "Androidovich", 12345678);
        library.buyBook( "Intro to Java", "Schildt", "1241241ada", 5, 2017 );
        library.takeBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");
        Reader readerFromReaders = library.getReaders().iterator().next();
        assertEquals(1, library.getReaders().size());
        assertTrue(library.getReaders().contains(reader));
        assertEquals(reader, readerFromReaders);


    }



}