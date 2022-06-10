package com.kedar.concurrency.thread.thread;

public class NumberPrinter implements Runnable {

    int numbersToPrint;

    public NumberPrinter(int numbersToPrint) {
        this.numbersToPrint = numbersToPrint;
    }


    @Override
    public void run() {
        System.out.println("Numbers printing" + numbersToPrint);
    }
}
