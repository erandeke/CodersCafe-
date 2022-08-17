package com.kedar.concurrency.thread.completablevsFuture;

import com.kedar.bloomfilter.BloomFilters;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class FutureClient {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        List<String> wrds = new ArrayList<>();
        URL resource = BloomFilters.class.getResource("words.txt");
        Stream<String> words = Files.lines(Paths.get(resource.getFile()));
        words.forEach(w -> wrds.add(w));

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < wrds.size(); i++) {
            Future<String> future = executorService.submit(new StringManipulatorTask(wrds.get(i)));
            System.out.println(future.get());
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken by future feature in processing in ms is  " + (endTime - currentTime));

    }

}
