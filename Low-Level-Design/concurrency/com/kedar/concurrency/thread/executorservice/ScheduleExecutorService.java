package com.kedar.concurrency.thread.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Hi there");
        task1();
        ses.schedule(task, 5, TimeUnit.MILLISECONDS);



    }

    private static void task1() {
        System.out.println("Running task1");
    }
}
