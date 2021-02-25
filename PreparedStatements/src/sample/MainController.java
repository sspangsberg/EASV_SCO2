
package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author spangsberg
 */
public class MainController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblOutput;
    @FXML
    private TextArea txtOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        String inputUsername = txtUsername.getText();
        String inputPassword = txtPassword.getText();


        //Thread t = new Thread(() -> {
        //    try {
                statementsVSPreparedStatements(inputUsername, inputPassword);
                //batchSample();

        //    } catch (Exception ex) {}
        //    finally {
        //
        //    }
        //});
        //t.start();           
    }

    /**
     *
     * @param uname
     * @param pw
     * @throws Exception
     */
    private void statementsVSPreparedStatements(String uname, String pw) throws Exception {
        StringBuilder sb = new StringBuilder();
        try (Connection conn = new DBConnector().getConnection()) {

            //Insecure statement, dynamic SQL...
//            Statement stmt = conn.createStatement();
//
//            // ' or ''=' (get user info)
//            // '; truncate table Users; -- (not good..)
//
//            String sql = "SELECT * FROM Users WHERE username ='" + uname + "' AND password = '" + pw + "'";
//            ResultSet rs = stmt.executeQuery(sql);





            //Secure prepared SQL
          String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";

          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, uname);
          stmt.setString(2, pw);
          ResultSet rs = stmt.executeQuery(); //Select query




            System.out.println(sql); //print the SQL so we can inspect it :)

            while (rs.next()) {
                //DB returned a matching username/PW row --> we have a user --> we are logged in
                sb.append("\n Welcome " + rs.getString("Username"));
            }
            txtOutput.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *
     * @throws Exception
     */
    private void batchSample() throws Exception {

        try (Connection conn = new DBConnector().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users VALUES (?,?)");

            for (int i = 0; i < 10000; i++) {
                stmt.setString(1, "Username" + i);
                stmt.setString(2, "Password" + i);
                stmt.addBatch();
            }

            stmt.executeBatch();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
