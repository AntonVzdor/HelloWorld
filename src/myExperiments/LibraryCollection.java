package myExperiments;

public interface LibraryCollection<T> extends Iterable<T> {
    boolean add(T library);
    boolean remove(T library);
    int size();
    void clear();
    boolean contains(T library);
}
