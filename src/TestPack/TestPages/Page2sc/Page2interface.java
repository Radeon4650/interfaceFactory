package TestPack.TestPages.Page2sc;

import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Fs;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page2interface extends TestPageInterface{
    // Поля ввода для значений коэффициентов, дискриминанта,
    // корней характеристического уравнения и постоянных времени системы
    protected final TextField aTextField;
    protected final TextField bTextField;
    protected final TextField cTextField;
    protected final TextField DTextField;
    protected final TextField s1TextField;
    protected final TextField s2TextField;
    protected final TextField t1TextField;
    protected final TextField t2TextField;
    
    protected final GridPane rootLayout;

    public Page2interface(TestSystemGenerator sg, ResourceBundle lang) {
        WebView fsGuideView = new WebView();
        { //Выводим студенческую передаточную функцию, полученную на предыдущем шаге:
            String [] data = sg.getPageData(0);
            fsGuideView.getEngine().loadContent("<html><body><p align=\"center\">"
                   + "<font face=\"" + AppStyles.readingFont()
                   + "\">" + lang.getString("Test.p2.transFuncTitle")
                   + "</font></p><p align=\"center\">"
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
        
        chEqGuideLabel.setStyle(AppStyles.originalFontStyle());
        DGuideLabel.setStyle(AppStyles.originalFontStyle());
        sGuideLabel.setStyle(AppStyles.originalFontStyle());
        tGuideLabel.setStyle(AppStyles.originalFontStyle());
                
        
        Label aLabel = new Label("a =");
        Label bLabel = new Label("b =");
        Label cLabel = new Label("c =");
        Label DLabel = new Label("D =");
        Label s1Label = new Label("s1 =");
        Label s2Label = new Label("s2 =");
        Label t1Label = new Label("T1 =");
        Label t2Label = new Label("T2 =");
        
        aLabel.setStyle(AppStyles.originalFontStyle());
        bLabel.setStyle(AppStyles.originalFontStyle());
        cLabel.setStyle(AppStyles.originalFontStyle());
        DLabel.setStyle(AppStyles.originalFontStyle());
        s1Label.setStyle(AppStyles.originalFontStyle());
        s2Label.setStyle(AppStyles.originalFontStyle());
        t1Label.setStyle(AppStyles.originalFontStyle());
        t2Label.setStyle(AppStyles.originalFontStyle());
        
        aTextField = new TextField();
        bTextField = new TextField();
        cTextField = new TextField();
        DTextField = new TextField();
        s1TextField = new TextField();
        s2TextField = new TextField();
        t1TextField = new TextField();
        t2TextField = new TextField();
        
        aTextField.setStyle(AppStyles.originalFontStyle());
        bTextField.setStyle(AppStyles.originalFontStyle());
        cTextField.setStyle(AppStyles.originalFontStyle());
        DTextField.setStyle(AppStyles.originalFontStyle());
        s1TextField.setStyle(AppStyles.originalFontStyle());
        s2TextField.setStyle(AppStyles.originalFontStyle());
        t1TextField.setStyle(AppStyles.originalFontStyle());
        t2TextField.setStyle(AppStyles.originalFontStyle());
        
        
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
        rootLayout.add(chEqGuideLabel, 0, 0, 5, 1);
        rootLayout.add(fsGuideView, 0, 1, 4, 1);
        rootLayout.add(aLabel, 1, 2);       rootLayout.add(aTextField, 2, 2);
        rootLayout.add(bLabel, 1, 3);       rootLayout.add(bTextField, 2, 3);
        rootLayout.add(cLabel, 1, 4);       rootLayout.add(cTextField, 2, 4);
        rootLayout.add(DGuideLabel, 0, 5, 4, 1);
        rootLayout.add(DLabel, 1, 6);       rootLayout.add(DTextField, 2, 6);
        rootLayout.add(sGuideLabel, 0, 7, 4, 1);
        rootLayout.add(s1Label, 1, 8);      rootLayout.add(s1TextField, 2, 8);
        rootLayout.add(s2Label, 1, 9);     rootLayout.add(s2TextField, 2, 9);
        rootLayout.add(tGuideLabel, 0, 10, 4, 1);
        rootLayout.add(t1Label, 1, 11);     rootLayout.add(t1TextField, 2, 11);
        rootLayout.add(t2Label, 1, 12);     rootLayout.add(t2TextField, 2, 12);
        
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        ColumnConstraints col4 = new ColumnConstraints();
        
        col0.setPercentWidth(20);
        col0.setHalignment(HPos.CENTER);
        col1.setPercentWidth(5);
        col1.setHalignment(HPos.RIGHT);
        col2.setHalignment(HPos.LEFT);
        col3.setPercentWidth(20);
        col4.setMaxWidth(200);
        rootLayout.getColumnConstraints().addAll(col0, col1, col2, col3, col4);
        
        RowConstraints rc0 = new RowConstraints();
        RowConstraints rc1 = new RowConstraints();
        RowConstraints rc2 = new RowConstraints();
        RowConstraints rc3 = new RowConstraints();
        RowConstraints rc4 = new RowConstraints();
        RowConstraints rc5 = new RowConstraints();
        RowConstraints rc6 = new RowConstraints();
        RowConstraints rc7 = new RowConstraints();
        RowConstraints rc8 = new RowConstraints();
        RowConstraints rc9 = new RowConstraints();
        RowConstraints rc10 = new RowConstraints();
        RowConstraints rc11 = new RowConstraints();
        RowConstraints rc12 = new RowConstraints();
        
        rc0.setPercentHeight(5);
        rc1.setPercentHeight(25);
        rc2.setPercentHeight(6);
        rc3.setPercentHeight(6);
        rc4.setPercentHeight(6);
        rc5.setPercentHeight(4);
        rc6.setPercentHeight(6);
        rc7.setPercentHeight(4);
        rc8.setPercentHeight(6);
        rc9.setPercentHeight(6);
        rc10.setPercentHeight(4);
        rc11.setPercentHeight(11);
        rc12.setPercentHeight(11);
        
        
        rootLayout.getRowConstraints().addAll(rc0, rc1, rc2, rc3, rc4, rc5, 
                rc6, rc7, rc8, rc9, rc10, rc11, rc12);
    }
    
    /** @return интерфейс 2й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        if (aTextField.getText().equals("")) return false;
        if (bTextField.getText().equals("")) return false;
        if (cTextField.getText().equals("")) return false;
        if (DTextField.getText().equals("")) return false;
        if (s1TextField.getText().equals("")) return false;
        if (s2TextField.getText().equals("")) return false;
        if (t1TextField.getText().equals("")) return false;
        if (t2TextField.getText().equals("")) return false;
        
        saveData(sg);
        sg.checkPage(1);
        return true;
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.setStudentChEqCoeff_p1(aTextField.getText(), bTextField.getText(), 
                    cTextField.getText());
        sg.setStudD_p1(DTextField.getText());
        sg.setStudS_p1(s1TextField.getText(), s2TextField.getText());
        sg.setStudT_p1(t1TextField.getText(), t2TextField.getText());
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        
    }
}
