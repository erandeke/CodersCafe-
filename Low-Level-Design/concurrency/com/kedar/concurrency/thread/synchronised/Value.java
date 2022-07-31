package com.kedar.concurrency.thread.synchronised;

public class Value {

    int value = 0;

    public synchronized void add(int i) {
        value += i;
    }


    public synchronized void subtract(int i) {
        value = value - i;
    }
}