package jfeonixexamples;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

/**
 *
 * @author sspangsberg
 */
public class MainController implements Initializable {

    @FXML
    private JFXTextField txtDualBind;
    @FXML
    private JFXSlider slider;
    @FXML
    private JFXTextField txtBindUni;
    @FXML
    private Button btnHeavyTask;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblHeavyTask;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupInputValidation();
        setupBindings();
    }

    /**
     * Examples of bindings
     */
    private void setupBindings() {

        //Bind slider to txtBindUni (uni-directionally)
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            txtBindUni.setText(newValue + "");
        });
        
        
//        //Bind two UI controls Bi-directionally
//        Bindings.bindBidirectional(
//                txtDualBind.textProperty(),
//                slider.valueProperty(),
//                new ConverterHelper()
//        );
    }

    /**
     * Examples of input validation
     */
    private void setupInputValidation() {

//        NumberValidator nv = new NumberValidator("Not number?");
//        nv.setMessage("Input is not a number");
//
//        txtBindUni.getValidators().add(nv);
//        txtBindUni.setText("");
//
//        //Attach Listener to validate any changes...
//        txtBindUni.textProperty().addListener((observable, oldValue, newValue)
//                -> {
//             
//            if (!txtBindUni.validate())
//                {
//                    btnHeavyTask.setDisable(true);
//                }
//            else
//                {
//                    btnHeavyTask.setDisable(false);
//                }            
//        });

          //Regular expression validator to check email
//        RegexValidator valid = new RegexValidator();
//        
//        valid.setRegexPattern("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
//        
//        txtBindUni.setValidators(valid);
//        txtBindUni.getValidators().get(0).setMessage("Email is not valid!"); 
//        
//        txtBindUni.textProperty().addListener(
//                (observable, oldValue, newValue) -> txtBindUni.validate());
    }

    /**
     * Event handler starting a heavy task on a separate thread
     *
     * @param event
     */
    @FXML
    private void handleStartHeavyTask(ActionEvent event) {

        lblHeavyTask.setText("Start heavy task...");

        //Create new thread using a Lambda expression to handle the heavy task
        Thread t = new Thread(() -> {
            simulateHardWork(); //the work...
        });
        t.start();
    }

    /**
     *
     */
    private void simulateHardWork() {
        try {
            Thread.sleep(1); //simulate hard work
            for (int i = 0; i < 100_000; i++) {
                System.out.println("Doing boring work on item #" + i);
            }

            //Update the UI (in a controlled fashion) that our work is done
            //Using lambda expression
            Platform.runLater(()->{
                lblHeavyTask.setText("Done working");
            });
            
            
            //Using annonymous class
//            Platform.runLater(new Runnable() {
//                public void run() {
//                    lblHeavyTask.setText("Done working");
//                }
//            });

        } catch (InterruptedException ex) {

        }
    }
}

//Utility class that helps us convert to+from the String/Number
class ConverterHelper extends StringConverter<Number> {

    @Override
    public String toString(Number num) {
        return num.toString();
    }

    @Override
    public Number fromString(String string) {
        try {
            Double d = Double.parseDouble(string);
            return d;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
