// Общий интерфейс page 2

package DemoPack.DemoPages.Page2sc;

import DemoPack.DemoPages.DemoPageInterface;
import DiffModesCommon.PromptSet;
import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page2interface extends DemoPageInterface {
    private VBox rootLayout;
    
    public Page2interface (DemoSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body><font face=\"" 
                + AppStyles.readingFont() + "\">"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p2.sqEqRoots")
                + "</b></p>"
                + sg.getFs().printChEquationInMathML() + ";<br><br>"
                + sg.getFs().printDInMathML() + ";<br><br>"
                + sg.getFs().printS1inMathML() + ";<br><br>"
                + sg.getFs().printS2inMathML() + ";<br>"
                + "</td><td width=\"33%\" align=\"left\">"
                + PromptSet.getPrompt("formula_sqEquation", lang)
                +"</td></tr><tr><td align = \"center\">"
                + "<br><p><b>"
                + lang.getString("Demo.p2.timeConsts")
                + "</b></p>"
                + sg.getFs().printT1inMathML() + ";\t"
                + sg.getFs().printT2inMathML() + ".</td><td>"
                + PromptSet.getPrompt("formula_T1_T2", lang)
                + "</td></tr></table></font></body></html>");
        rootLayout.getChildren().add(wv);
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }    
}
