package OOP;

import java.util.Scanner;

public class Rectangles {
    public static void main(String[] args) {
        RectangleParam rectangle = new RectangleParam();

        Scanner in = new Scanner(System.in);
        System.out.println("length");
        int len = in.nextInt();
        System.out.println("width");
        int wid = in.nextInt();

        rectangle.valuesRectangle(len, wid);
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