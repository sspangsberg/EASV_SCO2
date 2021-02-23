package transactionexampleconsoleapp;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author smsj
 */
public class TransactionExampleConsoleApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //Initialize DB objects
        Connection conn = null;
        PreparedStatement withdrawMoney = null;
        PreparedStatement depositMoney = null;

        //Create helper SQL vars
        String withdrawMoneySQL = "UPDATE Account SET Balance = Balance - ? WHERE AccountID = ?";
        String depositMoneySQL = "UPDATE Account SET Balance = Balance + ? WHERE AccountID = ?";

        try {

            conn = DBConnection.getConnection();

            //Tell SQL Server not to auto-commit all SQL statements - we have to do this manually
            conn.setAutoCommit(false); 
            
            //SQL statement #1 - withdraw 1000 from Account #1
            withdrawMoney = conn.prepareStatement(withdrawMoneySQL);
            withdrawMoney.setInt(1, 1000); //money
            withdrawMoney.setInt(2, 1); //account id
            withdrawMoney.executeUpdate();

            //int i = 10 / 0; //Simulate exception

            //SQL statement #2 - deposit 1000 to Account #2 
            depositMoney = conn.prepareStatement(depositMoneySQL);
            depositMoney.setInt(1, 1000); //money
            depositMoney.setInt(2, 2);  //account ID
            depositMoney.executeUpdate();

            //if we are here, it means no exceptions and we can commit the updates
            conn.commit();
            System.out.println("Transaction committed succesfully");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback(); //an exception happened in executing the statements
                System.out.println("Rolling back changes...");                
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true); //set default again 
                conn.close(); //close the connection
            }
        }
    }
}
