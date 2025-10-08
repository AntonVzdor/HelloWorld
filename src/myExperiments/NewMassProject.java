package myExperiments;

import java.util.Scanner;

public class NewMassProject {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = "Georg";
        double balance = 5000.0;
        BankAccount bankAccount = new BankAccount(name, balance);

        while (true){
            System.out.println(
                    "Выбирете команду\n1 - Баланс\n2 - Снять деньги\n3 - Пополнить счет\n4 - Выход"
            );
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    bankAccount.showInfo();
                    break;
                case "2":
                    System.out.println("Сколько снять?");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    bankAccount.withdraw(num);
                    break;
                case "3":
                    System.out.println("Сколько положить?");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();
                    bankAccount.deposit(num2);
                    break;
                case "4":
                    System.out.println("До новых встреч!");
                    return;
                default:
                    System.out.println("Неверная команда, попробуйте снова.");
            }
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
