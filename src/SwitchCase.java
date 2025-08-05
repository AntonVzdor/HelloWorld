import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        /*String[] arr = {
                "Январь",
                "Февраль",
                "Март",
                "Апрель",
                "Май",
                "Июнь",
                "Июль",
                "Август",
                "Сентябрь",
                "Октябрь",
                "Ноябрь",
                "Декабрь"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        int number = scanner.nextInt();
        int num = number - 1;

        if (number >= 1 && number <= arr.length){
            System.out.println(arr[num]);
        } else {
            System.out.println("Вы ввели слишком большое число");
        }*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввелите месяц");
        String month = scanner.nextLine();
        String result = "";

                switch (month){
                    case "Декабрь", "Январь", "Февраль":
                        result = "Зима";
                        break;
                    case "Март", "Апрель", "Май":
                        result = "Весна";
                        break;
                    case "Июнь", "Июль", "Август":
                        result = "Лето";
                        break;
                    case "Сентябрь", "Октябрь", "Ноябрь":
                        result = "Осень";
                        break;
                    default:
                        System.out.println("вы ввели не то значение");
                }
                System.out.println(result);
    }
}
