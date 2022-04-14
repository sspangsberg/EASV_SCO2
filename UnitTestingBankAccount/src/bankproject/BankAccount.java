package bankproject;

/**
 * smsj
 */
public class BankAccount {

    // Constants:
    public static final double DEFAULT_INTEREST_RATE = 0.01;

    // Instance fields:
    private int accNumber;
    private double balance;
    private double interestRate;


    /**
     * Constructor.
     * Creates a new BankAccount with a zero balance and default interest rate.
     *
     * @param accNumber
     */
    public BankAccount(int accNumber) {
        this.accNumber = accNumber;
        this.interestRate = -1; //interest rate not set
    }


    /**
     * Creates a new BankAccount with the given initial balance and default interest rate.
     *
     * @param accNumber
     * @param initialBalance
     * @throws IllegalArgumentException if initialBalance is < 0
     */
    public BankAccount(int accNumber, double initialBalance) throws IllegalArgumentException {

        //negative initial balance. Should not be possible
        if (initialBalance < 0) {
            throw new IllegalArgumentException("InitialBalance must be positive");
        }
        //create the object
        else {
            this.accNumber = accNumber;
            this.balance = initialBalance;
            this.interestRate = -1;
        }
    }


    /**
     * Returns the account number
     * @return
     */
    public int getAccountNumber() {
        return accNumber;
    }


    /**
     * Returns the current balance
     * @return
     */
    public double getBalance() {
        return balance;
    }


    /**
     * Returns the current interest rate (or DEFAULT_INTEREST_RATE if interestRate == -1)
     * @return
     */
    public double getInterestRate() {
        if (interestRate != -1)
            return interestRate;
        else
            return DEFAULT_INTEREST_RATE;
    }


    /**
     * Adds the given amount to the balance.
     * @param amount
     * @throws IllegalArgumentException if amount < 0
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number22");
        }
        else {
            this.balance = this.balance + amount;
        }
    }


    /**
     * Subtracts the given amount from the balance
     * @param amount
     * @throws IllegalArgumentException if amount < 0 OR amount > account balance
     */
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }
        else if (amount > this.balance) {
            throw new IllegalArgumentException("Amount to withdraw exceeds available money");
        }
        else {
            this.balance = this.balance - amount;
        }
    }
    

    /**
     * Adjusts the interest rate to the given % value. Must be 1-10% (both inclusive)
     * Is specified as a double, so 1% = 0.01
     * @param interestRate
     * @throws IllegalArgumentException
     */
    public void setInterestRate(double interestRate) throws IllegalArgumentException {
        //valid range
        if (interestRate <= 0.10 && interestRate >= 0.01) {
            this.interestRate = interestRate;
        }
        else {
            throw new IllegalArgumentException("InterestRate outside valid range (0.01-0.10)");
        }
    }


    /**
     * Adds interest to the balance
     */
    public void addInterest() {
        //interest rate set to something other than disabled (-1)
        if (interestRate != -1) {
            balance += interestRate * balance;
        }
        else {
            balance += DEFAULT_INTEREST_RATE * balance;
        }
    }
}
