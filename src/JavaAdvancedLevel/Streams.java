package JavaAdvancedLevel;

import java.util.Random;

public class Streams {

    static Boolean isRight = false;
    static int i;
    static int j ;
    static int bound = 1_000_000_000;

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(bound);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    int option ;

                    do {
                        i++;
                        option = random.nextInt(bound);
                    }while (option != randomNumber);
                    isRight = true;
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (j = 0; j <= 10_000; j++) {
                    if (isRight){
                        break;
                    }
                    System.out.println(j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.printf("Искомое число %s. Количество времени заняло: %s. Количесво попыток: %s", randomNumber, j, i);
            }

        });
        thread1.start();
    }
}
