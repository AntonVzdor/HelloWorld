package myExperiments;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

public class LibraryArrayList<T> implements LibraryList<T> {

    private Object[] libAryArrayList = new Object[10];
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T)libAryArrayList[index];
    }

    @Override
    public boolean add(T library) {
        checkSize();
        libAryArrayList[size] = library;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T library) {
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
    public boolean remove(T library) {
        for (int i = 0; i < size; i++) {
            if (libAryArrayList[i].equals(library)){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean contains(T library) {
        for (int i = 0; i < size; i++) {
            if (libAryArrayList[i].equals(library)){
                return true;
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T)libAryArrayList[index++];
            }
        };
    }
}
