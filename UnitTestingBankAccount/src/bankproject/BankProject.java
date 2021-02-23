package bankproject;

/**
 *
 * @author spangsberg
 */
public class BankProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1, 1000);
        System.out.println("Balance: " + b1.getBalance());
        
        b1.withdraw(50);
        
        System.out.println("Balance: " + b1.getBalance());
        
    }    
}
