// Общий интерфейс page 4

package DemoPack.DemoPages.Page4sc;

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
public class Page4interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page4interface (DemoSystemGenerator sg, ResourceBundle lang) {
        infoLab1 = new Label("Page 4 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p4.complexConjugateExpression")
                + "</b></p>"
                + sg.getFs().printInMathMLwithComplConExpr()
                + ";<br><br>"
                + sg.getFs().printInMathMLwithUwVw()
                + ".<br></td><td width=\"33%\" align=\"left\">"
                + PromptSet.getPrompt("abridgedMulFormula", lang)
                + "</td></tr><tr><td colspan =\"2\" align = \"center\"><br>"
                + "<p><b>"
                + lang.getString("Demo.p4.UwVw")
                + "</b></p>"
                + sg.getFs().getU_w().printInMathML() + ";\t"
                + sg.getFs().getV_w().printInMathML() + "."
                + "</td></tr></table></body></html>"
        );
        rootLayout.getChildren().add(wv);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
