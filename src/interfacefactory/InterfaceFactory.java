package interfacefactory;

import DemoPack.DemoInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Radeon
 */
public class InterfaceFactory extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #ffeba7;");
        DemoInterface demo = new DemoInterface();
        root.getChildren().add(demo.getdInterface());
        
        Scene scene = new Scene(root, 1000, 610);
        
        primaryStage.setTitle("Interface Factory Research");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
