// Общий интерфейс page 4

package DemoPack.DemoPages.Page4sc;

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
public class Page4interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page4interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 4 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        rootLayout.getChildren().add(PromptSet.getPrompt("abridgedMulFormula"));
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
