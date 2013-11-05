// Общий интерфейс page 3

package DemoPack.DemoPages.Page3sc;

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
public class Page3interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page3interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 3 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width=\"100%\"><tr><td align = \"center\">"
                + "<p><b>Записываем передаточную функцию замкнутой"
                + " системы с использованием полученных постоянных времени:</b></p>"
                + sg.getFs().printInMathMLWith_t1t2_s()
                + ".<br></td><td width=\"33%\" align=\"left\">"
                + PromptSet.getPrompt("formula_Fs_t1t2")
                + "<br></td></tr><tr><td align = \"center\"><p><b>"
                + "Получаем частотную передаточную функцию замкнутой САУ:</b></p>"
                + sg.getFs().printInMathMLWith_t1t2_jw() + ".</td><td>"
                + PromptSet.getPrompt("replacementSjw")
                + "</td></tr></table></body></html>"
        );
        rootLayout.getChildren().add(wv);
        
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
