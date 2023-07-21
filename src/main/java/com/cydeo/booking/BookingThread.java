package com.cydeo.booking;

import java.util.concurrent.locks.Lock;

public class BookingThread implements Runnable{


        int ticketsAvailable = 1;
        private Lock lock;

        public BookingThread(Lock lock){
            this.lock = lock;
        }


    @Override
    public void run() {


        lock.lock();
        System.out.println("Waiting to book the ticket for: " + Thread.currentThread().getName());
        if (ticketsAvailable > 0){
            System.out.println("Booking ticket for: " + Thread.currentThread().getName());
            // pretend that we are processing the payment
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            ticketsAvailable--;
            System.out.println("Ticket BOOKED for: " + Thread.currentThread().getName());
            System.out.println("Current available ticket count: " + ticketsAvailable);
        }else {
            System.out.println("Ticket NOT BOOKED for: " + Thread.currentThread().getName());
        }
        lock.unlock();

        System.out.println("Booking completed.");
    }

}
