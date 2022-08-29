package com.kedar.java8.code.lambda.thread;

/**
 * @author Kedar Erande
 */
public class WithoutLambdaThreadCreation {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("RUN");
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        System.out.println("Thread name" + t1.getName());
    }
}
