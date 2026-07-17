package myExperiments;

public interface LibraryList<T> extends LibraryCollection<T>{
    T get(int index);
    boolean add(T library);
    boolean add(int index, T library);
    boolean remove(T library);
    boolean removeAt(int index);
    int size();
    void clear();
}
