package Generics;

import java.util.ArrayList;
import java.util.List;

public abstract class Fruit {
    abstract float getWeight();
}

class Apple extends Fruit{
    @Override
    float getWeight() {
        return 1f;
    }
}

class Orange extends Fruit{
    @Override
    float getWeight() {
        return 1.5f;
    }
}

class Basket<T extends Fruit>{
    private List<T> fruits;

    public Basket() {
        fruits = new ArrayList<>();
    }

    public float getWeight() {
        float result = 0;
        for (T fruit : fruits) {
            result += fruit.getWeight();
        }
        return result;
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public int compare(Basket<?> another){
        return Float.compare(this.getWeight(), another.getWeight());
    }

    public static <U extends Fruit> void transfer(
            Basket<? extends U> src, Basket<? super U> dst
    ){
        dst.fruits.addAll(src.fruits);
        src.fruits.clear();
    }
}