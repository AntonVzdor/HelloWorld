package myExperiments;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    public void addNewBooks(Book book){
        books.add(book);
    }

    public void removeBook(int id){
        books.remove(requireBookIndex(id));
    }

    public Book getBookById(int id){
        return books.get(requireBookIndex(id));
    }

    public ArrayList<Book> getAllBooks(){
        return new ArrayList<>(books);
    }

    public int size(){
        return books.size();
    }

    public void takeBook(int id){
        int index = requireBookIndex(id);
        if(!isBookAvailable(id)){
            throw new IllegalArgumentException("Book is not available");
        }
        books.get(index).setAvailable(false);
    }

    public void returnBook(int id){
        int index = requireBookIndex(id);
        if(!isBookAvailable(id)){
            books.get(index).setAvailable(true);
        } else {
            throw new IllegalArgumentException("The book is not issued.");
        }
    }

    public ArrayList<Book> getReturnBooksByAuthor(String author){
        return searchByStringRequest(book -> book.getAuthor().equals(author));
    }

    public ArrayList<Book> getReturnBooksByGenres(String genres){
        return searchByStringRequest(book -> book.getGenre().equals(genres));
    }

    public ArrayList<Book> returnBookAvailable(boolean available){
        ArrayList<Book> returnBooks = new ArrayList<>();
        for(Book book: books){
            if(book.isAvailable() == available){
                returnBooks.add(book);
            }
        }
        return returnBooks;
    }

    public boolean isBookAvailable(int id){
        return books.get(requireBookIndex(id)).isAvailable();
    }

    private int findIndexById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private int requireBookIndex(int id){
        int index = findIndexById(id);
        if (index == -1){
            throw new IllegalArgumentException("Книга с id " + id + " не найдена");
        }
        return index;
    }

    private ArrayList<Book> searchByStringRequest(Predicate<Book> predicate){
        ArrayList<Book> returnBooks = new ArrayList<>();

        for (Book book : books) {
            if (predicate.test(book)) {
                    returnBooks.add(book);
            }
        }
        return returnBooks;
    }
}