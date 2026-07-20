package Generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void testBox() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        List<Number> numbers2 = new ArrayList<>();
        List<Number> numbers3 = new ArrayList<>();
        numbers3.add(5);
        Box.transfer(numbers, numbers2);
        assertEquals(0, numbers.size());
        assertEquals(10, numbers2.size());
    }
}