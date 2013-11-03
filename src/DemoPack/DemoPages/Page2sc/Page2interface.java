// Общий интерфейс page 2

package DemoPack.DemoPages.Page2sc;

import interfacefactory.PromptSet;
import interfacefactory.SystemGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Radeon
 */
public class Page2interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page2interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 2 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        rootLayout.getChildren().add(PromptSet.getPrompt("formula_sqEquation"));
        rootLayout.getChildren().add(PromptSet.getPrompt("formula_T1_T2"));
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
}
