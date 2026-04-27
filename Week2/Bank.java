class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface Payment {
    void UPIpay(double amount);
}

class BankAccount implements Payment {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        System.out.println("Name: " + name + " Balance: $" + balance);
    }
    public  synchronized void deposit(double amount) {
        balance = balance+ amount;
        System.out.println("Deposited: $" + amount);
    }

    public synchronized void showBalance() {
        System.out.println("Balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance!");
        }
        balance = balance - amount;
        System.out.println("Withdrawn: $" + amount);
    }
    public void UPIpay(double amount) {
        System.out.println("Paid via UPI: $" + amount);
        balance = balance - amount;
    }
    
}


class DemoThread extends Thread {
    private BankAccount account;

    public DemoThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(100);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        account.showBalance();
        
    }
}


public class Bank {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Sradha", 1000);

        acc.deposit(500);
        
        acc.UPIpay(200);
        acc.showBalance();
        try {
            acc.withdraw(300);
            acc.withdraw(2000); 
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        acc.showBalance();
        System.out.println("\nThreads");
        DemoThread t1 = new DemoThread(acc);
        DemoThread t2 = new DemoThread(acc);

        t1.start();
        t2.start();
    }
}
