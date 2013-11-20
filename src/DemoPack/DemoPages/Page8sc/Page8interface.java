// Общий интерфейс page 8

package DemoPack.DemoPages.Page8sc;

import DemoPack.DemoSystemGenerator;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Radeon
 */
public class Page8interface {
    private Label infoLab2;
    private GridPane rootLayout;
    
    public Page8interface (DemoSystemGenerator sg, ResourceBundle lang) {
        infoLab2 = new Label(lang.getString("Demo.p8.def")); 
        infoLab2.setWrapText(true);
        infoLab2.setPrefWidth(200);
        infoLab2.setAlignment(Pos.CENTER);
        infoLab2.setTextAlignment(TextAlignment.RIGHT);
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.add(infoLab2, 0, 1);
        rootLayout.add(ChartCreation_page8.getChart(sg, lang.getString("Demo.p8.chartTitle")), 1, 1, 1, 2);
        rootLayout.setPrefSize(1000, 1000);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
