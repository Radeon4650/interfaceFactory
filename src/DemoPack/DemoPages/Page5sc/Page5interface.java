// Общий интерфейс page 5

package DemoPack.DemoPages.Page5sc;

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
public class Page5interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page5interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 5 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        rootLayout.getChildren().add(PromptSet.getPrompt("formula_Aw"));
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
