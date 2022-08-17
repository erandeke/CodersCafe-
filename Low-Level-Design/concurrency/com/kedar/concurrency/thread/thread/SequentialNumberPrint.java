package com.kedar.concurrency.thread.thread;

public class SequentialNumberPrint {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Printing numbers" + i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by thread to complete number printing is" + " " + (endTime - currentTime) + "  " + "ms");
    }
}
