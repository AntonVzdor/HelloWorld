package CollectionsFramework;

import java.util.Arrays;

public record CarArray(String brand, int number) {
}

interface CarList {
    CarArray get(int index);
    void add(CarArray car);
    void add(CarArray car, int index);
    boolean remove(CarArray car);
    boolean removeAt(int index);
    int size();
    void clear();
}

class CarArrayList implements CarList {

    private CarArray[] array = new CarArray[10];
    private int size = 0;

    @Override
    public CarArray get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(CarArray car) {
        increaseArraySize();
        array[size] = car;
        size++;
    }

    @Override
    public boolean remove(CarArray car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index +1, array, index,size - index - 1);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new CarArray[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(CarArray car, int index) {
        increaseArraySize();
        if(index< 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
    }

    private void increaseArraySize(){
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}