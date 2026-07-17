package myExperiments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarySetTest {

    private  LibrarySet<Library> libSet;

   @Before
    public void setUp() {
        libSet = new LibraryHashSet<>();
        for (int i = 0; i < 100; i++) {
            libSet.add(new Library(i, "Book " + i, "Author " + i));
        }
    }

    @Test
    public void add() {
        assertEquals(100, libSet.size());
        assertTrue(libSet.add(new Library(1, "Book 1", null)));
        assertFalse(libSet.add(new Library(1, "Book 1", null)));
        assertFalse(libSet.add(new Library(1, "Book 1", null)));
        assertEquals(101, libSet.size());
    }

    @Test
    public void remove() {
        assertTrue(libSet.remove(new Library(30, "Book 30", "Author 30")));
        assertEquals(99, libSet.size());
        assertFalse(libSet.remove(new Library(30, "Book 30", "Author 30")));
        assertEquals(99, libSet.size());
    }

    @Test
    public void clear() {
        libSet.clear();
        assertEquals(0, libSet.size());
    }
}