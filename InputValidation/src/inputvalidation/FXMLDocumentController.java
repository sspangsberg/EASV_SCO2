/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inputvalidation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;

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

    private Pattern regex = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtRegex.setOnKeyPressed(event -> {
            regex = Pattern.compile(txtRegex.getText(), Pattern.CASE_INSENSITIVE);
            validate(regex);
        });
    }

    @FXML
    private void update(ActionEvent actionEvent) {
        // Email regex: [A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}
        regex = Pattern.compile(txtRegex.getText(), Pattern.CASE_INSENSITIVE);
        validate(regex);
    }

    /**
     *
     * @param regex
     */
    private void validate(Pattern regex) {
        TextFormatter<?> formatter = new TextFormatter<>(change -> {
            if (regex.matcher(change.getControlNewText()).matches()) {
                lblResult.setStyle("-fx-background-color: green;");
                return change; // allow this change to happen
            } else {
                lblResult.setStyle("-fx-background-color: red;");
                return change; // prevent change
            }
        });
        txtInput.setTextFormatter(formatter);
    }

}
