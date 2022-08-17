package com.kedar.concurrency.thread.atomic;

import com.kedar.concurrency.thread.locks.Subtract;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientAtomic {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger value = new AtomicInteger(0);


        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Adder(value));
        executorService.execute(new Subtracter(value));

        executorService.shutdown();
        executorService.awaitTermination(1l, TimeUnit.SECONDS);
        System.out.println(value);

    }
}
