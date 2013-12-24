// Общий интерфейс page 8

package DemoPack.DemoPages.Page8sc;

import DemoPack.DemoPages.DemoPageInterface;
import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Radeon
 */
public class Page8interface  extends DemoPageInterface {
    private final Label infoLab2;
    private final GridPane rootLayout;
    
    public Page8interface (DemoSystemGenerator sg, ResourceBundle lang) {
        infoLab2 = new Label(lang.getString("Demo.p8.def")); 
        infoLab2.setWrapText(true);
        infoLab2.setTextAlignment(TextAlignment.RIGHT);
        infoLab2.setStyle(AppStyles.readingFontStyle());
        
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.CENTER);
        
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        col0.setPercentWidth(18);
        col1.setPercentWidth(80);
        rootLayout.getColumnConstraints().addAll(col0, col1);
        
        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(98); 
        rootLayout.getRowConstraints().addAll(row0);
        
        rootLayout.add(infoLab2, 0, 0);
        rootLayout.add(ChartCreation_page8.getChart(sg, lang.getString("Demo.p8.chartTitle")), 1, 0);
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
