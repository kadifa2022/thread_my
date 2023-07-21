package com.cydeo.deadlocktimeout;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockTimeOutTest {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        RunnableTimeOut1 r1 = new RunnableTimeOut1(lock1, lock2);
        RunnableTimeOut2 r2 = new RunnableTimeOut2(lock1, lock2);

        Thread t1 = new Thread(r1);
        t1.setName("Thread1");
        Thread t2 = new Thread(r2);
        t2.setName("Thread2");
        t1.start();
        t2.start();
    }

}
