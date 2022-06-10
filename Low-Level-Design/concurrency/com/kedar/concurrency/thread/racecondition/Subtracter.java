package com.kedar.concurrency.thread.racecondition;

public class Subtracter implements Runnable {
    private Value value;

    public Subtracter(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(5l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value.value -= i;
        }
    }
}
