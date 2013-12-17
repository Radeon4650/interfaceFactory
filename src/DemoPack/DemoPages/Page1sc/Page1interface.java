// Общий интерфейс page 1

package DemoPack.DemoPages.Page1sc;

import DemoPack.DemoPages.DemoPageInterface;
import DiffModesCommon.StructScheme;
import DiffModesCommon.PromptSet;
import DemoPack.DemoSystemGenerator;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page1interface extends DemoPageInterface {
    private VBox rootLayout;
    
    public Page1interface (DemoSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.BASELINE_CENTER);
            
        WebView wv = new WebView();
        
        wv.contextMenuEnabledProperty().set(false);
        wv.setDisable(true);
        wv.setMinHeight(585);
        wv.setPrefSize(10000, 10000);
        
        wv.getEngine().loadContent("<html><body>"
                + "<table><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p1.structSheme")
                + "</b></p>"
                + StructScheme.getStructScheme(lang)
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
                +"</td></tr></table>"
                + "</body></html>");
           
        
        WebView tipView = new WebView();
        tipView.getEngine().loadContent(sg.printFullFsObtainingInMathML(lang));
        tipView.setMinSize(600, 80);
        rootLayout.getChildren().add(wv);     
        rootLayout.getChildren().add(tipView); 
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }
}
