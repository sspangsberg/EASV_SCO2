package bankproject;

public class BankAccount {

    // Constants:
    public static final double DEFAULT_INTEREST_RATE = 0.01;

    // Instance fields:
    private int accNumber;

    private double balance;

    private double interestRate;

    // Constructors:
    // Creates a new BankAccount with a zero balance and default interest rate.
    public BankAccount(int accNumber) {
        this.accNumber = accNumber;
        this.interestRate = -1; //interest rate not set
    }

    // Creates a new BankAccont with the given initial balance and default interest rate.
    public BankAccount(int accNumber, double initialBalance) throws IllegalArgumentException {

        if (initialBalance < 0) //negative initial balance. Should not be possible
        {
            throw new IllegalArgumentException("initialBalance must be positive");            
        }
        //create the object
        else {
            this.accNumber = accNumber;
            this.balance = initialBalance;
            this.interestRate = -1;
        }
    }

    // Operations:
    // returns the account number
    public int getAccountNumber() {
        return accNumber;
    }

    // returns the current balance
    public double getBalance() {
        return balance;
    }

    // returns the current interest rate
    public double getInterestRate() {
        if (interestRate != -1)
            return interestRate;
        else
            return DEFAULT_INTEREST_RATE;
    }

    // adds the given amount to the balance.
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) //negative amount
            throw new IllegalArgumentException("amount must be a positive number");
        else        
        this.balance = this.balance + amount;
    }

    // subtracts the given amount from the balance
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) //negative amount
        {
            throw new IllegalArgumentException("amount must be a positive number");
        }
        else if (amount > this.balance) //not enough money to withdraw
        {
            throw new IllegalArgumentException("amount to withdraw exceeds available money");
        }
        else {
            this.balance = this.balance - amount;
        }
    }
    

    // adjusts the interest rate to the given value.
    public void setInterestRate(double interestRate) throws IllegalArgumentException {
        if (interestRate < 0.10 && interestRate > 0.01) //valid range
            this.interestRate = interestRate;
        else
            throw new IllegalArgumentException("interestRate outside valid range (0.0-0-10)");
    }

    // Adds interest to the balance
    public void addInterest() {
        if (interestRate != -1) //interest rate set to something other than disabled (-1)
            balance += interestRate * balance;
        else
            balance += DEFAULT_INTEREST_RATE * balance;
    }

}
