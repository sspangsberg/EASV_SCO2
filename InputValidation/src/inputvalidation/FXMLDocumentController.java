/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inputvalidation;

// Java Imports
import java.util.regex.Pattern;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



/**
 *
 * @author spangsberg
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtRegex;
    @FXML
    private Label lblResult;
    @FXML
    private TextField txtInput;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtRegex.textProperty().addListener((observable, oldValue, newValue) -> validate() );
        txtInput.textProperty().addListener((observable, oldValue, newValue) -> validate() );

        lblResult.setText("Waiting for regex...");
        lblResult.setStyle("-fx-background-color: black;");
    }

    /**
     *
     */
    private void validate() {

        try
        {
            if (txtRegex.getText().isEmpty())
            {
                lblResult.setText("Waiting for regex...");
                lblResult.setStyle("-fx-background-color: black;");
                return;
            }

            // Examples:
            // Single Number: [0-9]
            // Multiple Numbers: [0-9]*
            // Lower-case Characters: [a-z]*
            // Upper-case Characters: [A-Z]*
            // Lower and upper cases: [a-zA-Z]*
            // Special characters: [ .,_-]
            // Specific text [a-zA-Z,.0-9 ]*Peter[a-z,.0-9 ]*
            // Email regex: [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6} // aTc121@cDe3432.dD

            lblResult.setText("");

            if (Pattern.matches(txtRegex.getText(),txtInput.getText())) {
                lblResult.setStyle("-fx-background-color: green;");
                lblResult.setText("Match!");
            }
            else {
                lblResult.setStyle("-fx-background-color: red;");
                lblResult.setText("No match!");
            }
        }
        catch (PatternSyntaxException err) {
            lblResult.setText("Invalid regex...");
            lblResult.setStyle("-fx-background-color: black;");
        }
    }
}
