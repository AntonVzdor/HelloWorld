package myExperiments;

import java.util.List;
import java.util.Set;

public interface LibraryMap {
    void put(BookOwner key, Library value);

    Library get(BookOwner key);

    Set<BookOwner> keySet();

    List<Library> values();

    boolean remove(BookOwner key);

    int size();

    void clear();
}
