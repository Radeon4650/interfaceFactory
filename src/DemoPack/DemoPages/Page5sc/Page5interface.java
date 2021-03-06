// Общий интерфейс page 5

package DemoPack.DemoPages.Page5sc;

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
public class Page5interface extends DemoPageInterface {
    private VBox rootLayout;
    
    public Page5interface (DemoSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        WebView wv = new WebView();
        String webContent = "<html><body><font face=\"" 
                + AppStyles.readingFont() + "\">"
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
                + "</b></p></font><font face=\"" 
                + AppStyles.originalFont() + "\">"
                + "<table width=\"90%\"><tr><td>&#x03C9, "
                + lang.getString("Demo.p5.rad_s")
                + "</td>";
        for (int i = 0; i < sg.getFs().getA_w().getfA_w_count(); i++) {
            webContent+="<td" + ((i%2)==1? ">":" bgcolor=\""+ AppStyles.demoTableLinesColor() +"\">");
            webContent+=String.valueOf(Math.rint(sg.getFs().getA_w().getWValue(i)));
            webContent+="</td>";}
        webContent+= "</tr><tr><td>A(&#x03C9)</td>";
        for (int i = 0; i < sg.getFs().getA_w().getfA_w_count(); i++) {
            webContent+="<td" + ((i%2)==1? ">":" bgcolor=\""+ AppStyles.demoTableLinesColor() +"\">");
            webContent+=String.valueOf(Math.rint(sg.getFs().getA_w().getfA_w(i)*1000)/1000);
            webContent+="</td>";}
        webContent+= "</tr></table>"
                + "</td></tr></table></font></body></html>";
        wv.getEngine().loadContent(webContent);
        rootLayout.getChildren().add(wv);
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
