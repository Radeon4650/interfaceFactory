// Общий интерфейс page 1

package DemoPack.DemoPages.Page1sc;

import interfacefactory.PromptSet;
import interfacefactory.SystemGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page1interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page1interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 1 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        
        
//        Wk wk1 = new Wk();
                
        WebView vw = new WebView();
        vw.getEngine().loadContent(StructScheme.getStructScheme()+
                "<br>"+PromptSet.formula_Fs()); 
        rootLayout.getChildren().add(vw);
        
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }
}
