//Основной интерфейс ДЕМО-режима
package DemoPack;

import interfacefactory.SystemGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * @author Radeon
 */
public class DemoInterface {
    private BorderPane dInterface;
    private SystemGenerator sg;
    
    public DemoInterface() {
        
        sg = new SystemGenerator();        
        
        dInterface = new BorderPane();
        HBox hbTop = new HBox();
        hbTop.getChildren().addAll(new Label("DEMO"), new Label("Получение амплитудо-фазочастотных характеристик"));
        hbTop.setAlignment(Pos.CENTER);
                
        dInterface.setTop(hbTop);        
        
        Pagination pgnCtrl = new Pagination(8, 0);
        pgnCtrl.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex)
            {
                return ConcretePageLayout.returnRootLayout(pageIndex, sg);
            }
        });
        dInterface.setCenter(pgnCtrl);
        
    }
    
    public BorderPane getdInterface() {
        return dInterface;
    }
}
