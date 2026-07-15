package Generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void boxTest(){
        Box<String, Integer, Float> box1 = new Box<>("Anton", 33, 181.5f);
        Box<String, Integer, Float> box2 = new Box<>("Stas", 32, 175.3f);
        float sum = box1.getInteger() + box1.getFloating() + box2.getInteger() + box2.getFloating();

        assertEquals(421.8, sum, 0.0001);
    }

}