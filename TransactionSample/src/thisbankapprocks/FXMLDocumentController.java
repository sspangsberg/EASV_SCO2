
package thisbankapprocks;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 *
 * @author smsj
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button txtDynamicSQL;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        String connectionString = "";
        
        //Initialize DB objects
        Connection conn = null;        
        PreparedStatement withdrawMoney = null;
        PreparedStatement depositMoney = null;
        
        //Create helper SQL vars
        String withdrawMoneySQL = "UPDATE Account SET Balance = Balance - ?, HolderName=? WHERE AccountID = ?";
        String depositMoneySQL = "UPDATE Account SET Balance = Balance + ?, HolderName=? WHERE AccountID = ?";
        
        try {
           
            conn = new DBConnector().getConnection();
            
            //Tell SQL Server not to auto-commit all statements - we have to do this manually
            conn.setAutoCommit(false);
           
            //SQL statement #1 - withdraw 1000 from Bilbos account
            withdrawMoney = conn.prepareStatement(withdrawMoneySQL);
            withdrawMoney.setDouble(1, 1000); //money
            withdrawMoney.setString(2, "Bilbo"); //holder name
            withdrawMoney.setInt(3, 1); //account id
            withdrawMoney.executeUpdate();          
            
            //SQL statement #2 - deposit 1000 to Frodos account
            depositMoney = conn.prepareStatement(depositMoneySQL);
            depositMoney.setDouble(1, 1000); //money
            
            //exceeding maximum nvarchar(10) limit --> SQL Exception
            //will cause rollback in catch clause            
            depositMoney.setString(2, "Frodo222222222222"); //holder name - no exception            
            depositMoney.setInt(3, 2);  //account ID
            depositMoney.executeUpdate();
            
            //if we are here, it means no exceptions and we can commit the updates
            conn.commit();
            System.out.println("Transaction committed succesfully");
        } 
        catch (SQLException e) 
        {
            if (conn != null) {
                System.out.println("Rolling back updates...");
                conn.rollback(); //an exception happened in executing the statements
            }              
            e.printStackTrace();
        }          
        finally
        {   
            if (conn != null) {
                conn.setAutoCommit(true); //set default again 
                conn.close(); //close the connection --> if no conn.commit() it will rollback
            }                
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        
}