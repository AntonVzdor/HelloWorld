package OOP;

import java.util.ArrayList;

public class Workers {
    public static void main(String[] args) {
        Client client = new Client();
        client.myOrder(new Waiter() {
            @Override
            public void BringOrder(String order) {
                System.out.println("Приятного аппетита");
            }
        }, "Суши");
    }
}

interface Waiter{
    void BringOrder(String order);
}

class Client{
    public void myOrder(Waiter waiter, String order){
        System.out.println("Ваш заказ: " + order);
        waiter.BringOrder(order);
    }
}
