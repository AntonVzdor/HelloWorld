package myExperiments;

public interface LibrarySet<T> extends LibraryCollection<T>{
    boolean add(T library);
    boolean remove(T library);
    int size();
    void clear();
}