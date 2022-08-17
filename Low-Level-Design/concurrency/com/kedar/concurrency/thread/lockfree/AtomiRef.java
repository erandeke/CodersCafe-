package com.kedar.concurrency.thread.lockfree;

import java.util.concurrent.atomic.AtomicReference;

public class AtomiRef {
    public static void main(String[] args) {
        String oldName = "oldName";
        String newName = "newName";
        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);

        atomicReference.set("changed"); //this seems that thread has altered
        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("equal so lets change" + atomicReference.get());
        } else {
            System.out.println("Cannot be change since one of the thread altered the value");
        }
    }
}
