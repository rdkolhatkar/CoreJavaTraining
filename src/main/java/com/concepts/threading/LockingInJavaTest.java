package com.concepts.threading;

public class LockingInJavaTest {
    public static void main(String[] args) {
        LockingInJava l1 = new LockingInJava();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                l1.withdraw(50);
            }
        };
        // Here we have created an anonymous class with runnable interface and we are passing it inside Thread constructor
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();
        System.out.println("*************************************************************************");
        Runnable taskOne = new Runnable() {
            @Override
            public void run() {
                l1.withdrawMoney(40);
            }
        };
        // Here we have created an anonymous class with runnable interface and we are passing it inside Thread constructor
        Thread t3 = new Thread(taskOne,"Thread 3");
        Thread t4 = new Thread(taskOne,"Thread 4");
        t3.start();
        t4.start();
    }
}
