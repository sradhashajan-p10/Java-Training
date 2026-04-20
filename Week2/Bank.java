class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface Payment {
    void pay(double amount);
}

class BankAccount implements Payment {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public  synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance!");
        }
        balance = balance - amount;
        System.out.println("Withdrawn: ₹" + amount);
    }
    public void pay(double amount) {
        System.out.println("Paid via UPI: ₹" + amount);
        balance = balance - amount;
    }
    public synchronized void showBalance() {
        System.out.println("Name: " + name + " Balance: ₹" + balance);
    }
}


class TransactionThread extends Thread {
    private BankAccount account;

    public TransactionThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(100);
        account.showBalance();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}


public class Bank {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Sradha", 1000);

        acc.showBalance();

        acc.deposit(500);
        
        acc.pay(200);
        acc.showBalance();
        try {
            acc.withdraw(300);
          //  acc.withdraw(2000); 
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        acc.showBalance();
        System.out.println("\nThread Demo:");
        TransactionThread t1 = new TransactionThread(acc);
        TransactionThread t2 = new TransactionThread(acc);

        t1.start();
        t2.start();
    }
}
