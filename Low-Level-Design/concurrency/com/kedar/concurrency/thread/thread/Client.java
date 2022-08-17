package com.kedar.concurrency.thread.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long currentTime = System.currentTimeMillis();
        System.out.println("currentTime" + currentTime);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new NumberPrinter(i));

        }
        long endTime = System.currentTimeMillis();
        System.out.println("endTime" + endTime);
        Thread.sleep(1000);
        System.out.println("Total time taken to print numbers in ms" + "  " + (endTime - currentTime));


    }
}
