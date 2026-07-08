package myExperiments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    Book book;

    @Before
    public void setUp() {
        book = new Book(1,"Дюна","Фрэнк Герберт",1965, "научная-фантастика", false);
    }

    @Test
    public void getId() {
        assertEquals(1, book.getId());
    }

    @Test
    public void getTitle() {
        assertEquals("Дюна", book.getTitle());
    }

    @Test
    public void getAuthor() {
        assertEquals("Фрэнк Герберт", book.getAuthor());
    }

    @Test
    public void getYear() {
        assertEquals(1965, book.getYear());
    }
    @Test
    public void gerGenre() {
        assertEquals("научная-фантастика", book.getGenre());
    }
    @Test
    public void getAvailable() {
        assertFalse(book.isAvailable());
    }

    @Test
    public void setAvailable() {
        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testToString() {
        assertEquals(
                "Book{id=1, title='Дюна', author='Фрэнк Герберт', year=1965, genre='научная-фантастика', available=false}", book.toString()
        );
    }
}