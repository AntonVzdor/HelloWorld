package myExperiments;

public interface LibraryQueue extends LibraryCollection{
    boolean add(Library library);

    Library peek();

    Library pool();
}
