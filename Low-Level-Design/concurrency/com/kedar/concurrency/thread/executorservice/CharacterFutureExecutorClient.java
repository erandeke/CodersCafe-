package com.kedar.concurrency.thread.executorservice;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CharacterFutureExecutorClient {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        String test = "Hi Kedar Erande";
        List<Future<Character>> futureList = new ArrayList<>();

        for (int i = 0; i < test.length(); i++) {
            Future<Character> future = executorService.submit(new CharacterPrinter(test.charAt(i)));
            futureList.add(future);
        }
        try {
            executorService.awaitTermination(5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread got interrupted");
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        //print the character printer task result
        for (int i = 0; i < futureList.size(); i++) {
            Future<Character> f = futureList.get(i);
            try {
                Character c = f.get();
                System.out.println("Lets print the result" + c);
            } catch (Exception ex) {
                throw new RuntimeException();
            }

        }


    }
}
