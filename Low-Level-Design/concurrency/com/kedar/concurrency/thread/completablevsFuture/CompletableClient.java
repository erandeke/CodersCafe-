package com.kedar.concurrency.thread.completablevsFuture;

import com.kedar.bloomfilter.BloomFilters;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CompletableClient {


    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        List<String> list = new ArrayList<>();
        URL resource = BloomFilters.class.getResource("words.txt");
        Stream<String> words = Files.lines(Paths.get(resource.getFile()));
        words.forEach(w -> list.add(w));

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            CompletableFuture.supplyAsync(() -> list.get(finalI).concat(",")).thenApply(a -> a.toUpperCase()).thenAccept(s -> System.out.println("Computed Result is" + "  " + s));

        }
        long endTime = System.currentTimeMillis();
       Thread.sleep(1000);
        System.out.println("Total time taken by completable feature in processing in ms is  " + (endTime - currentTime));
    }


}
