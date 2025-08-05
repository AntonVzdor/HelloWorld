package syntax;

public class WhatToDo {

    public static void main(String[] args) {

        boolean weather = false;
        boolean night = true;

        if (weather && !night){
            System.out.println("гулять");
        }
        if (!weather && !night){
            System.out.println("читать");
        }
        if (night){
            System.out.println("спать");
        }
    }
}
