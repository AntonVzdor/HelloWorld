package myExperiments;

import java.util.ArrayList;
import java.util.Scanner;

public class TasksFromAI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Book book = new Book();
        int unput = scanner.nextInt();
        do {
            switch (unput){
                1:
                library.addBook(book);
                break;
                0:
                break;
            }
            while (unput = 0){

            }
        }
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

    //геттеры
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getAge(){
        return age;
    }
    public String getWorld(){
        return world;
    }

    //сеттеры
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setWorld(String world) {
        this.world = world;
    }

    public static void showInfo(Book book) {
        System.out.printf(
                "Выбранная вами книга:\n" +
                        " Название: %s\n" +
                        " автор: %s\n" +
                        " год написания: %s\n" +
                        " мир книги:%s",
                book.getTitle(), book.getAuthor(), book.getAge(), book.getWorld()
        );
    }
}

class Library{

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        book.setId(+1);
        this.books.add(book);
    }

    public void removeBookById(int id){

    }

    public void findBookByTitle(String title){

    }

    public void printAllBooks(){

    }

    public void getTotalBooks(){

    }
}