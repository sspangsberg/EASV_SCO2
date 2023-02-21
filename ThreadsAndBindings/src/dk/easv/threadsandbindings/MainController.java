package dk.easv.threadsandbindings;

// Java imports
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ProgressBar pbProgress;
    @FXML
    private TextField txtDualBind;
    @FXML
    private Slider slider;
    @FXML
    private TextField txtBindUni;
    @FXML
    private Button btnHeavyTask;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblHeavyTask;

    /**
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupBindings();
    }

    /**
     *
     */
    private void setupBindings() {
        // Uni-directionally binding (slider to txtBindUni)
        //slider.valueProperty().addListener((observable, oldValue, newValue) -> {
        //    txtBindUni.setText(newValue.toString());
        //});

        // Bi-directionally
        Bindings.bindBidirectional(
                txtDualBind.textProperty(),
                slider.valueProperty(),
                new ConverterHelper());
    }


    /**
     * Event handler starting some hard work...
     * @param actionEvent
     */
    public void handleStartHeavyTask(ActionEvent actionEvent) {

        btnHeavyTask.setDisable(true);
        btnHeavyTask.setText("Working...");
        lblHeavyTask.setText("");


        Thread t = new Thread(() -> {
            simulateHardWork();
        });
        t.start();


    }

    /**
     * Simulate some hard work...
     */
    private void simulateHardWork() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < 10_000_000; i++) {
                System.out.println("Doing some boring work on item #" + i);
            }

            btnHeavyTask.setDisable(false);
            btnHeavyTask.setText("Start Heavy Task");
            lblHeavyTask.setText("Done");
        } catch (InterruptedException e) { }
    }


}
