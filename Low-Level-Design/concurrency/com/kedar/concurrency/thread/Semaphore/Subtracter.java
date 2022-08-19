package com.kedar.concurrency.thread.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Subtracter implements Runnable {

    private Value value;
    private Semaphore semaphore;

    public Subtracter(Value value, Semaphore semaphore) {

        this.value = value;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                this.semaphore.acquire();
                int current = value.getValue();
                int next = current - i;
                value.setValue(next);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                this.semaphore.release();
            }
        }
    }
}
