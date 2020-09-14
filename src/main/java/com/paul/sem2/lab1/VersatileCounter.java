package com.paul.sem2.lab1;

import java.util.concurrent.atomic.AtomicInteger;

public class VersatileCounter {
    private AtomicInteger count;

    public VersatileCounter(int startValue) {
        count = new AtomicInteger(startValue);
    }

    public void get() { count.get(); }
    public void increment() { count.incrementAndGet(); }
    public void decrement() { count.decrementAndGet(); }
    public boolean compare(int expected) { return count.compareAndSet(expected, count.get()); }
}
