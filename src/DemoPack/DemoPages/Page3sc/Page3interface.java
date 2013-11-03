// Общий интерфейс page 3

package DemoPack.DemoPages.Page3sc;

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
public class Page3interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page3interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 3 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        rootLayout.getChildren().add(PromptSet.getPrompt("formula_Fs_t1t2"));
        rootLayout.getChildren().add(PromptSet.getPrompt("replacementSjw"));
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
