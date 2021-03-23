package bankproject;

// JUnit imports
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


/**
 *
 * @author spangsberg
 */
public class BankAccountTest {

    @DisplayName("Test Deposit w valid inputs (> 0)")
    @Test
    public void testValidDeposit() {

        // Arrange
        double initialBalance = 500.00;
        double amount = 500.00;
        BankAccount account = new BankAccount(1111, initialBalance);

        // Act
        account.deposit(amount);

        // Assert
        double expectedBalance = 1000.00;
        double actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }


    @DisplayName("Test Deposit w invalid inputs (< 0)")
    @Test
    public void testInvalidDeposit() {

        // Arrange
        double initialBalance = 500.00;
        double amount = -100.00;
        BankAccount account = new BankAccount(1111, initialBalance);

        // Act + assert
        Exception err = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(amount);
        });

        // Extra assert
        String expectedMessage = "Amount must be a positive number";
        String actualMessage = err.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }



    @DisplayName("Test Withdraw w valid inputs (> 0)")
    @Test
    public void testValidWithdraw() {

        // Arrange
        double initialBalance = 500.00;
        double amount = 300.00;
        BankAccount account = new BankAccount(1111, initialBalance);

        // Act
        account.withdraw(amount);

        // Assert
        double expectedBalance = 200.00;
        double actualBalance = account.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }


    @DisplayName("Test Withdraw w invalid inputs (< 0)")
    @Test
    public void testInvalidNegativeWithdraw() {

        // Arrange
        double initialBalance = 500.00;
        double amount = -100.00;
        BankAccount account = new BankAccount(1111, initialBalance);

        // Act + assert
        Exception err = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(amount);
        });

        // Extra assert
        String expectedMessage = "Amount must be a positive number";
        String actualMessage = err.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }



    @DisplayName("Test Withdraw w invalid inputs (> account balance)")
    @Test
    public void testWithdrawInvalid() {

        // Arrange
        double initialBalance = 500.00;
        double amount = 600.00;
        BankAccount account = new BankAccount(1111, initialBalance);

        // Act + assert
        Exception err = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(amount);
        });

        // Extra assert
        String expectedMessage = "Amount to withdraw exceeds available money";
        String actualMessage = err.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @DisplayName("Test SetInterestRate w invalid lower bound inputs (<= 0.00)")
    @Test()
    public void testSetInterestRateInvalidLowerBound() {

        // Arrange
        BankAccount account = new BankAccount(1111,1000);

        // Act + assert
        Exception err = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setInterestRate(0.00);
        });

        // Extra assert
        String expectedMessage = "InterestRate outside valid range (0.01-0.10)";
        String actualMessage = err.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("Test SetInterestRate w invalid upper bound inputs (>= 0.1001)")
    @Test()
    public void testSetInterestRateInvalidUpperBound() {

        // Arrange
        BankAccount account = new BankAccount(1111,1000);

        // Act + assert
        Exception err = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setInterestRate(0.1001);
        });

        // Extra assert
        String expectedMessage = "InterestRate outside valid range (0.01-0.10)";
        String actualMessage = err.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @DisplayName("Test SetInterestRate w valid inputs (0.01-0.010")
    @Test()
    public void testSetInterestRateValid() {

        // Arrange
        BankAccount account = new BankAccount(1111,1000);

        // Act
        double expectedInterestRate = 0.05;
        account.setInterestRate(expectedInterestRate);
        double actualInterestRate = account.getInterestRate();

        // Assert
        Assertions.assertEquals(expectedInterestRate, actualInterestRate);
    }
}
