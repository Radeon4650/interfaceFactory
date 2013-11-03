// Общий интерфейс page 8

package DemoPack.DemoPages.Page8sc;

import interfacefactory.SystemGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Radeon
 */
public class Page8interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page8interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 8 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
