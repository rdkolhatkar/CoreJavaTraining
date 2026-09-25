package com.concepts.threading;

public class CounterThreadTest {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread t1 =  new CounterThread(counter);
        CounterThread t2 =  new CounterThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final Count of the Counter is : "+ counter.getCount());
        // Ideally we have created two threads of the same object and each thread will run for 1000 iterations so the Fina count of counter should be 2000. But in reality this is not happening because both threads are running simultaneously.
        // There are some cases where both threads are initialized at the same time.
        // So to fix this issue we have used the "synchronized" keyword for our increment() method. => public synchronized void increment(){count++;}
        // If we want to synchronize a specific block of code then we will use the synchronize block
        /*
        // Here we are only taking about one instance, If multiple threads are able to access the increment() method then with this synchronized block we can put constraint as only one thread can access this method at one particular time.
        public  void increment(){
            synchronized (this){
                count++;
            }
        }
        As our method is used by multiple threads so this is called shared resource and this part of program is called critical programming section
        Here result will be unpredictable because it depends on the behaviour of JVM and Processor power and Thread speed
        This is also called RACE condition and by removing the RACE condition we have achieved MUTUAL EXCLUSION
        */

    }
}
