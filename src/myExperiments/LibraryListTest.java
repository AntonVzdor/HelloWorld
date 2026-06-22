package myExperiments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryListTest {

    private LibraryList libList;

    @BeforeEach
    public void setUp() throws Exception {
        libList = new LibraryArrayList();
        for (int i = 0; i < 100; i++) {
            libList.add(new Library(i, "Book " + i, "Author" + i));
        }
    }

    @Test
    public void add100Element(){
        assertEquals(100, libList.size());
    }

    @Test
    public void RemoveByIndex(){
        assertTrue(libList.removeAt(6));
        assertEquals(99, libList.size());
    }

    @Test
    public void addElementAndRemoveByIndex(){
        Library library = new Library(4, "Lord of the Rings", "Tolkien");
        libList.add(library);
        assertEquals(101, libList.size());
        assertTrue(libList.remove(library));
        assertEquals(100,libList.size());
    }

    @Test
    public void RemoveReturnFalse(){
        Library library = new Library(4, "Lord of the Rings", "Tolkien");
        assertFalse(libList.remove(library));
        assertEquals(100,libList.size());
    }

    @Test
    public void clearList(){
        libList.clear();
        assertEquals(0, libList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            libList.get(100);
        });
    }

    @Test
    public void methodGetReturnedRightValue(){
        Library library = libList.get(0);
        assertEquals("Book 0", library.getName());
    }
}