package Generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void testBox() {
        List<Integer> numbers = new ArrayList<>();
        Box.method(numbers);
    }
}