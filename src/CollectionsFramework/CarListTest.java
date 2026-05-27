package CollectionsFramework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new CarArray("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        CarArray car = new CarArray("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        CarArray car = new CarArray("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        CarArray car = carList.get(0);
        assertEquals("Brand0", car.brand());
    }

    @Test
    public void methodGetReturnedRightNumber(){
        CarArray car = carList.get(0);
        assertEquals(0, car.number());
    }

    @Test
    public void insertAfterMiddleElement() {
        CarArray car = new CarArray("Toyota", 15);
        carList.add(car, 21);
        CarArray car2 = carList.get(21);
        assertEquals("Toyota", car2.brand());
    }

    @Test
    public void insertAfterStartElement() {
        CarArray car = new CarArray("Toyota", 15);
        carList.add(car, 0);
        CarArray car2 = carList.get(0);
        assertEquals("Toyota", car2.brand());
    }

    @Test
    public void insertAfterEndElement() {
        CarArray car = new CarArray("Toyota", 15);
        carList.add(car, 99);
        CarArray car2 = carList.get(99);
        assertEquals("Toyota", car2.brand());
    }
}

