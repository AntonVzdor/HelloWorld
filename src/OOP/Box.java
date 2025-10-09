package OOP;

public class Box {
    public static void main(String[] args) {
        BoxParam boxParam = new BoxParam(80);
        BoxParam boxParam1 = boxParam.myCopy();
        BoxParam boxParam2 = boxParam.increase();
        BoxParam boxParam3 = new BoxParam();
        WeightBox weightBox = new WeightBox();
        WeightBox weightBox2 = new WeightBox(15, 65);
        WeightBox weightBox3 = new WeightBox(12, 15, 22, 150);

        boxParam.showInfo();
        boxParam1.showInfo();
        boxParam2.showInfo();
        boxParam3.showInfo();
        weightBox.showInfo();
        weightBox2.showInfo();
        weightBox3.showInfo();
    }
}

class BoxParam {
    private final double length;
    private final double width;
    private final double height;


    protected BoxParam(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    protected BoxParam(double size) {
        this(size, size, size);
    }

    protected BoxParam() {
        this(10);
    }

    public void showInfo() {
        System.out.printf("%s %s %s\n", this.length, this.width, this.height);
    }

    public BoxParam myCopy() {
        return new BoxParam(this.length, this.width, this.height);
    }

    public BoxParam increase() {
        return new BoxParam(this.length * 2, this.width * 2, this.height * 2);
    }
}

class WeightBox extends BoxParam {

    double weights;

    public WeightBox(double length, double width, double height, double weights) {
        super(length, width, height);
        this.weights = weights;
    }

    public WeightBox(double size, double weights) {
        super(size);
        this.weights = weights;
    }

    public WeightBox() {
        super();
        this.weights = 50;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("Вес коробки: %s\n", weights);
    }
}