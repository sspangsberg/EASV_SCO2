package bankproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author spangsberg
 */
public class BankAccountTest {

    @DisplayName("01 Test valid inputs (> 0) of deposit method")
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


    @DisplayName("Test invalid inputs (< 0) of deposit method")
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


    

    @Test()
    public void testSetInvalidInterestRate() {

        // Arrange
        BankAccount acc = new BankAccount(1111,1000);

        // Act + assert
        Exception err = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            acc.setInterestRate(-0.05);
        });
    }
}
