

package TestPack;

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
public class TestInterface {
    private BorderPane tInterface;
    private TestSystemGenerator sg;
    
    public TestInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        sg = new TestSystemGenerator();
        
        tInterface=new BorderPane();
        Label modeTitle = new Label(lang.getString("TestInterface.modeTitle"));
        Label lessonTitle = new Label(lang.getString("TestInterface.lessonTitle"));
        Button btnBack = new Button(lang.getString("TestInterface.btnBackTitle"));
        btnBack.setTooltip(new Tooltip(lang.getString("TestInterface.btnBackHint")));
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
        tInterface.setCenter(ConcretePageLayout.returnRootLayout(0, sg, lang));
        tInterface.setBottom(btnBack);
    }

    /**@return интерфейс режима Тест */
    public BorderPane gettInterface() {
        return tInterface;
    }
}
