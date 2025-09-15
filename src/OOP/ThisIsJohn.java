package OOP;

public class ThisIsJohn {
    public static void main(String[] args) {

        String s = "This is John. He is 27 years old.";

        String name = s.substring(8, 12);
        int age = Integer.parseInt(s.substring(20,22));

        Person.shoInfo(name, age);
    }
}

class Person{
    public static void shoInfo(String name, int age){
        System.out.printf("Name: %s. Age: %s", name, age);
    }
}
