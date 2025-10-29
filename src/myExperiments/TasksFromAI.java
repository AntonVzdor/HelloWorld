package myExperiments;

public class TasksFromAI {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SumNum.sumNum(numbers);
    }
}

class SumNum{
    public static void sumNum(int[] numbers){
        int sum = 0;
        for (int num: numbers){
            if (num % 2 == 0){
                sum += num;
            }
        }
        System.out.printf("Сумма чётных чисел: %s", sum);
    }
}
