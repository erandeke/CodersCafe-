package com.kedar.concurrency.thread.executorservice;

import com.kedar.concurrency.thread.executors.NumberPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceClient {
    public static void main(String[] args) throws InterruptedException {
        //The difference between executor and executor service is executor service
        //facilitates facility for returning a Future object and terminate, or shut down the thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Integer>> listofResults = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future future = executorService.submit(new ThreadNumberPrinter(i));

            listofResults.add(future);
        }
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdown();

        //get the result obtained by the executor service :

        for (int i = 0; i < listofResults.size(); i++) {

            Future<Integer> future = listofResults.get(i);
            try {
                int number = future.get();
                System.out.println("In main task:" + number);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
