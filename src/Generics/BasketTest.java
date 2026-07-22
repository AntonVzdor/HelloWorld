package Generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    @Test
    public void testBasket() {
        Basket<Orange> orange = new Basket<>();
        Basket<Apple> apple = new Basket<>();
        Basket<Fruit> fruit = new Basket<>();
        for (int i = 0; i < 10; i++) {
            orange.addFruit(new Orange());
            apple.addFruit(new Apple());
        }

        assertEquals(15f, orange.getWeight(), 0.001);
        assertEquals(10f, apple.getWeight(), 0.001);
        assertEquals(1, orange.compare(apple));

        Basket.transfer(orange, fruit);
        Basket.transfer(apple, fruit);
        assertEquals(25f, fruit.getWeight(), 0.001);
        assertEquals(0f, apple.getWeight(), 0.001);
        assertEquals(0f, orange.getWeight(), 0.001);

        Basket<Orange> orange2 = new Basket<>();
        Basket<Apple> apple2 = new Basket<>();
        for (int i = 0; i < 10; i++) {
            orange2.addFruit(new Orange());
            apple2.addFruit(new Apple());
        }
        Basket.transfer(orange2, orange);
        Basket.transfer(apple2, apple);
        assertEquals(15f, orange.getWeight(), 0.001);
        assertEquals(10f, apple.getWeight(), 0.001);
    }
}