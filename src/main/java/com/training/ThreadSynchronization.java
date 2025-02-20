package com.training;

/**
 * Demonstrate Thread Synchronization using a Java program.
 * We can achieve thread synchronization with the help of the synchronization keyword.
 * The following is an example program.
*/

class TableClass
{
    // because the keyword synchronized only one
// string will enter the method, and the second
// string will have to wait for the first thread to
// finish its job. After that, the second thread takes
// the control.
    public synchronized void display(int num)
    {
//
        for (int j = 1; j <= 10; j++)
        {
            System.out.print(num * j + " ");
        }
        System.out.println( );
    }
}

class ThreadCl1 extends Thread
{
    TableClass tc;

    public ThreadCl1(TableClass tc)
    {
        this.tc = tc;
    }
    // inside the run method
// display() method is invoked
    public void run()
    {
        tc.display(11);
    }
}

class ThreadCl2 extends Thread
{
    TableClass tc;
    public ThreadCl2(TableClass tc)
    {
        this.tc = tc;
    }
    // inside the run method
// display() method is invoked
    public void run()
    {
        tc.display(12);
    }
}
// main class
public class ThreadSynchronization
{
    // main method
    public static void main(String argvs[])
    {
// instantiating the class TableClass
        TableClass tClass = new TableClass();
// creating the first thread
        ThreadCl1 thd1 = new ThreadCl1(tClass);

// creating the second thread
        ThreadCl2 thd2 = new ThreadCl2(tClass);
        thd1.start();
        thd2.start();
    }
}
