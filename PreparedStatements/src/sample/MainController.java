
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
import javafx.stage.Window;

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

    private String output = "";

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
        txtOutput.setText("");
        String inputUsername = txtUsername.getText();
        String inputPassword = txtPassword.getText();


        // Validate / sanitize input
        if (!validateInput())
            return;

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
     * @return
     */
    private boolean validateInput() {

        if (txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            showAlert(
                    Alert.AlertType.ERROR,
                    txtUsername.getScene().getWindow(),
                    "Invalid Input", "Username or password is empty");

            return false;
        }

        // other validations....


        return true;
    }

    /**
     * Login the user with input uname and pw
     * @param uname
     * @param pw
     */
    private void statementsVSPreparedStatements(String uname, String pw) {
        StringBuilder sb = new StringBuilder();

        try (Connection conn = new MyDatabaseConnector().getConnection()) {

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
            output = sb.toString();

        } catch (Exception e) {
            output = "Something went wrong..." + e.getMessage();
        }
        finally {
            Platform.runLater(() -> {
                txtOutput.setText(output);
                btnLogin.setDisable(false);
                txtUsername.setDisable(false);
                txtPassword.setDisable(false);
                pbProgress.setDisable(true);
                pbProgress.setProgress(0);
            });
        }
    }


    /**
     * Displays an alertbox based on the input parameters
     * @param alertType
     * @param owner
     * @param title
     * @param message
     */
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }



    /**
     *
     * @throws Exception
     */
    private void batchSample() throws Exception {

        try (Connection conn = new MyDatabaseConnector().getConnection()) {
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
