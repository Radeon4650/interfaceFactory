// Общий интерфейс page 5

package DemoPack.DemoPages.Page5sc;

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
public class Page5interface {
    private Label infoLab1;
    private VBox rootLayout;
    
    public Page5interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 5 Test"); 
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        String webContent = "<p><b>Получаем функцию АЧХ:</b></p>"
                + PromptSet.getPrompt("formula_Aw")
                + sg.getFs().getA_w().a_wObtaining()
                + ";<br>"
                + sg.getFs().getA_w().printInMathML() +"."
                + "<p><b>Рассчитываем АЧХ для различных значений частоты "
                + "&#x03C9 и заносим в таблицу:</b></p>"
                + "<table border=\"1\"><tr><td>&#x03C9, рад/с</td>";
        for (int i = 0; i < sg.getFs().getA_w().getfA_w_count(); i++) {
            webContent+="<td>";
            webContent+=String.valueOf(Math.rint(sg.getFs().getA_w().getWValue(i)));
            webContent+="</td>";}
        webContent+= "</tr><tr><td>A(&#x03C9)</td>";
        for (int i = 0; i < sg.getFs().getA_w().getfA_w_count(); i++) {
            webContent+="<td>";
            webContent+=String.valueOf(Math.rint(sg.getFs().getA_w().getfA_w(i)*1000)/1000);
            webContent+="</td>";}
        webContent+= "</tr></table>";
        wv.getEngine().loadContent(webContent);
        rootLayout.getChildren().add(wv);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
    
}
