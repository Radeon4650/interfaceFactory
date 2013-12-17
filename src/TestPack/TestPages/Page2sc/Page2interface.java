package TestPack.TestPages.Page2sc;

import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Fs;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page2interface extends TestPageInterface{
    // Поля ввода для значений коэффициентов, дискриминанта,
    // корней характеристического уравнения и постоянных времени системы
    private final TextField aTextField;
    private final TextField bTextField;
    private final TextField cTextField;
    private final TextField DTextField;
    private final TextField s1TextField;
    private final TextField s2TextField;
    private final TextField t1TextField;
    private final TextField t2TextField;
    
    private final GridPane rootLayout;

    public Page2interface(TestSystemGenerator sg, ResourceBundle lang) {
        WebView fsGuideView = new WebView();
        { //Выводим студенческую передаточную функцию, полученную на предыдущем шаге:
            String [] data = sg.getPageData(0);
            fsGuideView.getEngine().loadContent("<html><body><b><p align=\"center\">"
                   + lang.getString("Test.p2.transFuncTitle")
                   + "</p></b><p align=\"center\">"
                   + Fs.printInMathMLWith_abc_s(data[0], data[1], data[2], data[3])
                   + ".</p></body></html>"); }
        
        Label chEqGuideLabel = new Label();
        Label DGuideLabel = new Label();
        Label sGuideLabel = new Label();
        Label tGuideLabel = new Label();
        chEqGuideLabel.setText(lang.getString("Test.p2.ChEqInput"));
        DGuideLabel.setText(lang.getString("Test.p2.DInput"));
        sGuideLabel.setText(lang.getString("Test.p2.sInput"));
        tGuideLabel.setText(lang.getString("Test.p2.tInput"));
                
        
        Label aLabel = new Label("a =");
        Label bLabel = new Label("b =");
        Label cLabel = new Label("c =");
        Label DLabel = new Label("D =");
        Label s1Label = new Label("s1 =");
        Label s2Label = new Label("s2 =");
        Label t1Label = new Label("T1 =");
        Label t2Label = new Label("T2 =");
        
        aTextField = new TextField();
        bTextField = new TextField();
        cTextField = new TextField();
        DTextField = new TextField();
        s1TextField = new TextField();
        s2TextField = new TextField();
        t1TextField = new TextField();
        t2TextField = new TextField();
        
        
          // Заполняем поля ввода числами, введенными ранее
          // Если ранее числа введены не были (их значения равны нулю),
          // оставляем поля ввода пустыми.
        { String [] data = sg.getPageData(1);
          aTextField.setText(data[0]); 
          bTextField.setText(data[1]);
          cTextField.setText(data[2]);
          DTextField.setText(data[3]);
          s1TextField.setText(data[4]);
          s2TextField.setText(data[5]);
          t1TextField.setText(data[6]);
          t2TextField.setText(data[7]);  }
        
        
        aTextField.setPromptText("a");
        bTextField.setPromptText("b");
        cTextField.setPromptText("c");
        DTextField.setPromptText("D");
        s1TextField.setPromptText("s1");
        s2TextField.setPromptText("s2");
        t1TextField.setPromptText("T1");
        t2TextField.setPromptText("T2");
        
        aTextField.setTooltip(new Tooltip(lang.getString("Test.p2.aTextFieldHint")));
        bTextField.setTooltip(new Tooltip(lang.getString("Test.p2.bTextFieldHint")));
        cTextField.setTooltip(new Tooltip(lang.getString("Test.p2.cTextFieldHint")));
        DTextField.setTooltip(new Tooltip(lang.getString("Test.p2.DTextFieldHint")));
        s1TextField.setTooltip(new Tooltip(lang.getString("Test.p2.s1TextFieldHint")));
        s2TextField.setTooltip(new Tooltip(lang.getString("Test.p2.s2TextFieldHint")));
        t1TextField.setTooltip(new Tooltip(lang.getString("Test.p2.t1TextFieldHint")));
        t2TextField.setTooltip(new Tooltip(lang.getString("Test.p2.t2TextFieldHint")));
        
        
        aTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(aTextField);
            }
        });
        bTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(bTextField);
            }
        });
        cTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(cTextField);
            }
        });
        DTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(DTextField);
            }
        });
        s1TextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(s1TextField);
            }
        });
        s2TextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(s2TextField);
            }
        });
        t1TextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(t1TextField);
            }
        });
        t2TextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(t2TextField);
            }
        });
        
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.add(chEqGuideLabel, 0, 0, 2, 1);
        rootLayout.add(fsGuideView, 0, 1, 2, 1);
        rootLayout.add(aLabel, 0, 3);       rootLayout.add(aTextField, 1, 3);
        rootLayout.add(bLabel, 0, 4);       rootLayout.add(bTextField, 1, 4);
        rootLayout.add(cLabel, 0, 5);       rootLayout.add(cTextField, 1, 5);
        rootLayout.add(DGuideLabel, 0, 6, 2, 1);
        rootLayout.add(DLabel, 0, 7);       rootLayout.add(DTextField, 1, 7);
        rootLayout.add(sGuideLabel, 0, 8, 2, 1);
        rootLayout.add(s1Label, 0, 9);      rootLayout.add(s1TextField, 1, 9);
        rootLayout.add(s2Label, 0, 10);     rootLayout.add(s2TextField, 1, 10);
        rootLayout.add(tGuideLabel, 0, 11, 2, 1);
        rootLayout.add(t1Label, 0, 12);     rootLayout.add(t1TextField, 1, 12);
        rootLayout.add(t2Label, 0, 13);     rootLayout.add(t2TextField, 1, 13);
        
    }
    
    /** @return интерфейс 2й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg) {
        try {
            saveData(sg);
            sg.checkPage(1);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.setStudentChEqCoeff_p1(aTextField.getText(), bTextField.getText(), 
                    cTextField.getText());
        sg.setStudD_p1(DTextField.getText());
        sg.setStudS_p1(s1TextField.getText(), s2TextField.getText());
        sg.setStudT_p1(t1TextField.getText(), t2TextField.getText());
    }
}
