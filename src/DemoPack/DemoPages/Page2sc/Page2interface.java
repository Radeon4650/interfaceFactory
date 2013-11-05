// Общий интерфейс page 2

package DemoPack.DemoPages.Page2sc;

import interfacefactory.PromptSet;
import interfacefactory.SystemGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page2interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page2interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 2 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>Находим корни характеристического "
                + "уравнения:</b></p>"
                + sg.getFs().printChEquationInMathML() + ";<br><br>"
                + sg.getFs().printDInMathML() + ";<br><br>"
                + sg.getFs().printS1inMathML() + ";<br><br>"
                + sg.getFs().printS2inMathML() + ";<br>"
                + "</td><td width=\"33%\" align=\"left\">"
                + PromptSet.getPrompt("formula_sqEquation")
                +"</td></tr><tr><td align = \"center\">"
                + "<p><b>Вычисляем постоянные времени:</b></p>"
                + sg.getFs().printT1inMathML() + ";\t"
                + sg.getFs().printT2inMathML() + ".</td><td>"
                + PromptSet.getPrompt("formula_T1_T2")
                + "</td></tr></table></body></html>");
        rootLayout.getChildren().add(wv);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
}
