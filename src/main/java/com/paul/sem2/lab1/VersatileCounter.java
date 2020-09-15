package com.paul.sem2.lab1;

import java.util.concurrent.atomic.AtomicInteger;

public class VersatileCounter {
    private AtomicInteger count;
    private boolean awaitStatus;

    public VersatileCounter(int startValue) {
        if (startValue < 0) throw new IllegalArgumentException();
        count = new AtomicInteger(startValue);
        awaitStatus = false;
    }

    public void get() { count.get(); }

    public void increment() { count.incrementAndGet(); }

    public synchronized void decrementAndNotifyIfZero() {
        if (count.get() == 0) throw new IllegalStateException();
        count.decrementAndGet();
        if (compare(0) && awaitStatus) {
            notify();
            awaitStatus = false;
        }
    }

    public boolean compare(int expected) {
        return count.compareAndSet(expected, count.get());
    }

    public synchronized void await() {
        awaitStatus = true;
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
