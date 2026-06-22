package myExperiments;

import java.util.Arrays;

public class LibraryArrayList implements LibraryList {

    private Library[] libAryArrayList = new Library[10];
    private int size = 0;

    @Override
    public Library get(int index) {
        checkIndex(index);
        return libAryArrayList[index];
    }

    @Override
    public void add(Library library) {
        if (size >= libAryArrayList.length){
            libAryArrayList = Arrays.copyOf(libAryArrayList , libAryArrayList.length * 2);
        }
        libAryArrayList[size] = library;
        size++;

    }

    @Override
    public boolean remove(Library library) {
        for (int i = 0; i < size; i++) {
            if (libAryArrayList[i].equals(library)){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = 0; i < size; i++) {
            libAryArrayList[i] = libAryArrayList[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        libAryArrayList = new Library[0];
        size = 0;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
