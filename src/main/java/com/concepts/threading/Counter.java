package com.concepts.threading;

public class Counter {
    // Synchronization in Java

    private int count = 0;

    /*
    public synchronized void increment(){
        count++;
    }
    */
// Here we are only taking about one instance, If multiple threads are able to access the increment() method then with this synchronized block we can put constraint as only one thread can access this method at one particular time.
    public  void increment(){
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
