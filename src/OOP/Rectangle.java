package OOP;

public class Rectangle {
    public static void main(String[] args) {
        RectangleParam rectangle = new RectangleParam();

        rectangle.valuesRectangle(20, 13);
        System.out.println(rectangle.square());
    }
}

class RectangleParam {
    int length;
    int width;

    void valuesRectangle(
            int length,
            int width
    ) {
        this.length = length;
        this.width = width;
    }

    int square() {
        return length * width;
    }
}