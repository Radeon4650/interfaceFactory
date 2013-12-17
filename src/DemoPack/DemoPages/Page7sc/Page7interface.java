// Общий интерфейс page 7
package DemoPack.DemoPages.Page7sc;

import DemoPack.DemoPages.DemoPageInterface;
import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page7interface extends DemoPageInterface {
    private ObservableList<ApfcValues> tableItems;
//    private TableView apfcTable;
    private VBox rootLayout;
    
    public Page7interface (DemoSystemGenerator sg, ResourceBundle lang) {
        String tableTopicColor = AppStyles.demoTableTopicColor();
        String tableLinesColor = AppStyles.demoTableLinesColor();
        String webContent = "<p><b>"
                + lang.getString("Demo.p7.tableTopic")
                + "</b></p>"
                + "<table border=\"1\" width=\"90%\" align = \"center\">"
                + "<tr bgcolor=\"#" + tableTopicColor + "\">"
                + "<td align = \"center\">&#x03C9, "
                + lang.getString("Demo.p7.rad_s")
                + "</td>"
                + "<td align = \"center\">U(&#x03C9)</td>"
                + "<td align = \"center\">V(&#x03C9)</td>"
                + "<td align = \"center\">&#x03C9, "
                + lang.getString("Demo.p7.rad_s")
                + "</td>"
                + "<td align = \"center\">U(&#x03C9)</td>"
                + "<td align = \"center\">V(&#x03C9)</td></tr>";
                
        int j = sg.getAfLen()/2;
        for (int i = 0; i < j; i++) {
            webContent+= "<tr" + ((i%2)==0? ">":" bgcolor=\""+ tableLinesColor +"\">")
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
        rootLayout.getChildren().addAll(wv);
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }
}
