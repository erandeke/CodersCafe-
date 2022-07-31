package com.kedar.concurrency.thread.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorClient {
    public static void main(String[] args) throws InterruptedException {

        Executor executor = Executors.newSingleThreadExecutor(); // It has only thread with the worker and
        //rest tasks are in blocking queue

        for (int i = 0; i < 100; i++) {
            executor.execute(new NumberPrinter(i));

            if (i == 30) {
                Thread.sleep(50L); //This will pause the main thread and run method print will execute
                System.out.println("debug");
            }
        }
    }
}
