package myExperiments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryMapTest {
    private LibraryMap libraryMap;

    @Before
    public void setUp() {
        libraryMap = new LibraryHashMap();
    }

    @Test
    public void put() {
        for (int i = 0; i < 100; i++) {
            BookOwner bookOwner = new BookOwner(i, "Name" + i, "lastName" + i);
            Library library = new Library(i, "Book" + i, "Author" + i);
            libraryMap.put(bookOwner, library);
        }
        assertEquals(100, libraryMap.size());
    }

    @Test
    public void put100Elements10Size10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            BookOwner bookOwner = new BookOwner(index, "Name" + index, "lastName" + index);
            Library library = new Library(index, "Book" + index, "Author" + index);
            libraryMap.put(bookOwner, library);
        }
        assertEquals(10, libraryMap.size());
        }

    @Test
    public void removeReturn() {
        for (int i = 0; i < 10; i++) {
            BookOwner bookOwner = new BookOwner(i, "Name" + i, "lastName" + i);
            Library library = new Library(i, "Book" + i, "Author" + i);
            libraryMap.put(bookOwner, library);
        }
        assertEquals(10, libraryMap.size());

        BookOwner elementForDeleting = new BookOwner(5, "Name5", "lastName5");
        assertTrue(libraryMap.remove(elementForDeleting));
        assertEquals(9, libraryMap.size());
        assertFalse(libraryMap.remove(elementForDeleting));
        }

        @Test
        public void countOfKeysMust() {
            for (int i = 0; i < 30; i++) {
                BookOwner bookOwner = new BookOwner(i, "Name" + i, "lastName" + i);
                Library library = new Library(i, "Book" + i, "Author" + i);
                libraryMap.put(bookOwner, library);
            }
            assertEquals(30, libraryMap.size());
            assertEquals(30, libraryMap.keySet().size());
            assertEquals(30, libraryMap.values().size());
        }

        @Test
        public void get() {
            for (int i = 0; i < 100; i++) {
                BookOwner bookOwner = new BookOwner(i, "Name" + i, "lastName" + i);
                Library library = new Library(i, "Book" + i, "Author" + i);
                libraryMap.put(bookOwner, library);
            }
            BookOwner bookOwner = new BookOwner(50, "Name50", "lastName50");
            Library library = libraryMap.get(bookOwner);
            String expected = "Book50";
            assertEquals(expected, library.getName());
        }
}