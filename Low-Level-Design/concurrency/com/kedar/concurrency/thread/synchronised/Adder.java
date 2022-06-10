package com.kedar.concurrency.thread.synchronised;



public class Adder implements Runnable {

    Value value;

    public Adder(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for(int i=1;i<=100;i++)
        {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            value.add(i);
        }

    }
}
