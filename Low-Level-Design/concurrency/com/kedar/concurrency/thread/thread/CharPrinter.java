package com.kedar.concurrency.thread.thread;

public class CharPrinter implements Runnable {

    Character c;

    public CharPrinter(Character c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("We got this character " + c);
    }
}
