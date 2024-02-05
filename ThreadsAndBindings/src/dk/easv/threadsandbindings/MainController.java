package dk.easv.threadsandbindings;

// Java imports
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        // Add change listener to slider
        // Lambda
        slider.valueProperty().addListener((observable, oldValue, newValue) -> txtBindUni.setText(newValue.toString()));

        /*
        // Anonymous inner class
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtBindUni.setText(newValue.toString());
            }
        });
        */

        /*
        // Bi-directionally
        Bindings.bindBidirectional(
                txtDualBind.textProperty(),
                slider.valueProperty(),
                new ConverterHelper());
        */
    }


    /**
     * Event handler starting some hard work...
     * @param actionEvent
     */
    public void handleStartHeavyTask(ActionEvent actionEvent) {

        btnHeavyTask.setDisable(true);
        btnHeavyTask.setText("Working...");
        lblHeavyTask.setText("");

        // // Without its own Thread, this (simulateHardWork()) runs on the JavaFX GUI thread and locks up

        //Thread t = new Thread(() -> {
            simulateHardWork();
        //});
        //t.start();
    }

    /**
     * Simulate some hard work...
     */
    private void simulateHardWork() {
        try {
            // Simulate hard work to lock up the GUI
            Thread.sleep(1);
            for (int i = 0; i < 10_000_000; i++) {
                System.out.println("Doing some boooring work on item #" + i);
            }

            // Call these lines of code on the JavaFX GUI Thread to avoid thread conflicts
            Platform.runLater(() -> {
                btnHeavyTask.setDisable(false);
                btnHeavyTask.setText("Start Heavy Task");
                lblHeavyTask.setText("Done");
            });

        } catch (InterruptedException e) { }
    }
}