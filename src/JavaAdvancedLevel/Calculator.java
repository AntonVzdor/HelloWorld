package JavaAdvancedLevel;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Work work = new Work();
        work.calculator();
    }
}

class Work{
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    char c = scan.next().charAt(0);
    int b = scan.nextInt();
    Operations oper = new Operations();

    public void calculator(){
        int a = this.a;
        int b = this.b;
        int c = this.c;

        switch (c){
            case '+' :
                oper.addition(a,b);
                break;
            case '-' :
                oper.subtraction(a,b);
                break;
            case '*' :
                oper.multiplication(a,b);
                break;
            case '/' :
                oper.division(a,b);
                break;
        }
    }
}

class Operations{
    public int addition (int a, int b){
        System.out.println(a + b);
        return a + b;
    }
    public int subtraction(int a, int b){
        System.out.println(a - b);
        return a - b;
    }
    public int multiplication(int a, int b){
        System.out.println(a * b);
        return a * b;
    }
    public int division(int a, int b){
        System.out.println(a / b);
        return a / b;
    }
}
