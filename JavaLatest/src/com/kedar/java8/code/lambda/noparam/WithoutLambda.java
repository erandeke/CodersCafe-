package com.kedar.java8.code.lambda.noparam;

/**
 * @author Kedar Erande
 */
public class WithoutLambda {
    public static void main(String[] args) {

        Walkable walkable = new Walkable() { //warning from compiler this anonymous
            //cab be replaced with Lambda
            @Override
            public void walk() {
                System.out.println("Lets walk");
            }
        };
        walkable.walk();
    }
}
