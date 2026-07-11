package myExperiments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        for (int i = 0; i < 15; i++) {
            library.addNewBooks(new Book(4+ i, "title" + i, "author" + i,200 + i, "genre" + i, true));
        }
    }

    @Test
    public void add15Books() {
        assertEquals(15, library.size());
    }

    @Test
    public void testAddNewBooks() {
        library.addNewBooks(new Book(16, "title16", "author16", 20016, "genre16", true));
        assertEquals(16, library.size());
    }

    @Test
    public void testRemoveBook() {
        assertEquals("Book{id=5, title='title1', author='author1', year=201, genre='genre1', available=true}",
                library.getBookById(5).toString());
        library.removeBook(5);
        assertThrows(IllegalArgumentException.class, () -> library.getBookById(5));
        assertEquals(14, library.size());
    }

    @Test
    public void changeBookStatus(){
        Book book = library.getBookById(5);
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testGetBookById() {
        assertEquals("Book{id=5, title='title1', author='author1', year=201, genre='genre1', available=true}",
                library.getBookById(5).toString());
    }

    @Test
    public void testGetAllBooks() {
        assertEquals(15, library.getAllBooks().size());
    }

    @Test
    public void findBookWithWrongId(){
        assertThrows(IllegalArgumentException.class, () -> library.getBookById(100)
        );
    }

    @Test
    public void testTakeBookById(){
        library.takeBook(5);
        assertFalse(library.getBookById(5).isAvailable());
    }

    @Test
    public void testDoubleTakeBookById(){
        library.takeBook(5);
        assertFalse(library.getBookById(5).isAvailable());
        assertThrows(IllegalArgumentException.class, () -> library.takeBook(5));
    }

    @Test
    public void testReturnBookById(){
        library.takeBook(5);
        assertFalse(library.getBookById(5).isAvailable());
        library.returnBook(5);
        assertTrue(library.getBookById(5).isAvailable());
    }

    @Test
    public void testDoubleReturnBookById(){
        library.takeBook(5);
        assertFalse(library.getBookById(5).isAvailable());
        library.returnBook(5);
        assertTrue(library.getBookById(5).isAvailable());
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(5));
    }

    @Test
    public void testIsBookAvailable(){
        assertTrue(library.isBookAvailable(5));
        library.takeBook(5);
        assertFalse(library.isBookAvailable(5));
        library.returnBook(5);
        assertTrue(library.isBookAvailable(5));
    }
}