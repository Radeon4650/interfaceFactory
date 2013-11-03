// Общий интерфейс page 7
package DemoPack.DemoPages.Page7sc;

import interfacefactory.SystemGenerator;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Radeon
 */
public class Page7interface {
    private ObservableList<ApfcValues> tableItems;
    private Label infoLab1;
    private TableView apfcTable;
    private VBox rootLayout;
    
    public Page7interface (SystemGenerator sg) {
        tableItems = ApfcListFactory.createApcfValues();
        infoLab1 = new Label("Рассчитываем значения действительной и мнимой частотной функции "
                + "для различных значений частоты и заносим в таблицу:");
        infoLab1.setWrapText(true);
        apfcTable = TableFactory.createTable(tableItems);
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER_LEFT);
        rootLayout.getChildren().addAll(infoLab1, apfcTable);
    }
    
    public Node getRootLayout(){
        return rootLayout;
    }
}
