package com.kedar.concurrency.thread.deadlock;

public class DeadLock implements Runnable {

    private void produce() {
        synchronized (String.class) {
            System.out.println(" Thread A locked string");
            synchronized (Integer.class) {
                System.out.println(" Thread B locked integer now thread A waiting ");
            }
        }

    }

    private void consume() {
        synchronized (Integer.class) {
            System.out.println(" Thread B has locked integer");
            synchronized (String.class) {
                System.out.println(" Thread A has locked string.. now thread B is waiting");
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DeadLock());
        t1.start();
        Thread.sleep(100L);
        Thread t2 = new Thread(new DeadLock());
        t2.start();

    }

    @Override
    public void run() {
        produce();
        consume();
    }
}
