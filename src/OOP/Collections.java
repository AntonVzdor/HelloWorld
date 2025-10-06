package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Collections {
    public static void main(String[] args) {
        PersonAndNumbers.committing();
    }
}

class PersonAndNumbers{

    //Ввод чисел
    static ArrayList<Integer> numbers(Scanner scanner){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите число");
            int inputNum = scanner.nextInt();
            numbers.add(inputNum);
        }
        return numbers;
    }

    //Ввод имен
    static ArrayList<String> person(Scanner scanner){
        ArrayList<String> name = new ArrayList<>();
        scanner.nextLine();
        for (int j = 0; j < 5; j++) {
            System.out.println("Введите имя");
            String inputName = scanner.nextLine();
            name.add(inputName);
        }
        return name;
    }

    static void committing(){

        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> nums = numbers(scan);
        ArrayList<String> names = person(scan);

        ArrayList<String> comm = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            comm.add(nums.get(i) + " - " + names.get(i));
        }
        for (String element: comm) {
            System.out.println(element);
        }
    }
}
