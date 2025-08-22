package OOP;

public class Monster {
    public static void main(String[] args) {
       MonsterParam monsterParam = new MonsterParam(15);
       MonsterParam monsterParam2 = new MonsterParam(15,15,3);
       MonsterParam monsterParam3 = new MonsterParam();

        monsterParam.monsterInfo();
        monsterParam2.monsterInfo();
        monsterParam3.monsterInfo();

        MonsterParam.voice();
        MonsterParam.voice(2);
        MonsterParam.voice(4, "Hello");
    }
}

class MonsterParam{
    int eyes;
    int hands;
    int feet;


    MonsterParam(int eyes, int hands, int feet) {
        this.eyes = eyes;
        this.hands = hands;
        this.feet = feet;
    }

    MonsterParam(int num) {
        this(num, num, num);
    }

     MonsterParam() {
         this(2);
    }

    void monsterInfo(){
        voice(1);
    }

    static void voice(){
        System.out.println("Grrrrrrrrrrrrr.......");
    }

    static void voice(int count){
        voice(count, "Grrrrrrrrrrrrr.......");
    }

    static void voice(int count, String word){
        for (int i = 0; i < count; i++) {
            System.out.println(word);
        }
    }
}