package OOP;

public class Dog {
    public static void main(String[] args) {
        Dogs dogs = new Dogs();

        dogs.name = "Барон";
        dogs.breed = "ротвейлер";
        dogs.weight = 10.7;
        dogs.speed = 5;
        System.out.println(dogs.infoAboutDogs());
        dogs.runing();

        dogs.name = "Адик";
        dogs.breed = "дворняга";
        dogs.weight = 7.8;
        dogs.speed = 10;
        System.out.println(dogs.infoAboutDogs());
        dogs.runing();

        dogs.name = "Теська";
        dogs.breed = "пудель";
        dogs.weight = 8.9;
        dogs.speed = 2;
        System.out.println(dogs.infoAboutDogs());
        dogs.runing();
    }
}

class Dogs{
    String name;
    String breed;
    double weight;
    int speed;

    String infoAboutDogs(){
        return String.format("Имя собаки: %s. Ее порода %s и вес %s",name,breed,weight);
    }

    void runing(){
        for (int i = 0; i <= speed; i++) {
            System.out.println("Бегать!!");
        }
    }
}