package myExperiments;

public class Main {
    public static void main(String[] args) {
        Book book = new Book(1,"Дюна","Фрэнк Герберт",1965, "научная-фантастика", false);
        String newBook = book.toString();
        System.out.println(newBook);
    }
}//11666
