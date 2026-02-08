package com.concepts.threading;

public class ThreadTwo implements Runnable{
    @Override
    public void run() {
        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
