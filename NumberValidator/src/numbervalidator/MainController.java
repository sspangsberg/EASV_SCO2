package numbervalidator;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.validation.NumberValidator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author spangsberg
 */
public class MainController implements Initializable 
{ 
    @FXML
    private JFXTextField txtFirst;
    @FXML
    private JFXTextField txtSecond;
    @FXML
    private JFXSlider slider;
    @FXML
    private Button btnClick;
    @FXML
    private Label lblUpdate;
    
    //3 - lav ny knap + label og handler
    @FXML
    private void handleClick(ActionEvent e) {
        lblUpdate.setText((""));
        Thread t = new Thread(() -> {
           simulateToughWork();
        });
        
        t.start();
        lblUpdate.setText(("Started hard work..."));
    }
    
    
    private void simulateToughWork() {
        
        try {
            Thread.sleep(5000); //simulation af hårdt arbejde
            
            Platform.runLater(() -> { //håndtering af skift af tråd
                lblUpdate.setText(("Done working"));
            });
                        
        } catch (InterruptedException e) {
        }
        
    }
    //3
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUpdate.setText("");        
        
        //1 - nummer validator
        //Number validator
        NumberValidator nv = new NumberValidator("Error: not a number");
        txtFirst.getValidators().add(nv);
        txtFirst.setText("");
        
        txtFirst.textProperty().addListener((observable, oldValue, newValue) -> {
            txtFirst.validate();            
        });   
        //1
        
        //2 - kobl eventhandler på slider, så text opdateres i textboks
        //slider event handler - lambda
        slider.valueProperty().addListener((observale, oldValue,newValue) -> {
            txtFirst.setText(slider.getValue()+"");
        });
        
        
        //3 - binding
        //uni-directionally
        //txtSecond.textProperty().bind(txtFirst.textProperty());
        
        
        //bi-directionally
        //txtSecond.textProperty().bindBidirectional(txtFirst.textProperty());
        
        //bind slider and textfield
//        Bindings.bindBidirectional(txtFirst.textProperty(), slider.valueProperty(), new StringConverter<Number>() {
//            @Override
//            public String toString(Number num) {
//                return num.toString();
//            }
//            
//            @Override
//            public Number fromString(String string) {
//                try {
//                    Double d = Double.parseDouble(string);
//                    return d;
//                } catch (Exception e) {
//                    return 0;
//                }
//            }           
//            
//        });
        
        
        
        
    } 
    
    
    
    
     
   
}
