//Основной интерфейс ДЕМО-режима
package DemoPack;

import DiffModesCommon.DataModel.Wd;
import DiffModesCommon.DataModel.Wk;
import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tooltip;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * @author Radeon
 */
public class DemoInterface {
    private BorderPane dInterface;
    private DemoSystemGenerator sg;
  
    /**Демо-страницы с решением задачи, сгенерированной автоматически
     * @param lang языковой набор данных для локализации приложения
     * @param ifFact страница, к которой переходит приложение по нажатию кнопки "Back"
     */
    public DemoInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        
        sg = new DemoSystemGenerator();        
        createInterface(lang, ifFact); 
    }
    
    /**Демо-страница с решением задачи, условие для которой вводится пользователем
     * @param lang языковой набор данных для локализации приложения
     * @param ifFact страница, к которой переходит приложение по нажатию кнопки "Back"
     * @param wk1 передаточная функция простейшего структурного блока (#1 на схеме)
     * @param wk2 передаточная функция простейшего структурного блока (#2 на схеме)
     * @param wd3 передаточная функция структурного блока 2го порядка (#3 на схеме)
     * @param wd4 передаточная функция структурного блока 2го порядка (#4 на схеме)
     * @param wk5 передаточная функция простейшего структурного блока (#5 на схеме)
     * @param wk6 передаточная функция простейшего структурного блока (#6 на схеме)
     */
    public DemoInterface(final ResourceBundle lang, final InterfaceFactory ifFact, 
            Wk wk1, Wk wk2, Wd wd3, Wd wd4, Wk wk5, Wk wk6) {
        
        sg = new DemoSystemGenerator(wk1, wk2, wd3, wd4, wk5, wk6);        
        createInterface(lang, ifFact); 
    }
    
    /**Создание общего интерфейса для Демо-режима*/
    private void createInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        final Pagination pgnCtrl = new Pagination(8, 0);
        dInterface = new BorderPane();
        HBox hbTop = new HBox();
        Label demoTitle = new Label(lang.getString("DemoInterface.modeTitle"));
        demoTitle.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.demoBtnHint")));
        Label lessonTitle = new Label(lang.getString("DemoInterface.lessonTitle"));
        hbTop.getChildren().addAll(demoTitle, lessonTitle);
        hbTop.setAlignment(Pos.CENTER);  
        hbTop.setPadding(new Insets(5, 5, 5, 5));
        hbTop.setSpacing(50);
        dInterface.setTop(hbTop);       
        Button btnBack = new Button(lang.getString("DemoInterface.btnBackTitle"));
        
        btnBack.setTooltip(new Tooltip(lang.getString("DemoInterface.btnBackHint")));
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadInitialInterface();
            }
        });
        
        
        pgnCtrl.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex)
            {
                return DemoFactory.returnRootLayout(pageIndex, sg, lang);
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
        

        dInterface.setMinSize(800, 600);
        dInterface.setCenter(pgnCtrl);
        dInterface.setBottom(btnBack);
    }
    
    public BorderPane getdInterface() {
        return dInterface;
    }
    
}
