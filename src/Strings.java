public class Strings {
    public static void main(String[] args) {
        String name = "Семми";
        int age = 3;
        String result = String.format("Привет кошка %s!\nТебе %s года!", name, age);

        System.out.println(result);
    }
}
