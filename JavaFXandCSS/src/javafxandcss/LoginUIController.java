
package javafxandcss;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Søren Spangsberg
 */
public class LoginUIController implements Initializable {
    
    private Label label;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblStatus;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setStyle("-fx-text-fill: red"); //bad practice?
    }        

    @FXML
    private void handleLogin(ActionEvent event) {
        
        String username = "bilbo";
        String password = "baggins";
        
        if (txtUsername.getText().equals(username) && 
            txtPassword.getText().equals(password)) {
            lblStatus.setText("Login successful!");
        }
        else {
            lblStatus.setText("Login failed!");
        }            
    }
}
