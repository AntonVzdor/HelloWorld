package myExperiments;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    public void addNewBooks(Book book){
        books.add(book);
    }

    public void removeBook(int id){
        books.remove(check(id));
    }

    public Book getBookById(int id){
        return books.get(check(id));
    }

    public ArrayList<Book> getAllBooks(){
        return new ArrayList<>(books);
    }

    public int size(){
        return books.size();
    }

    private int findIndexById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private int check(int id){
        int index = findIndexById(id);
        if (index == -1){
            throw new IllegalArgumentException("Книга с id " + id + " не найдена");
        }
        return index;
    }
}