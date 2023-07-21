package com.cydeo.deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable{

    private Lock lock1;
    private Lock lock2;

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        String threadName =  Thread.currentThread().getName();
        System.out.println(threadName+"- Acquiring lock1");
        lock1.lock();
        System.out.println(threadName+"- Lock1 Acquired");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadName+"- is trying to Acquire lock2");
        lock2.lock();
        System.out.println(threadName+"- Lock2 Acquired");


        System.out.println(threadName+"- Release lock1");
        lock1.unlock();
        System.out.println(threadName+"- Release lock2");
        lock2.unlock();

    }

    }

