// Общий интерфейс page 1

package DemoPack.DemoPages.Page1sc;

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
public class Page1interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page1interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 1 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
            
        WebView wv = new WebView();
        wv.getEngine().loadContent("<p><b>Структурная схема системы:</b></p>"
                + StructScheme.getStructScheme()
                + "<br><p><b>Исходные данные:</b></p>"
                + sg.getWk1().printInMathML()+";\t"+ sg.getWk5().printInMathML()
                + ";<br>"
                + sg.getWk2().printInMathML()+";\t"+ sg.getWk6().printInMathML()
                + ";<br>"
                + sg.getWd3().printInMathML()
                + ";<br>"
                + sg.getWd4().printInMathML()                
                + ".<br><p><b>Получаем передаточную функцию системы "
                + "по задающему воздействию:</b></p>"
                + PromptSet.getPrompt("formula_Fs")+ PromptSet.fsEquation()
                + ";<br>"
                + sg.getFs().printInMathMLWith_abc_s()+".");
                 
        rootLayout.getChildren().add(wv);     
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }
}
