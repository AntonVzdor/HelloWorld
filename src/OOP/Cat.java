package OOP;

public class Cat {
    public static void main(String[] args) {
        Cats Shari = new Cats();
        Cats Missi = new Cats();
        Cats Semmi = new Cats();

        Shari.name = "Шари";
        Shari.age = 3.5;
        Shari.weight = 4.5;

        Missi.name = "Мисси";
        Missi.age = 2;
        Missi.weight = 4;

        Semmi.name = "Семми";
        Semmi.age = 4.5;
        Semmi.weight = 5.7;

        double averageAge = (Shari.age + Semmi.age + Missi.age) / 3;
        System.out.printf("Средний возраст кошек: %s, %s, %s = %s.", Shari.name, Semmi.name, Missi.name, averageAge);
    }
}

class Cats {
    String name;
    double age;
    double weight;
}
