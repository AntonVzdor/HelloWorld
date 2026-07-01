package myExperiments;

public interface LibraryList extends libraryCollection{
    Library get(int index);
    boolean add(Library library);
    boolean add(int index, Library library);
    boolean remove(Library library);
    boolean removeAt(int index);
    int size();
    void clear();
}
