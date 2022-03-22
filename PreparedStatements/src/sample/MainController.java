
package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    @FXML
    private ProgressBar pbProgress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        txtOutput.setDisable(true);
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String inputUsername = txtUsername.getText();
        String inputPassword = txtPassword.getText();

        btnLogin.setDisable(true);
        txtUsername.setDisable(true);
        txtPassword.setDisable(true);
        pbProgress.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        pbProgress.setDisable(false);



        Thread t = new Thread(() -> {
            statementsVSPreparedStatements(inputUsername, inputPassword);
            //batchSample();
        });
        t.start();
    }

    /**
     *
     * @param uname
     * @param pw
     */
    private void statementsVSPreparedStatements(String uname, String pw) {
        StringBuilder sb = new StringBuilder();
        try (Connection conn = new DBConnector().getConnection()) {

            //Insecure statement, dynamic SQL...
            Statement stmt = conn.createStatement();

            // ' or ''=' (get user info)
            // '; drop table Users; -- (not good..)

            // '; truncate table Users; -- (empty table)


            String sql = "SELECT * FROM Users WHERE username ='" + uname + "' AND password = '" + pw + "'";
            ResultSet rs = stmt.executeQuery(sql);





            //Secure prepared SQL
//          String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
//
//          PreparedStatement stmt = conn.prepareStatement(sql);
//          stmt.setString(1, uname);
//          stmt.setString(2, pw);
//          ResultSet rs = stmt.executeQuery(); //Select query




            System.out.println(sql); //print the SQL, so we can inspect it :)

            boolean foundMatch = false;

            while (rs.next()) {
                foundMatch = true;
                //DB returned a matching username/PW row --> we have a user --> we are logged in
                sb.append("\nWelcome " + rs.getString("username") + " " + rs.getString("password"));
            }

            if (!foundMatch) {
                sb = new StringBuilder();
                sb.append("Invalid username or password. Please try again.");
            }

            String output = sb.toString();
            Platform.runLater(() -> {
                txtOutput.setText(output);
                btnLogin.setDisable(false);
                txtUsername.setDisable(false);
                txtPassword.setDisable(false);
                pbProgress.setDisable(true);
                pbProgress.setProgress(0);
            });

        } catch (Exception e) {
            e.printStackTrace();
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
