package com.kedar.concurrency.thread.completablevsFuture;

import java.util.concurrent.Callable;

public class StringManipulatorTask implements Callable<String> {

    private String value;

    public StringManipulatorTask(String value) {
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        return value.concat(",").toUpperCase();
    }
}
