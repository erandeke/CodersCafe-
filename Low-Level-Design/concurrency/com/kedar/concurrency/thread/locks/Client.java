package com.kedar.concurrency.thread.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();


        /*
           We used locks when we want to lock a particular critical section
         */
        Lock  lock = new ReentrantLock();

        executorService.execute(new Adder(value,lock));
        executorService.execute(new Subtract(value,lock));

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);


        System.out.println(value.getValue());


    }
}
