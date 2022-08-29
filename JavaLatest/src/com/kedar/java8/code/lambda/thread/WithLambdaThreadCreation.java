package com.kedar.java8.code.lambda.thread;

/**
 * @author Kedar Erande
 */
public class WithLambdaThreadCreation {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("run");
        Thread t1 = new Thread(runnable);
        t1.start();
        System.out.println("Thread name" + t1.getName());
    }
}
