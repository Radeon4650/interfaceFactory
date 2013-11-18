// Общий интерфейс page 1

package DemoPack.DemoPages.Page1sc;

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
public class Page1interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page1interface (DemoSystemGenerator sg, ResourceBundle lang) {
        infoLab1 = new Label("Page 1 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
            
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p1.structSheme")
                + "</b></p>"
                + StructScheme.getStructScheme()
                + "</td><td width=\"33%\"><p><b>"
                + lang.getString("Demo.p1.sourceData")
                + "</b></p>"
                + sg.getWk1().printInMathML()+";\t"+ sg.getWk5().printInMathML()
                + ";<br>"
                + sg.getWk2().printInMathML()+";\t"+ sg.getWk6().printInMathML()
                + ";<br>"
                + sg.getWd3().printInMathML()
                + ";<br>"
                + sg.getWd4().printInMathML()
                + ".</td></tr><tr><td align = \"center\"><p><b>"
                + lang.getString("Demo.p1.transFuncGetting")
                + "</b></p>"
                + PromptSet.fsEquation() + ";<br>"
                + sg.getFs().printInMathMLWith_abc_s()
                + ".</td><td valign=\"top\">"
                + PromptSet.getPrompt("formula_Fs", lang)
                +"</td></tr></table></body></html>");
                 
        rootLayout.getChildren().add(wv);     
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }
}
