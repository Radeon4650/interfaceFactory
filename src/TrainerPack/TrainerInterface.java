

package TrainerPack;

import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author radeon
 */
public class TrainerInterface {
    private BorderPane tInterface;
    
    public TrainerInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        tInterface=new BorderPane();
        Label modeTitle = new Label(lang.getString("TrainerInterface.modeTitle"));
        Label lessonTitle = new Label(lang.getString("TrainerInterface.lessonTitle"));
        Button btnBack = new Button(lang.getString("TrainerInterface.btnBackTitle"));
        btnBack.setTooltip(new Tooltip(lang.getString("TrainerInterface.btnBackHint")));
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadInitialInterface();
            }
        });
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(modeTitle, lessonTitle);
        
        tInterface.setTop(topBox); 
        tInterface.setCenter(ConcretePageLayout.returnRootLayout(0, lang));
        tInterface.setBottom(btnBack);
    }

    /**@return интерфейс режима Тренер */
    public BorderPane gettInterface() {
        return tInterface;
    }    
}
