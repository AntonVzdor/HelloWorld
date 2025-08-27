package OOP;

public class Box {
    public static void main(String[] args) {
        BoxParam boxParam = new BoxParam(80);
        BoxParam boxParam1 = boxParam.myCopy();
        BoxParam boxParam2 = boxParam.increase();

        boxParam.showInfo();
        boxParam1.showInfo();
        boxParam2.showInfo();
    }
}

class BoxParam{
    private double length;
    private double width;
    private double height;


    public BoxParam(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public BoxParam(double size){
        this(size, size, size);
    }

     public BoxParam(){
        this(10);
    }

    public void showInfo(){
        System.out.printf("%s %s %s\n", this.length, this.width, this.height);
    }

     public BoxParam myCopy() {
        return new BoxParam(this.length, this.width, this.height);
    }

    public BoxParam increase(){
        return new BoxParam(this.length * 2, this.width * 2, this.height * 2);
    }
}
