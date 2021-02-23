package layoutsdemo;

//Java imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import layoutsdemo.BorderPaneCreator;

public class LayoutsDemo extends Application {

    @Override
    /**
     * Initialize the stage
     */
    public void start(Stage primaryStage) throws Exception {
        
        BorderPaneCreator borderPane = new BorderPaneCreator();
        
        //Scene scene = new Scene(getFlowPane(), 300, 250);
        //Scene scene = new Scene(getGridPane(), 300, 250);
        Scene scene = new Scene(borderPane.getBorderPaneSample(), 300, 250);
        
        primaryStage.setTitle("FlowPane Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    /**
     * Build a sample FlowPane
     * @return The finished FlowPane to be added
     */
    private FlowPane getFlowPane() {
        FlowPane root = new FlowPane();
        
        for (int i = 1; i <= 15; i++) {
            Button b1 = new Button("Button " + String.valueOf(i));
            root.getChildren().add(b1); //for adding button to root
        }
        
        return root;
    }
    
    
    /**
     * Build a sample GridPane
     * 
     * @return 
     */
    private GridPane getGridPane() {       
        GridPane root = new GridPane(); 
        
        root.add(new Button("C1 - R1"), 0, 0); 
        root.add(new Button("C1 - R2"), 0, 1); 
        root.add(new Button("C1 - R3"), 0, 2); 
        
        root.add(new Button("C2 - R1"), 1, 0); 
        root.add(new Button("C2 - R2"), 1, 1); 
        root.add(new Button("C2 - R3"), 1, 2); 
        
        root.add(new Button("C3 - R1"), 2, 0); 
        root.add(new Button("C3 - R2"), 2, 1); 
        root.add(new Button("C3 - R3"), 2, 2); 
        
        return root;
    }
    

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
}
