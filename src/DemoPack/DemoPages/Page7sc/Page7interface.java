// Общий интерфейс page 7
package DemoPack.DemoPages.Page7sc;

import interfacefactory.SystemGenerator;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page7interface {
    private ObservableList<ApfcValues> tableItems;
    private Label infoLab1;
//    private TableView apfcTable;
    private VBox rootLayout;
    
    public Page7interface (SystemGenerator sg) {
        infoLab1 = new Label("Test page 7");
        String webContent = "<p><b>Рассчитываем значения действительной "
                + "и мнимой частотной функции для различных значений частоты "
                + "и заносим в таблицу:</b></p>"
                + "<table border=\"1\" width=\"90%\" align = \"center\"><tr>"
                + "<td bgcolor=\"#CCFF99\" align = \"center\">&#x03C9, рад/с</td>"
                + "<td bgcolor=\"#CCFF99\" align = \"center\">U(&#x03C9)</td>"
                + "<td bgcolor=\"#CCFF99\" align = \"center\">V(&#x03C9)</td>"
                + "<td bgcolor=\"#CCFF99\" align = \"center\">&#x03C9, рад/с</td>"
                + "<td bgcolor=\"#CCFF99\" align = \"center\">U(&#x03C9)</td>"
                + "<td bgcolor=\"#CCFF99\" align = \"center\">V(&#x03C9)</td></tr>";
                
        int j = sg.getAfLen()/2;
        for (int i = 0; i < j; i++) {
            webContent+= "<tr" + ((i%2)==0? ">":" bgcolor=\"FFCCCC\">")
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getW(i))+"</td>"
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getU(i))+"</td>"
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getV(i))+"</td>"
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getW(i+j))+"</td>"
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getU(i+j))+"</td>"
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getV(i+j))+"</td>"
                    + "</tr>";
        }
        webContent+= "</table>";
        WebView wv = new WebView();
        wv.getEngine().loadContent(webContent);
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().addAll(infoLab1, wv);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }
}
