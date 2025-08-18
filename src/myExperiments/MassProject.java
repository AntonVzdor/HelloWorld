package myExperiments;

import java.util.ArrayList;
import java.util.Scanner;

public class MassProject {
    public static void main(String[] args) {
        OutputHandler output = new OutputHandler();
        output.num();
    }
}

class OutputHandler {
    void num() {

        InputNum inp = new InputNum();
        SortNum sort = new SortNum();

        ArrayList<Integer> numOne = inp.arrayList();
        ArrayList<Integer> numTwo = sort.removeList(numOne);

        System.out.println(numTwo);
    }
}

class InputNum {
    private final Scanner in = new Scanner(System.in);

    public ArrayList<Integer> arrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int input;
        System.out.println("INPUT");

        do {
            input = in.nextInt();
            arrayList.add(input);
            System.out.println("MORE INPUT");
        } while (input != 0);
        return arrayList;
    }
}

class SortNum {
    public ArrayList<Integer> removeList(ArrayList<Integer> arrayList) {
        arrayList.removeIf(num -> num % 2 == 0);
        return arrayList;
    }
}
