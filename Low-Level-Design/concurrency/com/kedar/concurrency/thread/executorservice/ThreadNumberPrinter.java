package com.kedar.concurrency.thread.executorservice;

import java.util.concurrent.Callable;

public class ThreadNumberPrinter implements Callable {

    int numberToPrint;

    public ThreadNumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public Integer call() throws Exception {
        return numberToPrint;
    }
}
