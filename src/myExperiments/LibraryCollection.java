package myExperiments;

public interface LibraryCollection extends Iterable<Library> {
    boolean add(Library library);
    boolean remove(Library library);
    int size();
    void clear();
    boolean contains(Library library);
}
