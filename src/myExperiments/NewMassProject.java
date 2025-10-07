package myExperiments;

import java.util.Scanner;

public class NewMassProject {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = "Georg";
        double balance = 5000.0;

        String input = scanner.nextLine();
        BankAccount bankAccount = new BankAccount(name, balance);
//111
        switch (input) {
            case "Баланс":
                bankAccount.showInfo();
                break;
            case "Снять деньги":
                System.out.println("Сколько снять?");
                int num = scanner.nextInt();
                bankAccount.withdraw(num);
                break;
            case "Положить деньги":
                System.out.println("Сколько положить?");
                int num2 = scanner.nextInt();
                bankAccount.deposit(num2);
                break;
            default:
                break;
        }
    }
}

class BankAccount{
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double balance){
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void deposit(int replenish){
       if(replenish > 0){
           this.balance += replenish;
       }else {
           System.out.printf("%s ваш баланс: %s",this.ownerName, this.balance);
       }
        System.out.printf("%s ваш баланс: %s",this.ownerName, this.balance);
    }

    void withdraw(int take){
        if(take > 0 && take < this.balance){
            this.balance -= take;
            System.out.printf("Вы сняли %s\n", take);

        }else {
            System.out.printf("Недостаточно средсв\n");
        }
        System.out.printf("%s ваш баланс: %s",this.ownerName, this.balance);
    }

    void showInfo(){
        System.out.printf("%s ваш баланс: %s",this.ownerName, this.balance);
    }
}