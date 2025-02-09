package com.training;

public class BankBlanceUserDefinedException {
    // main method
    public static void main(String[] argvs)
    {
        BankAccount acnt1 = new BankAccount(500);
        BankAccount acnt2 = new BankAccount();
        acnt2.setBalance(500);

        BankAccount acnt3 = new BankAccount(10000);

        System.out.println("account - 1 balance = " + acnt1.getBlnce());
        System.out.println("account - 2 balance = " + acnt2.getBlnce());
        System.out.println("account - 3 balance = " + acnt3.getBlnce());
    }
}

class BankAccount
{
    private int blnce;

    // constructor of the class
    BankAccount()
    {

        blnce = 7000;
    }

    // parameterized constructor of the class
    BankAccount(int blnce)
    {
        try
        {
            if(blnce >= 7000)
            {
                this.blnce = blnce;
                System.out.println("The bank account is created and the balance is set to: "+ blnce);
            }
            else
            {
                this.blnce = 0;
                System.out.println("The account can't be created.");
                throw new LowBalanceExcption();
            }
        }
        catch(LowBalanceExcption e)
        {
            System.out.println(e);
        }

    }

    void setBalance(int balance)
    {
// try catch block for
// handling the exception
        try
        {
            if(blnce >= 7000)
            {
                this.blnce = blnce;
                System.out.println("The account has been created and the bank balance has set to: "+ blnce);
            }
            else
            {
                this.blnce = 0;
                System.out.println(" The account can't be created.");

// reaching here means a custom exception has been raised
// as the bank balance is less than 7000
                throw new LowBalanceExcption();
            }

        }
        catch(LowBalanceExcption e)
        {
            System.out.println(e);
        }
    }

    // get the balance
    int getBlnce()
    {
        return blnce;
    }
}

class LowBalanceExcption extends Exception
{
    // message to be printed when the LowBalanceExcption is raised.
    public String toString()
    {
        return "Account has the low balance: The bank balance can never be less than Rs.7000/-";
    }
}
