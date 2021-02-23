package bankproject;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author spangsberg
 */
public class BankAccountTest {

    public BankAccountTest() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    /**
     * Test of deposit method, of class BankAccount.
     */
    @Test
    public void testDeposit() {
        System.out.println("BankAccountTest:testDeposit");

        double initialBalance = 500.00;
        double amount = 500.00;

        BankAccount account = new BankAccount(1111, initialBalance);

        account.deposit(amount);
        assertEquals(initialBalance + amount, account.getBalance(), 1E-1); //0.1 allowed in diff      
    }
    
    /**
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInterestRate() {
        System.out.println("BankAccountTest:testSetInterestRate");
        
        BankAccount acc = new BankAccount(1111,1000);
        acc.setInterestRate(-0.05);
        assertEquals(-0.05, acc.getInterestRate(), 1E-3);        
    }
        
    /**
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawPositiveAmount() {
        System.out.println("BankAccountTest:testWithdrawPositiveAmount");
        
        BankAccount account = new BankAccount(1111, 1000.0);
        
        try {
            account.withdraw(-1);
            
        }
        finally {
            assertEquals(1000.0, account.getBalance(), 1E-3); 
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawExceedingAmount() {
        System.out.println("BankAccountTest:testWithdrawExceedingAmount");
        BankAccount account = new BankAccount(1111, 1000.0);
        
        try {
            account.withdraw(2000.0);
        }
        finally {
            assertEquals(1000.0, account.getBalance(), 1E-3);            
        }
    }

    /**
     *
     * Test that an IllegalArgumentException is thrown and the balance remains
     * unchanged, if a negative amount is deposited.
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        System.out.println("BankAccountTest:testDepositNegativeAmount");

        BankAccount account = new BankAccount(1111, 1000.0);

        try {
            account.deposit(-1);            
        } finally {
            assertEquals(1000.0, account.getBalance(), 1E-3);
        }
    }
    
    /**
     * Tests that an IllegalArgumentException is thrown if a BankAccount with an
     * initial negative number is created
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateNewBankAccountWithInitialBalance() {
        
        System.out.println("BankAccountTest:testCreateNewBankAccountWithInitialBalance");
        
        try {
            BankAccount acc = new BankAccount(1111, -200); //negative initial balance --> should not be possible
            
        }
        finally {
            
        }
    }
    
    /**
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInterestRateOutsideValidRange() {
        System.out.println("BankAccountTest:testSetInterestRateOutsideValidRange");
        
        BankAccount acc = new BankAccount(1111,1000);
        
        try {
            acc.setInterestRate(0.11);            
        }
        finally {
            assertEquals(0.01, acc.getInterestRate(), 0);
        }
    }
}
