package com.kedar.concurrency.thread.locks;

import java.util.concurrent.locks.Lock;

public class Subtract implements Runnable {

    private Value value;

    private Lock lock;

    public Subtract(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //synchronized  blocks has got a problem here we are blocking complete value object that is
            //subtracting or adding the value to i
            /*
             But what if we have such multiple methods which are adding value to j or subtracting value to j ?
             should we also lock them even if they are not related with value i ?
             The solution is use a lock -next section
             */

            lock.lock();
            int current = value.getValue();
            int next = current - i;
            value.setValue(next);
            lock.unlock();

        }
    }
}
