// Общий интерфейс page 6

package DemoPack.DemoPages.Page6sc;

import interfacefactory.PromptSet;
import interfacefactory.SystemGenerator;
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
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page6interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 6 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        HBox box = new HBox();
        box.getChildren().add(ChartCreation_page6.getChart(sg.getFs().getA_w()));

        WebView wv = new WebView();
        wv.getEngine().loadContent(PromptSet.getPrompt("formula_passband")
                + "<p><b>Вычисляем полосу пропускания системы:</b></p>"
                + sg.getFs().getA_w().printInMathMLApr()
                + ";<br>"
                + sg.getFs().getA_w().printInMathMLwPr() + "."
        );
        box.getChildren().add(wv);
        rootLayout.getChildren().add(box);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
