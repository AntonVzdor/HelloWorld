package Multithreading;

public class Bank {

    public int money = 100;

    public void takeMoney(String name, int sum) {

        synchronized (this){
            System.out.println(name + " подошел к банкомату");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (money < sum) {
                System.out.println("Денег в банкомате не достаточно");
            } else {
                money -= sum;
                System.out.println(name + " снял " + sum);
            }
            System.out.println("В банкомате осталось " + money);
        }
    }
}

class Main{

    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.takeMoney("Вася", 100);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.takeMoney("Антон", 100);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.takeMoney("Игорь", 10_000);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
