package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// write your code here
        System.out.println("Hello World!");

        //transactionTest();
        batchTest();
    }

    private static void transactionTest() throws SQLException {
        Connection conn = null;
        PreparedStatement withdrawMoney = null;
        PreparedStatement depositMoney = null;

        String withdrawMoneySQL = "UPDATE Account SET Balance = Balance - ? WHERE ID = ?";

        String depositMoneySQL = "UPDATE Account SET Balance = Balance + ? WHERE ID = ?";

        try {
            conn = DBConnector.getConnection();
            conn.setAutoCommit(false);


            //SQL statement #1 - withdraw 1000 DKK from Account #2
            withdrawMoney = conn.prepareStatement(withdrawMoneySQL);
            withdrawMoney.setInt(1, 1000);
            withdrawMoney.setInt(2, 2);
            withdrawMoney.executeUpdate();

            int i = 10 / 0; // Simulate error

            //SQL statement #2 - deposit 1000 DKK to Account #1
            depositMoney = conn.prepareStatement(depositMoneySQL);
            depositMoney.setInt(1, 1000);
            depositMoney.setInt(2, 1);
            depositMoney.executeUpdate();

            conn.commit();

        }
        catch (Exception e) {
            //conn.rollback();
            System.out.println(e);
        }
        finally {
            conn.setAutoCommit(true);
        }

    }
    private static void batchTest() throws SQLException, ClassNotFoundException {

        try (Connection conn = DBConnector.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Account VALUES (?,?)");

            for (int i = 0; i < 20000; i++) {
                stmt.setString(1, "Account #" + i);
                stmt.setInt(2, i);
                //stmt.executeUpdate();
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
