package JavaAdvancedLevel;

public class Exceptions {
    public static void main(String[] args) {

        String[] numbs = new String[]{"1","2","3","4","5"};

        try {
            System.out.println(numbs[6]);
        } catch (ArrayIndexOutOfBoundsException s){
            System.out.println("Ошибка " + s.getClass());
        } catch (Exception e){
            System.out.println("no");
        }
    }
}
