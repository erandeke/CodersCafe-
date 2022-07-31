package com.kedar.concurrency.thread.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FixedPoolExecutor {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(5);
        //It will have 5 worker threads wo will be carrying out the task simulatneously
        //and rest other task will be in blocking queue

        for (int i = 0; i < 100; i++) {
            executor.execute(new NumberPrinter(i));

            if (i == 5) {
                //pool size = 5, active threads =5 , queued task = 41-5 = 36 40 + 1(main thread)
                System.out.println("debug");
            }
        }

    }
}
