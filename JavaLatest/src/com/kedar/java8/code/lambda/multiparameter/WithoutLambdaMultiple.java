package com.kedar.java8.code.lambda.multiparameter;

/**
 * @author Kedar Erande
 */

public class WithoutLambdaMultiple {
    public static void main(String[] args) {
        Addable addable = new Addable() {
            @Override
            public void add(int a, int b) {
                System.out.println(a + b);
            }
        };
        addable.add(10, 20);
    }
}
