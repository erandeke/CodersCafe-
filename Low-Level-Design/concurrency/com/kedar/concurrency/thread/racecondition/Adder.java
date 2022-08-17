package com.kedar.concurrency.thread.racecondition;

import com.sun.source.doctree.AttributeTree;

public class Adder implements Runnable {

    private Value value;

    public Adder(Value value) {
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
            value.value += i;
        }
    }
}
