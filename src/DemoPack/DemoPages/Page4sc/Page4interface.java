// Общий интерфейс page 4

package DemoPack.DemoPages.Page4sc;

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
public class Page4interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page4interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 4 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>Умножаем и делим Ф(j&#x03C9) на "
                + "комплексно сопряженное знаменателю выражение, чтобы "
                + "избавиться от мнимой единицы в знаменателе:</b></p>"
                + sg.getFs().printInMathMLwithComplConExpr()
                + ";<br><br>"
                + sg.getFs().printInMathMLwithUwVw()
                + ".<br></td><td width=\"33%\" align=\"left\">"
                + PromptSet.getPrompt("abridgedMulFormula")
                + "</td></tr><tr><td colspan =\"2\" align = \"center\"><br>"
                + "<p><b>Выделяем действительную U(&#x03C9) и мнимую "
                + "V(&#x03C9) частотные функции:</b></p>"
                + sg.getFs().getU_w().printInMathML() + ";\t"
                + sg.getFs().getV_w().printInMathML() + "."
                + "</td></tr></table></body></html>"
        );
        rootLayout.getChildren().add(wv);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
