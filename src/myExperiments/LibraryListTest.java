package myExperiments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryListTest {

    private LibraryList libList;

    @BeforeEach
    public void setUp() {
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
    public void addMiddleElement(){
        Library library = new Library(50, "Dune", "Gerbert");
        libList.add(50, library);
        Library libFromList = libList.get(50);
        assertEquals("Dune", libFromList.getName());
    }

    @Test
    public void addFirstElement(){
        Library library = new Library(0, "WarCraft", "Blizzard");
        libList.add(0, library);
        Library libFromList = libList.get(0);
        assertEquals("WarCraft", libFromList.getName());
    }

    @Test
    public void addLastElement(){
        Library library = new Library(100, "Warhammer", "GamesWorkshop");
        libList.add(100, library);
        Library libFromList = libList.get(100);
        assertEquals("Warhammer", libFromList.getName());
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
        assertThrows(IndexOutOfBoundsException.class, () -> libList.get(100));
    }

    @Test
    public void methodGetReturnedRightValue(){
        Library library = libList.get(0);
        assertEquals("Book 0", library.getName());
    }
}