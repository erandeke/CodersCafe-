package com.kedar.concurrency.thread.deadlock;

public class FixedDeadlock implements Runnable {

    private void produce() {
        synchronized (String.class) {
            System.out.println(" Thread A locked string");
            synchronized (Integer.class) {
                System.out.println(" Thread B locked integer ... Ok for thread A ");
            }
        }

    }

    private void consume() {
        synchronized (String.class) {
            System.out.println(" Thread A has locked string..Ok Thread B let me wait");
            synchronized (Integer.class) {
                System.out.println(" Thread B has locked integer.. Ok for thread A");
            }
        }

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new FixedDeadlock());
        t1.start();
        Thread t2 = new Thread(new FixedDeadlock());
        t2.start();

    }

    @Override
    public void run() {
        produce();
        consume();
    }
}
