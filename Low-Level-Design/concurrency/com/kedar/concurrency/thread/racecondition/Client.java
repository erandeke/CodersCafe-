package com.kedar.concurrency.thread.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Value value = new Value();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Adder(value));
        executorService.execute(new Subtracter(value));

        executorService.shutdown();
        executorService.awaitTermination(1l, TimeUnit.SECONDS);
        System.out.println(value.value);
    }
}
