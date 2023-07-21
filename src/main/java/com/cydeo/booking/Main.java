package com.cydeo.booking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable runnable = new BookingThread(lock);
        Thread thread = new Thread(runnable, "Passenger 1");
        Thread thread2 = new Thread(runnable, "Passenger 2");
        thread.start();
        thread2.start();
    }
}
