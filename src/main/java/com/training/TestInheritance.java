package com.training;

/**
 * Write a Java program to demonstrate inheritance.
 * The following program demonstrates inheritance with the help of extends keyword.
 * The following program shows a SmartPhone class that extends the Mobile class
 * and has the features like playing and stopping music player, making a call,
 * taking photos, etc.
 */
class Mobile
{
    private int num;

    // class constructor
    Mobile()
    {

    }

    void setNumber(int num)
    {
        this.num = num;
    }

    int getNumber()
    {
        return num;
    }

    public void doCall()
    {
        System.out.println("Calling the dialled number.");
    }

    public void receiveMessage() {
        System.out.println("The Message is received.");
    }

}

// child class SmrtPhone inheriting the parent class Mobile
class SmrtPhone extends Mobile
{

    int cameraMegaPX;

    public void clickPhoto()
    {
        System.out.println("A photo is clicked.");
    }

    public void playMsic()
    {
        System.out.println("Music is getting Played.");
    }

    public void pauseMusic()
    {
        System.out.println("Music player Paused.");
    }

    public void stpMusic()
    {
        System.out.println("Music player Stopped.");
    }
}

public class TestInheritance
{
    // main method
    public static void main(String argvs[])
    {
        SmrtPhone sp = new SmrtPhone();
        sp.setNumber(94863472);
        System.out.println("Phone number is: " + sp.getNumber());
        sp.doCall();
        sp.playMsic();
        sp.pauseMusic();
        sp.stpMusic();
        sp.clickPhoto();
    }
}
