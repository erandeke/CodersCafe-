package com.kedar.java8.code.lambda.multiparameter;

/**
 * @author Kedar Erande
 */
interface Addable {
    void add(int a, int b);
}

public class LambdaWithMultipleParams {
    public static void main(String[] args) {
        Addable addable = (a, b) -> System.out.println(a + b);
        addable.add(10, 20);
    }
}
