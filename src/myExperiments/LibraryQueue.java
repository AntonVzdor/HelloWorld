package myExperiments;

public interface LibraryQueue<T> extends LibraryCollection<T>{
    boolean add(T library);

    T peek();

    T pool();
}
