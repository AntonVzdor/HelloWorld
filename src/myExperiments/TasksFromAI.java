package myExperiments;

public class TasksFromAI {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        CheckNumber.checkNumber(numbers);
    }
}

class CheckNumber{
    public static void checkNumber(int[] numbers){
        int sum = 0;

        for (int num: numbers) {
            sum += num;
        }

        double sum1 = (double) sum / numbers.length;;

        System.out.println(sum1);
    }
}