package com.kedar.concurrency.thread.executorservice;

import java.util.concurrent.Callable;

public class CharacterPrinter implements Callable {


    Character c;

    public CharacterPrinter(Character c) {
        this.c = c;
    }


    @Override
    public Character call() throws Exception {
        return c;
    }
}
