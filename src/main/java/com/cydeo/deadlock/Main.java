package com.cydeo.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock1 =  new ReentrantLock();
        Lock lock2 =  new ReentrantLock();

        Thread t1 =  new Thread(new Runnable1(lock1,lock2));
        Thread t2 =  new Thread(new Runnable2(lock1,lock2));

        t1.setName("Thread1");
        t1.start();

        t2.setName("Thread2");
        t2.start();

    }
}
