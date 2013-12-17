package TestPack.TestPages.Page7sc;

import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Uw;
import DiffModesCommon.DataModel.Vw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page7interface extends TestPageInterface {
    private String[] Uw_arr, Vw_arr;
    private boolean valuesCounted;
    private final WebView functionsView;
    private final WebView tableView;
    private final VBox rootLayout;

    public Page7interface(final TestSystemGenerator sg, final ResourceBundle lang) {
        valuesCounted = false;
        Uw_arr = new String[TestSystemGenerator.getAfLen()];
        Vw_arr = new String[TestSystemGenerator.getAfLen()];
        
        { String[] data = sg.getPageData(6);
          int cnt = TestSystemGenerator.getAfLen();
            for (int i = 0; i < cnt; i++) {
                Uw_arr[i] = data[i];
                Vw_arr[i] = data[i+cnt];
            } 
        }
        
        functionsView = new WebView();
        loadFunctions(sg, lang);
        
        tableView = new WebView();
        loadTable(sg, lang);
        
        Button calcBtn = new Button(lang.getString("Test.p7.CalcBtn"));
        calcBtn.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                    calcArrays(sg);
                    loadTable(sg, lang);
                }     
        });
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.getChildren().add(functionsView);
        rootLayout.getChildren().add(calcBtn);
        rootLayout.getChildren().add(tableView);
        
    }
    
    private void loadFunctions (final TestSystemGenerator sg, final ResourceBundle lang) {
        String [] data = sg.getPageData(3);
        //k, mU, nU, mV, nV, h, e, ...
        
        String content = "<p align=\"center\">" 
                + lang.getString("Test.p7.FrecFuncTitle") + "</p>"
                + "<p align=\"center\">" 
                + Uw.printUw(data[0], data[5], data[1], data[2])
                + ";</p>"
                + "<p align=\"center\">" 
                + Vw.printVw(data[6], data[3], data[4])
                + ".</p><p align=\"center\">" 
                + lang.getString("Test.p7.CalcLbl") + "</p>";
        functionsView.getEngine().loadContent(content);
    }
    
    private void loadTable(final TestSystemGenerator sg, final ResourceBundle lang) {        
        String content = "<p align=\"center\">" 
                + lang.getString("Test.p7.TableTitle") + "</p>"
                + "<table align=\"center\" width=\"90%\" border=\"1\">"
                + "<tr bgcolor=\"#" + AppStyles.demoTableTopicColor() + "\">"
                + "<td align=\"center\">ω, рад/с</td>"
                + "<td align=\"center\">U(ω)</td>"
                + "<td align=\"center\">V(ω)</td>"
                + "<td align=\"center\">ω, рад/с</td>"
                + "<td align=\"center\">U(ω)</td>"
                + "<td align=\"center\">V(ω)</td></tr>";
        int j = TestSystemGenerator.getAfLen()/2;
        String u1="", u2="", v1="", v2="";
        valuesCounted = true; 
        for (int i = 0; i < j; i++) {
            u1 = changeVal(Uw_arr[i]);
            v1 = changeVal(Vw_arr[i]);
            u2 = changeVal(Uw_arr[i+j]);
            v2 = changeVal(Vw_arr[i+j]);
            
            content+= "<tr" 
                    + ((i%2)==0? ">":" bgcolor=\""+ AppStyles.demoTableLinesColor() +"\">")
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getW(i)) + "</td>"
                    + "<td align = \"center\">"
                        + u1 + "</td>"
                    + "<td align = \"center\">"
                        + v1 + "</td>"
                    + "<td align = \"center\">"
                        + String.valueOf(sg.getW(i+j)) + "</td>"
                    + "<td align = \"center\">"
                        + u2 + "</td>"
                    + "<td align = \"center\">"
                        + v2 + "</td>"
                    + "</tr>";
        }
        tableView.getEngine().loadContent(content);   
    };
    
    /**Сервисная функция для loadTable(...)*/
    private String changeVal (String arrValue) {
        String s;
        if (arrValue.equals("-100.0")) {
            s="?"; valuesCounted = false; }
        else s = arrValue;
        return s;
    }
    
    private void calcArrays(final TestSystemGenerator sg) {
        String k, mU, nU, mV, nV, h, e;
        String [] data = sg.getPageData(3);
          //k, mU, nU, mV, nV, h, e, ...
        k = data[0];       mU = data[1];      nU = data[2];
        mV = data[3];      nV = data[4];      h = data[5];
        e = data[6]; 
        
        valuesCounted = true;
        for (int i = 0; i < TestSystemGenerator.getAfLen(); i++) {
            Uw_arr[i] = String.valueOf(Uw.calcU(k, h, mU, nU, sg.getW(i)));
            Vw_arr[i] = String.valueOf(Vw.calcV(e, mV, nV, sg.getW(i))); 
            if(Uw_arr[i].equals("-100.0")) valuesCounted = false;
            if(Vw_arr[i].equals("-100.0")) valuesCounted = false;
        }
    }
    
    /** @return интерфейс 7й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg)  {
        saveData(sg);
        sg.checkPage(6);
        return valuesCounted;
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {       
        sg.saveStud_p6(Uw_arr, Vw_arr);
    }
}
