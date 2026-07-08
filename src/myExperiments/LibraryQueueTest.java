package myExperiments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryQueueTest {

    private LibraryQueue queue;

    @Before
    public void setUp() throws Exception {
        queue = new LibraryLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(new Library(i, "Book" + i, "Author" + i));
        }
    }

    @Test
    public void testAdd() {
        assertEquals(10, queue.size());
    }

    @Test
    public void peek() {
        Library library = queue.peek();
        assertEquals("Book0", library.getName());
        assertEquals(10, queue.size());
    }

    @Test
    public void poll() {
        Library library = queue.pool();
        assertEquals("Book0", library.getName());
        assertEquals(9, queue.size());
    }
}