package interfacefactory;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class ModeSelectionInterface {
    /**@param msInterface интерфейс выбора режимов*/
    private VBox msInterface;
  
    public ModeSelectionInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        Label pageTitle = new Label(lang.getString("ModeSelectionInterface.pageTitle"));
        Button btnDemo = new Button(lang.getString("ModeSelectionInterface.demoBtnTitle"));
        btnDemo.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.demoBtnHint")));
        Button btnTrainer = new Button(lang.getString("ModeSelectionInterface.trainerBtnTitle"));
        btnTrainer.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.trainerBtnHint")));
        Button btnTest = new Button(lang.getString("ModeSelectionInterface.testBtnTitle"));
        btnTest.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.testBtnHint")));
        
        btnDemo.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadDemoInterface();
            }
        });
        
        btnTrainer.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadTrainerInterface();
            }
        });
                
        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadTestInterface();
            }
        });
        
        msInterface = new VBox();
        msInterface.setAlignment(Pos.CENTER);
        msInterface.getChildren().addAll(pageTitle, btnDemo, btnTrainer, btnTest);
    }
    
    public VBox getMsInterface() {
        return msInterface;
    }
 
}
