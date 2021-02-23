package counter;

import javafx.fxml.FXML;

public class ParentController {
// controller of counter.fxml injected here

    @FXML
    private ChildController countController;

    public void initialize() {
        // controller available in initialize method
        System.out.println("Current value: " + countController.getValue());
    }

    @FXML
    private void increment() {
        countController.increment();
    }
}
