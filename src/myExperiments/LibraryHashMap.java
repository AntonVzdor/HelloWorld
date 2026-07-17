package myExperiments;

import java.util.*;

public class LibraryHashMap<T, V> implements LibraryMap<T, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Object[] array = new Object[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(T key, V value) {
        if(size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean put = put(key, value, array);
        if (put) {
            size++;
        }
    }

    private boolean put(T key, V value, Object[] dst) {
        int position = getElementPosition(key, dst.length);
        Entry existingEntry = (Entry) dst[position];
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
    public V get(T key) {  // вместо Library
        int position = getElementPosition(key, array.length);
        Entry existingEntry = (Entry)array[position];
        while (existingEntry != null) {
            if (existingEntry.key.equals(key)) {
                return existingEntry.value;
            }
            existingEntry = existingEntry.next;
        }
        return null;
    }

    @Override
    public Set<T> keySet() {
        Set<T> result = new HashSet<>();
        for(Object entry: array){
            Entry existingEntry = (Entry)entry;
            while (existingEntry != null) {
                result.add(existingEntry.key);
                existingEntry = existingEntry.next;
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> result = new ArrayList<>();
        for(Object entry: array){
            Entry existingEntry = (Entry)entry;
            while (existingEntry != null) {
                result.add(existingEntry.value);
                existingEntry = existingEntry.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(T key) {
        int position = getElementPosition(key, array.length);
        Entry existingEntry = (Entry)array[position];
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
        array =  new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private int getElementPosition(T bookOwner, int arrayLength) {
        return Math.abs(bookOwner.hashCode() % arrayLength);
    }

    private void increaseArray() {
        Object[] newArray =   new Object[array.length * 2];
        for(Object entry: array){
            Entry existingEntry = (Entry)entry;
            while (existingEntry != null) {
                put(existingEntry.key, existingEntry.value, newArray);
                existingEntry = existingEntry.next;
            }
        }
        array = newArray;
    }

    private class Entry{
        private T key;
        private V value;
        private Entry next;

        public Entry(T key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
