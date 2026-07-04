package myExperiments;

import java.util.Iterator;

public class LibraryHashSet implements LibrarySet {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(Library library) {
        if(size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = add(library, array);
        if (added) {
            size++;
        }
        return added;
    }

    private boolean add(Library library, Entry[] dst) {
        int position = getElementPosition(library, dst.length);
        if(dst[position] == null){
            Entry entry = new Entry(library, null);
            dst[position] = entry;
            return true;
        } else {
            Entry existedElement = dst[position];
            while(true) {
                if (existedElement.value.equals(library)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(library, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    @Override
    public boolean remove(Library library) {
        int position = getElementPosition(library, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry lastEntry = secondLast.next;
        if (secondLast.value.equals(library)) {
            array[position] = lastEntry;
            size--;
            return true;
        }
        while (lastEntry != null) {
            if (lastEntry.value.equals(library)) {
                secondLast.next = lastEntry.next;
                size--;
                return true;
            } else {
                secondLast = lastEntry;
                lastEntry = lastEntry.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Library library) {
        int position = getElementPosition(library, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry lastEntry = secondLast.next;
        if (secondLast.value.equals(library)) {
            return true;
        }
        while (lastEntry != null) {
            if (lastEntry.value.equals(library)) {
                return true;
            } else {
                lastEntry = lastEntry.next;
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
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }



    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existingElement = entry;
            while (existingElement != null) {
                add(existingElement.value, newArray);
                existingElement = existingElement.next;
            }
        }
        array = newArray;
    }

    private int getElementPosition(Library library, int arrayLength) {
    return Math.abs(library.hashCode() % arrayLength);
    }

    @Override
    public Iterator<Library> iterator() {
        return new  Iterator<Library>() {

            int index = 0;
            int arrayIndex = 0;
            Entry entry;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Library next() {
                while(array[arrayIndex] == null) {
                    arrayIndex++;
                }
                if (entry == null) {
                    entry = array[arrayIndex];
                }
                Library result = entry.value;
                entry = entry.next;
                if (entry == null) {
                    arrayIndex++;
                }
                index++;
                return result;
            }
        };
    }

    private static class Entry{
        private Library value;
        private Entry next;

        public Entry(Library value, Entry next){
            this.value = value;
            this.next = next;
        }
    }

}
