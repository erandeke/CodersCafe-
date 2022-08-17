package com.kedar.concurrency.thread.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // List<Integer> list = List.of(1, 3, 5, 2, 7);

        List<Integer> arr = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            arr.add(random.nextInt(10));
        }
        System.out.println("arr is " + arr);
        //used CachedThreadPool ==> since its I/O bound
        //in case if we used FixedThreadPool here it will just wait for I/O incase wih cache it will assign new thread
        //FixedThreadPool used for CPU bound process - network, request/response
        ExecutorService executorService = Executors.newCachedThreadPool();

        //submit is used when we want to return future
        Future<List<Integer>> sortedList = executorService.submit(new Sorter(arr, executorService));

        List<Integer> ans = sortedList.get();

        System.out.println(ans);


    }
}
