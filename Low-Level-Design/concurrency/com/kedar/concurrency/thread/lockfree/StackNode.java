package com.kedar.concurrency.thread.lockfree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

class LockFreeStack<T> {

    AtomicReference<StackNode> head = new AtomicReference<>();
    AtomicInteger counter = new AtomicInteger(0);

    public void push(T value) {
        StackNode<T> newHead = new StackNode<>(value);
        while (true) {
            StackNode<T> currentHead = head.get();
            newHead.next = currentHead;
            if (head.compareAndSet(currentHead, newHead)) {
                break;
            } else {
                LockSupport.park(1);
            }
        }
        counter.incrementAndGet();

    }

    public T pop() {
        StackNode<T> currentNode = head.get();
        StackNode<T> newHead;

        while (currentNode != null) {
            newHead = currentNode.next;
            if (head.compareAndSet(currentNode, newHead)) {
                break;
            } else {
                LockSupport.park(1);
                currentNode = head.get();
            }

        }
        counter.incrementAndGet();

        return currentNode != null ? currentNode.value : null;

    }


    public Integer getOperations() {
        return counter.get();
    }

}


class BlockingStack<T> {

    private StackNode<T> head;
    int counter = 0;


    public synchronized void push(T value) {
        StackNode<T> newHead = new StackNode<>(value);
        newHead.next = head;
        head = newHead;
        counter++;
    }

    public synchronized T pop() {
        if (head == null) {
            counter++;
            return null;
        }
        T value = head.value;
        head = head.next;
        counter++;
        return value;
    }

    public Integer getCounter() {
        return counter;
    }
}

public class StackNode<T> {

    T value;
    StackNode<T> next;

    public StackNode(T value) {
        this.value = value;
        this.next = null;
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingStack<Integer> blockingStack = new BlockingStack<>();
        //LockFreeStack<Integer> lockFreeStack = new LockFreeStack<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            blockingStack.push(random.nextInt());
            //lockFreeStack.push(random.nextInt());
        }

        List<Thread> listOfThreads = new ArrayList<>();

        int pushThreads = 2;
        int popThreads = 2;
        for (int i = 0; i < pushThreads; i++) {
            Thread t1 = new Thread(() -> {
                while (true) {
                    blockingStack.push(random.nextInt());
                    //lockFreeStack.push(random.nextInt());
                }
            });
            t1.setDaemon(true); //what is daemon thread ?
            listOfThreads.add(t1);
        }


        //pop thread
        for (int i = 0; i < popThreads; i++) {
            Thread t2 = new Thread(() -> {
                while (true) {
                    blockingStack.pop();
                    //lockFreeStack.pop();
                }
            });
            t2.setDaemon(true);
            listOfThreads.add(t2);
        }

        for (Thread thread : listOfThreads) {
            thread.start();
        }

        Thread.sleep(1000);
        //System.out.println(String.format("%,d Number of operations performed in 1000 msecs", lockFreeStack.getOperations()));
        System.out.println(String.format("%,d Number of operations performed in 1000 msecs", blockingStack.getCounter()));


    }
}
