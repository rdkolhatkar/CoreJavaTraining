package com.concepts.threading;

class SharedResource {
    private int data;
    private boolean hasData; // Consumer thread will only consume data when this "hasData" value is "true"

    public synchronized void produce(int value){
        while (hasData){
            try {
               wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: "+value);
        notify();
    }

    public synchronized int consume(){
        while (!hasData){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: "+data);
        notify();
        // If there are one producer and multiple consumers then we can use notifyAll() method
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            resource.produce(i);
//            System.out.println("Produced: "+i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            int value = resource.consume();
//            System.out.println("Consumed: "+value);
        }
    }
}
public class ThreadCommunication {
    /*
        In a multithreading environment, threads often need to communicate and co-ordinate with each other to accomplish a task.
        Without a proper communication mechanism, threads might end up in inefficient busy-waiting states, leading to wastage of CPU resources and potential deadlocks.
        To avoid deadlock conditions we have three methods like "wait", "notify" and "notifyAll" these methods only been called in a synchronized context which means inside synchronized block or synchronized method.
    */
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
    /*
    Output:
        Produced: 0
        Consumed: 0
        Produced: 1
        Consumed: 1
        Produced: 2
        Consumed: 2
        Produced: 3
        Consumed: 3
        Produced: 4
        Consumed: 4
        Produced: 5
        Consumed: 5
        Produced: 6
        Consumed: 6
        Produced: 7
        Consumed: 7
        Produced: 8
        Consumed: 8
        Produced: 9
        Consumed: 9
    */

}
