package DemoPack;

import DemoPack.DemoPages.DemoPageInterface;
import DemoPack.DemoPages.Page1sc.Page1interface;
import DemoPack.DemoPages.Page2sc.Page2interface;
import DemoPack.DemoPages.Page3sc.Page3interface;
import DemoPack.DemoPages.Page4sc.Page4interface;
import DemoPack.DemoPages.Page5sc.Page5interface;
import DemoPack.DemoPages.Page6sc.Page6interface;
import DemoPack.DemoPages.Page7sc.Page7interface;
import DemoPack.DemoPages.Page8sc.Page8interface;
import DiffModesCommon.AppStyles;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;


public class DemoFactory {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.*/
    public static Node returnRootLayout(int pageNumber, DemoSystemGenerator sg, ResourceBundle lang) {
        DemoPageInterface dp;
        switch (pageNumber) {     
            case 0:
                dp = new Page1interface(sg, lang);
                break;
            case 1:
                dp = new Page2interface(sg, lang);
                break;
            case 2:
                dp = new Page3interface(sg, lang);
                break;
            case 3:
                dp = new Page4interface(sg, lang);
                break;
            case 4:
                dp = new Page5interface(sg, lang);
                break;
            case 5:
                dp = new Page6interface(sg, lang);
                break;
            case 6:
                dp = new Page7interface(sg, lang);
                break;
            case 7:
                dp = new Page8interface(sg, lang);
                break;
            default:
                throw new AssertionError();
        }
        return dp.getRootLayout();
    };
    
    public static Node returnDemoView(int pageNumber, final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        final GridPane demoView = new GridPane();
        
        demoView.setAlignment(Pos.CENTER);
        Label titleLab = new Label(lang.getString("DemoInterface.modeTitle"));
        titleLab.setStyle(AppStyles.titleFontStyle());
        Button closeDemoBtn = new Button(lang.getString("TrainerInterface.closeDemo"));
        closeDemoBtn.setStyle(AppStyles.originalFontStyle());
        closeDemoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                demoView.setVisible(false);
            }
        });
        
        demoView.add(titleLab, 0, 0);
        demoView.add(DemoFactory.returnRootLayout(pageNumber, dsg, lang), 0, 1);
        demoView.add(closeDemoBtn, 0, 2);
         
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHalignment(HPos.CENTER);
        col0.setPercentWidth(100);
        demoView.getColumnConstraints().add(col0);
        demoView.setStyle(AppStyles.mainStageRootStyle());

        ctrl.watchDemo(String.valueOf(pageNumber+1)); //Сообщаем диагностической модели, что студент подсмотрел в демо-режим
        return demoView;
    }
}
