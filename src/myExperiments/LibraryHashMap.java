package myExperiments;

import java.util.*;

public class LibraryHashMap implements LibraryMap {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(BookOwner key, Library value) {
        if(size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean put = put(key, value, array);
        if (put) {
            size++;
        }
    }

    private boolean put(BookOwner key, Library value, Entry[] dst) {
        int position = getElementPosition(key, dst.length);
        Entry existingEntry = dst[position];
        if (existingEntry == null) {
            Entry entry = new Entry(key, value, null);
            dst[position] = entry;
            return true;
        } else  {
            while (true){
                if (existingEntry.key.equals(key)) {
                    existingEntry.value = value;
                    return false;
                }
                if(existingEntry.next == null){
                    existingEntry.next = new Entry(key, value, null);
                    return true;
                }
                existingEntry = existingEntry.next;
            }
        }
    }

    @Override
    public Library get(BookOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existingEntry = array[position];
        while (existingEntry != null) {
            if (existingEntry.key.equals(key)) {
                return existingEntry.value;
            }
            existingEntry = existingEntry.next;
        }
        return null;
    }

    @Override
    public Set<BookOwner> keySet() {
        Set<BookOwner> result = new HashSet<>();
        for(Entry entry: array){
            Entry existingEntry = entry;
            while (existingEntry != null) {
                result.add(existingEntry.key);
                existingEntry = existingEntry.next;
            }
        }
        return result;
    }

    @Override
    public List<Library> values() {
        List<Library> result = new ArrayList<>();
        for(Entry entry: array){
            Entry existingEntry = entry;
            while (existingEntry != null) {
                result.add(existingEntry.value);
                existingEntry = existingEntry.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(BookOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existingEntry = array[position];
        if (existingEntry != null && existingEntry.key.equals(key)) {
            array[position] = existingEntry.next;
            size--;
            return true;
        } else {
            while (existingEntry != null) {
                Entry nextEntry = existingEntry.next;
                if(nextEntry == null){
                    return false;
                }
                if (nextEntry.key.equals(key)) {
                    existingEntry.next = nextEntry.next;
                    size--;
                    return true;
                }
                existingEntry = existingEntry.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array =  new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int getElementPosition(BookOwner bookOwner, int arrayLength) {
        return Math.abs(bookOwner.hashCode() % arrayLength);
    }

    private void increaseArray() {
        Entry[] newArray =   new Entry[array.length * 2];
        for(Entry entry: array){
            Entry existingEntry = entry;
            while (existingEntry != null) {
                put(existingEntry.key, existingEntry.value, newArray);
                existingEntry = existingEntry.next;
            }
        }
        array = newArray;
    }

    private static class Entry{
        private BookOwner key;
        private Library value;
        private Entry next;

        public Entry(BookOwner key, Library value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
