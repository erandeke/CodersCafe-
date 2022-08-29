package com.kedar.java8.code.lambda.singleparameter;

/**
 * @author Kedar Erande
 */
interface Message {
    void send(String message);
}

public class LambdaExpressionSingleParam {
    public static void main(String[] args) {

        Message message = (msg) -> System.out.println(msg);
        message.send("test");


    }
}
