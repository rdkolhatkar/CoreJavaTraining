package com.concepts.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {

    // Example of Unfair Lock
    private final Lock unfairLock = new ReentrantLock();

    public void unfairResource(){
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            unfairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " release the lock ");
        }
    }
    // ************************************************************************************************

    private final Lock fair = new ReentrantLock(true);

    public void fairResource(){
        fair.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            fair.unlock();
            System.out.println(Thread.currentThread().getName() + " release the lock ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Unfair Lock Example
        FairnessLockExample unfairLockExample = new FairnessLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                unfairLockExample.unfairResource();
            }
        };

        Thread thread1 = new Thread("Thread 1");
        Thread thread2 = new Thread("Thread 2");
        Thread thread3 = new Thread("Thread 3");

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();

        System.out.println("********************************************************************");
        // Fair Lock Example

        FairnessLockExample fairnessLockExample = new FairnessLockExample();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                fairnessLockExample.fairResource();
            }
        };

        Thread thread4 = new Thread("Thread 1");
        Thread thread5 = new Thread("Thread 2");
        Thread thread6 = new Thread("Thread 3");

        thread4.start();
        Thread.sleep(1000);
        thread5.start();
        Thread.sleep(1000);
        thread6.start();

    }
}
