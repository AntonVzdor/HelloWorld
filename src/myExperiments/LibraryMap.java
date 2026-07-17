package myExperiments;

import java.util.List;
import java.util.Set;

public interface LibraryMap<T,V>{
    void put(T key, V value);

    V get(T key);

    Set<T> keySet();

    List<V> values();

    boolean remove(T key);

    int size();

    void clear();
}
