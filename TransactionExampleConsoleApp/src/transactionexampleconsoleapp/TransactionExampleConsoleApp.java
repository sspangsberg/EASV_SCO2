package transactionexampleconsoleapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author smsj
 */
public class TransactionExampleConsoleApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //transactionTest();

        long startBatch = System.currentTimeMillis();
        batchTest();
        long stopBatch = System.currentTimeMillis();

        System.out.println("Total time (batch): " + (stopBatch - startBatch) + "ms");
    }


    /**
     *
     * @throws IOException
     * @throws SQLException
     */
    private static void transactionTest() throws IOException, SQLException {

        //Create helper SQL vars
        String withdrawMoneySQL = "UPDATE Account SET Balance = Balance - ? WHERE ID = ?";
        String depositMoneySQL = "UPDATE Account SET Balance = Balance + ? WHERE ID = ?";

        try (Connection conn = new MyDatabaseConnector().getConnection()) {

            //Tell SQL Server not to auto-commit all SQL statements - we have to do this manually
            //conn.setAutoCommit(false);

            try (PreparedStatement withdrawMoney = conn.prepareStatement(withdrawMoneySQL);
                 PreparedStatement depositMoney = conn.prepareStatement(depositMoneySQL)) {

                //SQL statement #1 - withdraw 1000 from Account #2
                withdrawMoney.setInt(1, 1000); //money
                withdrawMoney.setInt(2, 2); //account id
                withdrawMoney.executeUpdate();

                int i = 10 / 0; //Simulate exception

                //SQL statement #2 - deposit 1000 to Account #1
                depositMoney.setInt(1, 1000); //money
                depositMoney.setInt(2, 1);  //account ID
                depositMoney.executeUpdate();

                //if we are here, it means no exceptions and we can commit the updates
                //conn.commit();
                System.out.println("Transaction committed succesfully");

            } catch (Exception err) {
                //conn.rollback(); //an exception happened in executing the statements
                //System.out.println("Rolling back changes...");
                err.printStackTrace();
            }
        }
    }

    /**
     *
     */
    private static void batchTest() {
        try (Connection conn = new MyDatabaseConnector().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Account VALUES (?,?)");

            for (int i = 0; i < 10000; i++) {
                stmt.setString(1, "Account #" + i);
                stmt.setInt(2, i);
                stmt.addBatch();
                //stmt.executeUpdate();
            }
            stmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
