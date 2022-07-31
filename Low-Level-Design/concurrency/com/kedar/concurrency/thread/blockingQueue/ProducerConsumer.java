package com.kedar.concurrency.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//The main advantage of using blocking queue is that it blocks the thread on putting element
//if the capacity is full or it blocks the thread on take if there are no elements  in blocking queue
//here shared queue is used across Producer and Consumer
public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new Producer(sharedQueue));
        t1.start();
        Thread t2 = new Thread(new Consumer(sharedQueue));
        t2.start();


    }
}
