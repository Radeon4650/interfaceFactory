//Основной интерфейс ДЕМО-режима
package DemoPack;

import interfacefactory.SystemGenerator;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.input.SwipeEvent;
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
        final Pagination pgnCtrl = new Pagination(8, 0);
        dInterface = new BorderPane();
        HBox hbTop = new HBox();
        hbTop.getChildren().addAll(new Label("DEMO"), new Label("Получение амплитудо-фазочастотных характеристик"));
        hbTop.setAlignment(Pos.CENTER);  
        dInterface.setTop(hbTop);        
        
        pgnCtrl.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex)
            {
                return ConcretePageLayout.returnRootLayout(pageIndex, sg);
            }
        });
        
        pgnCtrl.setOnSwipeLeft(new EventHandler<SwipeEvent>() {
        @Override public void handle(SwipeEvent event) {
            int i =pgnCtrl.getCurrentPageIndex();
            i+=(i<8?1:0);
            pgnCtrl.currentPageIndexProperty().set(i);
            System.out.println("swipe left");
            event.consume();
        }});
        
        pgnCtrl.setOnSwipeRight(new EventHandler<SwipeEvent>() {
        @Override public void handle(SwipeEvent event) {
            int i =pgnCtrl.getCurrentPageIndex();
            i-=(i>1?1:0);
            pgnCtrl.currentPageIndexProperty().set(i);
            System.out.println("swipe right");
            event.consume();
        }});
        
        dInterface.setCenter(pgnCtrl);
        
    }
    
    public BorderPane getdInterface() {
        return dInterface;
    }
    
}
