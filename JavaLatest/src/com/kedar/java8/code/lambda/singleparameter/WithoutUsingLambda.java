package com.kedar.java8.code.lambda.singleparameter;

/**
 * @author Kedar Erande
 */
public class WithoutUsingLambda {
    public static void main(String[] args) {

        Message message = new Message() {
            @Override
            public void send(String message) {
                System.out.println(message);
            }
        };
        message.send("test");
    }
}
