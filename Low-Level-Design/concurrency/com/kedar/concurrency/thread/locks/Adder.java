package com.kedar.concurrency.thread.locks;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    private Value value;

    private Lock lock;

    public Adder(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            int current = value.getValue();
            int next = current + i;
            value.setValue(next);
            lock.unlock();

        }
    }
}
