package com.kedar.concurrency.thread.thread;

public class Client {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new NumberPrinter(i));
            t.start();

        }
        String str = "Hi Kedar Erande";


        for (int i = 0; i < str.length(); i++) {
            Thread t1 = new Thread(new CharPrinter(str.charAt(i)));
            t1.start();
        }


    }
}
