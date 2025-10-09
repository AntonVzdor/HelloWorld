package OOP;

public class Shape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,10,20);
        Triangle triangle = new Triangle(10,10);

        rectangle.perimeter();
        triangle.perimeter();
    }
}

class ShapeParam{
     private int a;
     private int b;

    protected ShapeParam(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void perimeter(){
        System.out.println(a + b);
    }
}

class Rectangle extends ShapeParam{

    int c;

    public Rectangle(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public void perimeter() {
        System.out.println(getA() + getB() + c);
    }
}

class Triangle extends ShapeParam{
    public Triangle(int a, int b) {
        super(a, b);
    }

    @Override
    public void perimeter() {
        System.out.println((getA() + getB()) * 2);
    }
}