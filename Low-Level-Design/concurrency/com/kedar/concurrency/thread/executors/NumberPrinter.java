package com.kedar.concurrency.thread.executors;

public class NumberPrinter implements Runnable {

    int numberToPrint;

    public NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println("Printing numbers" + numberToPrint);
    }
}
