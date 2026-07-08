package myExperiments;

import org.junit.Before;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library book;

    @Before
    public void setUp() throws Exception {
        book = new Library();
        for (int i = 0; i < 15; i++) {
            book.addNewBooks(new Book(i, "title" + i, "author" + i,200 + i, "genre" + i, false));
        }
    }
}