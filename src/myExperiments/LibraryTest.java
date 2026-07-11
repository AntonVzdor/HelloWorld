package myExperiments;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addNewBooks(new Book(847, "Преступление и наказание", "Фёдор Достоевский", 1866, "Роман", true));
        library.addNewBooks(new Book(312, "Идиот", "Фёдор Достоевский", 1868, "Роман", true));
        library.addNewBooks(new Book(569, "Братья Карамазовы", "Фёдор Достоевский", 1880, "Философия", true));

        library.addNewBooks(new Book(723, "1984", "Джордж Оруэлл", 1949, "Антиутопия", true));
        library.addNewBooks(new Book(154, "Скотный двор", "Джордж Оруэлл", 1945, "Сатира", true));

        library.addNewBooks(new Book(891, "Сияние", "Стивен Кинг", 1977, "Хоррор", true));
        library.addNewBooks(new Book(437, "Оно", "Стивен Кинг", 1986, "Хоррор", true));
        library.addNewBooks(new Book(652, "Зелёная миля", "Стивен Кинг", 1996, "Драма", true));
        library.addNewBooks(new Book(208, "Кэрри", "Стивен Кинг", 1974, "Хоррор", true));

        library.addNewBooks(new Book(776, "Гордость и предубеждение", "Джейн Остин", 1813, "Романтика", true));
        library.addNewBooks(new Book(943, "Война и мир", "Лев Толстой", 1869, "История", true));

        library.addNewBooks(new Book(315, "Властелин колец", "Дж. Р. Р. Толкин", 1954, "Фэнтези", true));
        library.addNewBooks(new Book(688, "Хоббит", "Дж. Р. Р. Толкин", 1937, "Фэнтези", false));
        library.addNewBooks(new Book(504, "Сильмариллион", "Дж. Р. Р. Толкин", 1977, "Фэнтези", false));
        library.addNewBooks(new Book(921, "Дети Хурина", "Дж. Р. Р. Толкин", 2007, "Фэнтези", true));

        library.addNewBooks(new Book(172, "Дюна", "Фрэнк Герберт", 1965, "Фантастика", true));
        library.addNewBooks(new Book(839, "Мастер и Маргарита", "Михаил Булгаков", 1967, "Мистика", true));

        library.addNewBooks(new Book(456, "Портрет Дориана Грея", "Оскар Уайльд", 1890, "Философия", true));
        library.addNewBooks(new Book(293, "Убить пересмешника", "Харпер Ли", 1960, "Драма", true));

        library.addNewBooks(new Book(781, "Три товарища", "Эрих Мария Ремарк", 1936, "Драма", true));
        library.addNewBooks(new Book(534, "Над пропастью во ржи", "Джером Сэлинджер", 1951, "Психология", true));

        library.addNewBooks(new Book(617, "451 градус по Фаренгейту", "Рэй Брэдбери", 1953, "Антиутопия", true));
        library.addNewBooks(new Book(369, "Марсианские хроники", "Рэй Брэдбери", 1950, "Фантастика", true));

        library.addNewBooks(new Book(825, "Шерлок Холмс: Этюд в багровых тонах", "Артур Конан Дойл", 1887, "Детектив", true));
        library.addNewBooks(new Book(248, "Алиса в Стране чудес", "Льюис Кэрролл", 1865, "Сказка", true));

        library.addNewBooks(new Book(603, "Моби Дик", "Герман Мелвилл", 1851, "Приключения", true));
        library.addNewBooks(new Book(971, "Гамлет", "Уильям Шекспир", 1603, "Трагедия", true));
    }

    @Test
    public void add15Books() {
        assertEquals(27, library.size());
    }

    @Test
    public void testAddNewBooks() {
        library.addNewBooks(new Book(16, "title16", "author16", 20016, "genre16", true));
        assertEquals(28, library.size());
    }

    @Test
    public void testRemoveBook() {
        assertEquals("Book{id=603, title='Моби Дик', author='Герман Мелвилл', year=1851, genre='Приключения', available=true}",
                library.getBookById(603).toString());
        library.removeBook(603);
        assertThrows(IllegalArgumentException.class, () -> library.getBookById(5));
        assertEquals(26, library.size());
    }

    @Test
    public void changeBookStatus(){
        Book book = library.getBookById(943);
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testGetBookById() {
        assertEquals("Book{id=603, title='Моби Дик', author='Герман Мелвилл', year=1851, genre='Приключения', available=true}",
                library.getBookById(603).toString());
    }

    @Test
    public void testGetAllBooks() {
        assertEquals(27, library.getAllBooks().size());
    }

    @Test
    public void findBookWithWrongId(){
        assertThrows(IllegalArgumentException.class, () -> library.getBookById(100)
        );
    }

    @Test
    public void testTakeBookById(){
        library.takeBook(603);
        assertFalse(library.getBookById(603).isAvailable());
    }

    @Test
    public void testDoubleTakeBookById(){
        library.takeBook(603);
        assertFalse(library.getBookById(603).isAvailable());
        assertThrows(IllegalArgumentException.class, () -> library.takeBook(603));
    }

    @Test
    public void testReturnBookById(){
        library.takeBook(603);
        assertFalse(library.getBookById(603).isAvailable());
        library.returnBook(603);
        assertTrue(library.getBookById(603).isAvailable());
    }

    @Test
    public void testDoubleReturnBookById(){
        library.takeBook(943);
        assertFalse(library.getBookById(943).isAvailable());
        library.returnBook(943);
        assertTrue(library.getBookById(943).isAvailable());
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(943));
    }

    @Test
    public void testIsBookAvailable(){
        assertTrue(library.isBookAvailable(943));
        library.takeBook(943);
        assertFalse(library.isBookAvailable(943));
        library.returnBook(943);
        assertTrue(library.isBookAvailable(943));
    }

    @Test
    public void testBookReturnByAuthor(){
        ArrayList<Book> availableBook = library.getReturnBooksByAuthor("Джордж Оруэлл");
        for (Book book : availableBook) {
            assertTrue(book.isAvailable());
        }
        assertEquals(2, availableBook.size());
       assertEquals(
               "Джордж Оруэлл",
               availableBook.get(0).getAuthor()
       );
       assertEquals(
               "Джордж Оруэлл",
               availableBook.get(1).getAuthor()
       );
    }

    @Test
    public void testBookReturnByGenres(){
        ArrayList<Book> availableBook = library.getReturnBooksByGenres("Антиутопия");
        for (Book book : availableBook) {
            assertTrue(book.isAvailable());
        }
        assertEquals(2, availableBook.size());
        assertEquals(
                "Антиутопия",
                availableBook.get(0).getGenre()
        );
        assertEquals(
                "Антиутопия",
                availableBook.get(1).getGenre()
        );
    }

    @Test
    public void testBookReturnAvailable(){
        ArrayList<Book> availableBook = library.returnBookAvailable(true);
        for (Book book : availableBook) {
            assertTrue(book.isAvailable());
        }
        assertEquals(25, availableBook.size());
    }
}