// Общий интерфейс page 6

package DemoPack.DemoPages.Page6sc;

import DiffModesCommon.PromptSet;
import DemoPack.DemoSystemGenerator;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page6interface {
    private VBox rootLayout;
    
    public Page6interface (DemoSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        HBox box = new HBox();
        box.getChildren().add(ChartCreation_page6.getChart(sg.getFs().getA_w(), lang.getString("Demo.p6.chartBuilding")));

        WebView wv = new WebView();
        wv.setContextMenuEnabled(false);
        wv.getEngine().loadContent(PromptSet.getPrompt("formula_passband", lang)
                + "<p><b>"
                + lang.getString("Demo.p6.passband")
                + "</b></p>"
                + sg.getFs().getA_w().printInMathMLApr(lang.getString("Demo.p6.pbSup"))
                + ";<br>"
                + sg.getFs().getA_w().printInMathMLwPr(lang.getString("Demo.p6.pbSup"), lang.getString("Demo.p6.rad_s")) + "."
        );
        box.getChildren().add(wv);
        rootLayout.getChildren().add(box);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
