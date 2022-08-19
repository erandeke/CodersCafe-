package com.kedar.concurrency.thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreClient {
    public static void main(String[] args) throws InterruptedException {

        Value value = new Value();

        Semaphore semaphore = new Semaphore(2);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Adder(value, semaphore));
        executorService.execute(new Subtracter(value, semaphore));

        executorService.shutdown();
        executorService.awaitTermination(1l, TimeUnit.SECONDS);
        System.out.println(value.getValue());

    }
}
