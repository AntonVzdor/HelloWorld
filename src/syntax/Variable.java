package syntax;

public class Variable {
    public static void main(String[] args) {
        /*int moneyJon = 100;
        int moneyNick = moneyJon*5;
        int sum = moneyJon + moneyNick;

        int day = 10000;
        int years = day/365;
        int months = day/30;

        System.out.printf("Задано дней: %s.%n",day);
        System.out.printf("В %s днях %s лет.%n",day, years);
        System.out.printf("В %s дней %s месяцев.%n",day, months);*/

        int day = 55541;
        int years = day/365;
        int months = (day - (years * 365)) / 30;
        int lastDay = day - (years * 365) - (months * 30);

        System.out.printf("В %d днях - %d лет, %d месяцев и %d дней.",day, years, months,lastDay);
    }
}
