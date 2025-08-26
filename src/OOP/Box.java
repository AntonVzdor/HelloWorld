package OOP;

public class Box {
    public static void main(String[] args) {
        BoxParam boxParam = new BoxParam();
        BoxParam boxParam1 = boxParam.myCopy();
        BoxParam boxParam2 = boxParam.increase();

        System.out.printf("%s %s %s\n", boxParam.length, boxParam.width, boxParam.height);
        System.out.printf("%s %s %s\n", boxParam1.length, boxParam1.width, boxParam1.height);
        System.out.printf("%s %s %s", boxParam2.length, boxParam2.width, boxParam2.height);

    }
}

class BoxParam{
    double length;
    double width;
    double height;


    BoxParam(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    BoxParam(double size){
        this(size, size, size);
    }

    BoxParam(){
        this(5);
    }

     BoxParam myCopy() {
        return new BoxParam(this.length, this.width, this.length);
    }

    BoxParam increase(){
        return new BoxParam(this.length * 2, this.width * 2, this.length * 2);
    }
}
