package myExperiments;

import java.util.ArrayList;

public class TasksFromAI {
    public static void main(String[] args) {

    }
}

class Book {

    private int id;
    private String title;
    private String author;
    private int age;
    private String world;

    Book(
            int id,
            String title,
            String author,
            int age,
            String world
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.age = age;
        this.world = world;
    }

    public int getId(){
        return id;
    }

    public static void showInfo(Book book) {
        System.out.printf(
                "Выбранная вами книга:\n" +
                        " Название: %s\n" +
                        " автор: %s\n" +
                        " год написания: %s\n" +
                        " мир книги:%s",
                book.title, book.author, book.age, book.world
        );
    }
}

class Library{

    ArrayList<Book> books = new ArrayList<>();

}