package myExperiments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LibraryHashSet<T> implements LibrarySet<T> {

    private Map<T, Object> map = new HashMap<>();
    private Object object = new Object();;

    @Override
    public boolean add(T library) {
        if(map.containsKey(library)) {
            return false;
        }
        map.put(library, object);
        return true;
    }

    @Override
    public boolean remove(T library) {
        Object removed = map.remove(library);
        return removed != null;
    }

    @Override
    public boolean contains(T library) {
        return map.containsKey(library);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }
}
