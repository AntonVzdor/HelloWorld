package myExperiments;

public class Library {
    private String name;
    private String author;
    private int numberOfBooks;

    public  Library(
            String name,
            String author,
            int numberOfBooks
    ) {
        this.name = name;
        this.author = author;
        this.numberOfBooks = numberOfBooks;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
    public int getNumberOfBooks() {
        return numberOfBooks;
    }
}

interface Book {
    String getName();
    String getAuthor();
    int gerNumberOfBooks();
}
