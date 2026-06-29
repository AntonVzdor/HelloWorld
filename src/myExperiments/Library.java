package myExperiments;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id == library.id && Objects.equals(name, library.name) && Objects.equals(author, library.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author);
    }
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