// Общий интерфейс page 3

package DemoPack.DemoPages.Page3sc;

import interfacefactory.PromptSet;
import DemoPack.DemoSystemGenerator;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page3interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page3interface (DemoSystemGenerator sg, ResourceBundle lang) {
        infoLab1 = new Label("Page 3 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p3.fsAchievement")
                + "</b></p>"
                + sg.getFs().printInMathMLWith_t1t2_s()
                + ".<br></td><td width=\"33%\" align=\"left\">"
                + PromptSet.getPrompt("formula_Fs_t1t2", lang)
                + "<br></td></tr><tr><td align = \"center\"><p><b>"
                + lang.getString("Demo.p3.freqFs")
                + "</b></p>"
                + sg.getFs().printInMathMLWith_t1t2_jw() + ".</td><td>"
                + PromptSet.getPrompt("replacementSjw", lang)
                + "</td></tr></table></body></html>"
        );
        rootLayout.getChildren().add(wv);
        
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
