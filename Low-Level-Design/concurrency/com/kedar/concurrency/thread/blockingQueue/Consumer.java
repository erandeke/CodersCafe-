package com.kedar.concurrency.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int element = blockingQueue.take();
                System.out.println("consumed" + element);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
