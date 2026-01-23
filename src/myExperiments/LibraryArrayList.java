package myExperiments;

import java.util.Arrays;

public class LibraryArrayList implements Book{

    private Library[] array = new Library[10];
    private int size = 0;

    @Override
    public Library get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Library library) {
        if(size == array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = library;
        size++;
    }

    @Override
    public boolean remove(Library library) {
        for (int i = 0; i < size; i++) {
            if(array[i] == library){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
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
        array = new Library[0];
        size = 0;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
    }
}
