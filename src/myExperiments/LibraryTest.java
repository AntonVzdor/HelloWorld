package myExperiments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private LibraryArrayList testList;

    @BeforeEach
    public void setUp() throws Exception {
        testList = new LibraryArrayList();
        for (int i = 1; i <= 100; i++) {
            testList.add(new Library("Name" + i, "Author", i));
        }
    }

    @Test
    public void wenAdded100Books() {
        assertEquals(100, testList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        assertTrue(testList.removeAt(5));
        assertEquals(99, testList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        Library library = new Library("Lord of the Rings", "J. R. R. Tolkien", 1);
        testList.add(library);
        assertEquals(101, testList.size());
        assertTrue(testList.remove(library));
        assertEquals(100, testList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse(){
        Library library = new Library("Lord of the Rings", "J. R. R. Tolkien", 1);
        assertFalse(testList.remove(library));
        assertEquals(100, testList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0(){
        testList.clear();
        assertEquals(0, testList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testList.get(100);
        });
    }

    @Test
    public void methodGetReturnedRightValueNameAndAuthor(){
        Library library1 = testList.get(0);
        assertEquals("Name1", library1.getName());
    }
}