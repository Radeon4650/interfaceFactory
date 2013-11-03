// Общий интерфейс page 6

package DemoPack.DemoPages.Page6sc;

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
public class Page6interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page6interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 6 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        rootLayout.getChildren().add(PromptSet.getPrompt("formula_passband"));
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
