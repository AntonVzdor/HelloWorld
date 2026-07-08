package myExperiments;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();;

    public void addNewBooks(Book book){
        books.add(book);
    }

    public void removeBook(int index){
        findToIndex(index);
        books.remove(index);
    }

    public Book getBookByIndex(int index){
        findToIndex(index);
        return books.get(index);
    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }

    public int size(){
        return books.size();
    }

    private void findToIndex(int index){
        if(index < 0 || index >= books.size()){
            throw new IndexOutOfBoundsException(
                    "Индекс " + index + " вне диапазона [0, " + (books.size() - 1) + "]"
            );
        }
    }
}