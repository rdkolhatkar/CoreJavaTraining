package com.concepts.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockCounter {
    // ReadWriteLock allows multiple resources or Threads to read the resources concurrently as long as no Thread is writing to it
    // It ensures exclusive access for write operations
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try{
            return count;
        }
        finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockCounter counter = new ReadWriteLockCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName() + " read " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented ");
                }
            }
        };

        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();
    }

    /*
        Output before using Thread.sleep():

        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-1 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-2 read 1
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented

        Output after using Thread.sleep() in increment() method:

        Thread-0 incremented
        Thread-1 read 1
        Thread-2 read 1
        Thread-0 incremented
        Thread-1 read 2
        Thread-2 read 2
        Thread-2 read 3
        Thread-1 read 3
        Thread-1 read 3
        Thread-1 read 3
        Thread-1 read 3
        Thread-1 read 3
        Thread-0 incremented
        Thread-2 read 3
        Thread-1 read 3
        Thread-2 read 4
        Thread-1 read 4
        Thread-0 incremented
        Thread-2 read 4
        Thread-1 read 4
        Thread-2 read 5
        Thread-2 read 5
        Thread-0 incremented
        Thread-2 read 5
        Thread-0 incremented
        Thread-2 read 6
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
        Thread-0 incremented
    */
}
