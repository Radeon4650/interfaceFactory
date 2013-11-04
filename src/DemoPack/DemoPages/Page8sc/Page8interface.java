// Общий интерфейс page 8

package DemoPack.DemoPages.Page8sc;

import interfacefactory.SystemGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Radeon
 */
public class Page8interface {
    private Label infoLab1;
    private Label infoLab2;
    private GridPane rootLayout;
    
    public Page8interface (SystemGenerator sg) {
        infoLab1 = new Label("Page 8 Test"); 
        infoLab2 = new Label("Амплитудно-фазочастотная характеристика (АФЧХ) "
                + "линеаризованного объекта исследования представляет собой "
                + "траекторию движения (годограф) конца вектора W(jω) при "
                + "изменении частоты."); 
        infoLab2.setWrapText(true);
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.add(infoLab1, 0, 0);
        rootLayout.add(infoLab2, 0, 1);
        rootLayout.add(ChartCreation_page8.getChart(sg), 1, 1, 1, 2);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }    
    
}
