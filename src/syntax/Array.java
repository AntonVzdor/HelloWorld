package syntax;

public class Array {
    public static void main(String[] args) {
        String[] namesOfMonths = {
                "Январь", "Февраль","Март","Апрель","Май","Июнь",
                "Июль","Авгус","Сентябрь","Октябрь","Ноябрь","Декабрь"
        };

        for (int i = 0; i < namesOfMonths.length; i++) {
            if (i < namesOfMonths.length - 1) {
                System.out.printf("%s, ", namesOfMonths[i]);
            } else {
                System.out.printf("%s.%n", namesOfMonths[i]);
            }
        }

        int[] number = {1,2,3,4,5,6,7,8,12,54};

        for (int i = number.length - 1; i >= 0; i--) {
            System.out.printf("%s ",number[i]);
        }
    }
}

