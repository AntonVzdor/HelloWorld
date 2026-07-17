package myExperiments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryCollectionTest {

    LibraryCollection<Library> collection;

    @Before
    public void setUp() throws Exception {
        collection = new LibraryHashSet<>();
        for (int i = 0; i < 100; i++) {
            collection.add(new Library(i, "Book " + i, "Author " + i));
        }
    }

    @Test
    public void contains(){
        assertTrue(collection.contains(new Library(20, "Book 20", "Author 20")));
        assertFalse(collection.contains(new Library(300, "Book 300", "Author 300")));
    }

    @Test
    public void forEach(){
        int index = 0;
        for (Library library : collection) {
            index++;
        }
        assertEquals(100, index);
    }
}