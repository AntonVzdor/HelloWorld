package myExperiments;

public class Library{
    private final int id;
    private final String name;
    private final String author;

    public Library(int id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId(){return id;}

    public String getName(){return name;}

    public String getAuthor(){return author;}

}

interface LibraryList{
    Library get(int index);
    void add(Library library);
    void add(int index, Library library);
    boolean remove(Library library);
    boolean removeAt(int index);
    int size();
    void clear();
}