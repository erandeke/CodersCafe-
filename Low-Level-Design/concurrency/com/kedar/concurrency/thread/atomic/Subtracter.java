package com.kedar.concurrency.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtracter implements Runnable {

    AtomicInteger value = new AtomicInteger(0);

    public Subtracter(AtomicInteger value) {
        this.value = value;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value.decrementAndGet();
        }
    }
}
