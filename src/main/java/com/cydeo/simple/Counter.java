package com.cydeo.simple;

public class Counter {
    int c; // c=0
    // c=1
    // c=2
    // c=3

    // thread1 c=0
    // thread1 c=1
    // thread2 c=0, convert to 1 as value

    public synchronized void increment(){
        c++; // c = c +1
    }

}
