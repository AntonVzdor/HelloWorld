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
    public boolean add(Library library) {
        checkSize();
        libAryArrayList[size] = library;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, Library library) {
        checkSize();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(libAryArrayList, index, libAryArrayList, index + 1, size - index);
        libAryArrayList[index] = library;
        size++;
        return true;
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
        System.arraycopy(libAryArrayList, index + 1, libAryArrayList, index, size- 1 - index);
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

    private  void checkSize(){
        if (size >= libAryArrayList.length){
            libAryArrayList = Arrays.copyOf(libAryArrayList , libAryArrayList.length * 2);
        }
    }
}
