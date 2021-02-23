package counter;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ChildController {

    @FXML
    private Text counter;
    
    private int value = 0;

    public void initialize() {
        counter.setText(Integer.toString(value));
    }

    public void increment() {
        value++;
        counter.setText(Integer.toString(value));
    }

    public int getValue() {
        return value;
    }
}
