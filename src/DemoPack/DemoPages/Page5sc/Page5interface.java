// Общий интерфейс page 5

package DemoPack.DemoPages.Page5sc;

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
public class Page5interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page5interface (DemoSystemGenerator sg, ResourceBundle lang) {
        infoLab1 = new Label("Page 5 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        String webContent = "<html><body>"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p5.achievementAw")
                + "</b></p>"
                + sg.getFs().getA_w().a_wObtaining()
                + ";<br>"
                + sg.getFs().getA_w().printInMathML() 
                + ".</td><td width=\"33%\">"
                + PromptSet.getPrompt("formula_Aw", lang)
                + "</td></tr><tr><td align = \"center\" colspan=\"2\">"
                + "<br><p><b>"
                + lang.getString("Demo.p5.countingAw")
                + "</b></p>"
                + "<table border=\"1\" width=\"90%\"><tr><td>&#x03C9, "
                + lang.getString("Demo.p5.rad_s")
                + "</td>";
        for (int i = 0; i < sg.getFs().getA_w().getfA_w_count(); i++) {
            webContent+="<td>";
            webContent+=String.valueOf(Math.rint(sg.getFs().getA_w().getWValue(i)));
            webContent+="</td>";}
        webContent+= "</tr><tr><td>A(&#x03C9)</td>";
        for (int i = 0; i < sg.getFs().getA_w().getfA_w_count(); i++) {
            webContent+="<td>";
            webContent+=String.valueOf(Math.rint(sg.getFs().getA_w().getfA_w(i)*1000)/1000);
            webContent+="</td>";}
        webContent+= "</tr></table>"
                + "</td></tr></table></body></html>";
        wv.getEngine().loadContent(webContent);
        rootLayout.getChildren().add(wv);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
