package myExperiments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LibraryHashSet implements LibrarySet {

    private Map<Library, Object> map = new HashMap<>();
    private Object object = new Object();;

    @Override
    public boolean add(Library library) {
        if(map.containsKey(library)) {
            return false;
        }
        map.put(library, object);
        return true;
    }

    @Override
    public boolean remove(Library library) {
        Object removed = map.remove(library);
        return removed != null;
    }

    @Override
    public boolean contains(Library library) {
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
    public Iterator<Library> iterator() {
        return map.keySet().iterator();
    }
}
