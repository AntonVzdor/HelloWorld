package CollectionsFramework;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CarSetTest {

    private CarSet carSet;

    @Before
    public void setUp() throws Exception {
        //init
        for (int i = 0; i < 100; i++) {
            carSet.add(new CarArray("Brand" + i, i));
        }
    }

    @Test
    public void element3(){
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new CarArray("Brand",10)));
        assertFalse(carSet.add(new CarArray("Brand",10)));
        assertFalse(carSet.add(new CarArray("Brand",10)));
        assertEquals(101, carSet.size());
    }

    @Test
    public void removeSetClear(){
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void removeSet(){
       assertTrue(carSet.remove(new CarArray("Brand30",30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new CarArray("Brand30",30)));
        assertEquals(99, carSet.size());

    }

}