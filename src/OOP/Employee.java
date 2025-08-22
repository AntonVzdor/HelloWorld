package OOP;

import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Compile compile = new Compile();
        compile.compile();
    }
}


class Compile {

    void compile() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = in.nextLine();
        System.out.println("Введите должность");
        String position = in.nextLine();
        System.out.println("Введите заработную плату");
        double salary = in.nextDouble();

        Worker worker = new Worker(name, position, salary);

        worker.showInfo();
    }
}

class Worker {
    String name;
    String position;
    double salary;

    Worker(
            String name,
            String position,
            double salary
    ) {

        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void showInfo() {
        System.out.printf(
                "Данные о работнике.\n Имя: %s.\n Должость: %s.\n ЗП: %s.\n", name, position, salary
        );
    }
}
