// Общий интерфейс page 3

package DemoPack.DemoPages.Page3sc;

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
public class Page3interface  extends DemoPageInterface {
    private VBox rootLayout;
    
    public Page3interface (DemoSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body><font face=\"" 
                + AppStyles.readingFont() + "\">"
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
                + "</td></tr></table></font></body></html>"
        );
        rootLayout.getChildren().add(wv);
        
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
