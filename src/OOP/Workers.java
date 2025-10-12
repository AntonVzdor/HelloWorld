package OOP;

import java.util.ArrayList;

public class Workers {
    public static void main(String[] args) {

        Director director = new Director();
        Programmer programmer = new Programmer();
        Cook cook = new Cook();

        ArrayList<WorkerInter> workers = new ArrayList<>();
        workers.add(director);
        workers.add(programmer);
        workers.add(cook);

        for (int i = 0; i < workers.size();) {
            director.work();
            programmer.work();
            cook.work();
            break;
        }

        for (int i = 0; i < workers.size();) {
         cook.drive();
         programmer.drive();
            break;
        }
    }
}

interface WorkerInter{
    void work();
}

interface Driver {
    void drive();
}

class Director implements WorkerInter{
    @Override
    public void work() {
        System.out.println("Директор принемает решения");
    }
}

class Programmer implements WorkerInter, Driver{
    @Override
    public void work() {
        System.out.println("Программист пишет код");
    }

    @Override
    public void drive() {
        System.out.println("Прогер еще и водит тачку");
    }
}

class Cook implements WorkerInter, Driver{
    @Override
    public void work() {
        System.out.println("Повар готовит для всех");
    }

    @Override
    public void drive() {
        System.out.println("Повар еще и водит тачку");
    }
}