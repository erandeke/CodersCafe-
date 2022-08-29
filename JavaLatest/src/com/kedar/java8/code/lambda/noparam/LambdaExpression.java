package com.kedar.java8.code.lambda.noparam;

/**
 * @author Kedar Erande
 */
public class LambdaExpression {
    public static void main(String[] args) {

        Walkable walkable = () -> {
            System.out.println("Lets walk");
        };
        walkable.walk();
    }
}
