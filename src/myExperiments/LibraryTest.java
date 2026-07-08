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
            library.addNewBooks(new Book(i, "title" + i, "author" + i,200 + i, "genre" + i, false));
        }
    }

    @Test
    public void add15Books() {
        assertEquals(15, library.size());
    }

    @Test
    public void testAddNewBooks() {
        library.addNewBooks(new Book(16, "title16", "author16", 20016, "genre16", false));
        assertEquals(16, library.size());
    }

    @Test
    public void testRemoveBook() {
        assertEquals("Book{id=1, title='title1', author='author1', year=201, genre='genre1', available=false}",
                library.getBookById(1).toString());
        library.removeBook(1);
        assertThrows(IllegalArgumentException.class, () -> library.getBookById(1));
        assertEquals(14, library.size());
    }

    @Test
    public void changeBookStatus(){
        Book book = library.getBookById(1);
        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testGetBookById() {
        assertEquals("Book{id=5, title='title5', author='author5', year=205, genre='genre5', available=false}",
                library.getBookById(5).toString());
    }

    @Test
    public void testGetAllBooks() {
        assertEquals(15, library.getAllBooks().size());
    }

    @Test
    public void findBookWithWrongId(){
        assertThrows(
                IllegalArgumentException.class,
                () -> library.getBookById(100)
        );
    }
}