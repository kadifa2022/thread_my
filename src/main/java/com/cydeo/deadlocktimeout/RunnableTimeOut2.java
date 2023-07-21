package com.cydeo.deadlocktimeout;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class RunnableTimeOut2 implements Runnable{

    Lock lock1;
    Lock lock2;

    public RunnableTimeOut2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        int failureCount = 0;
        while (!lockBothLocks(threadName)) {
            failureCount++;
            try {
                Thread.sleep(100L * ((long) Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out
                    .println(threadName + " - succeded in aquiring the both the locks after " + failureCount + " attempts");
        }

        if (failureCount > 0) {
            System.out
                    .println(threadName + " - is acquired the lock1 and lock2 after failure count " + failureCount);
        }
        System.out.println("Unlocking lock1");
        lock1.unlock();
        System.out.println("Unlocking lock2");
        lock2.unlock();
    }


    private Boolean lockBothLocks(String threadName) {
        System.out.println(threadName + " - is trying to acquire the lock2");
        try {
            boolean lock2Succeed = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            if (!lock2Succeed)
                return false;
            System.out.println(threadName + " - is locked lock2");
        } catch (InterruptedException e) {
            return false;
        }

        System.out.println(threadName + " - is trying to acquire the lock1");
        try {
            boolean lock1Succeed = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if (!lock1Succeed) {
                lock2.unlock();
                return false;
            }
            System.out.println(threadName + " - is locked lock1");
        } catch (InterruptedException e) {
            lock2.unlock();
            return false;
        }
        return true;
    }
}
