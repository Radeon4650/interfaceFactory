package TestPack.TestPages.Page3sc;

import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;

/**
 * Страница 3 режима "Тест"
 * @author radeon
 */
public class Page3interface extends TestPageInterface {
    protected final GridPane rootLayout;
    private final TextField kTextField;
    private final TextField t1TextField;
    private final TextField t2TextField;
    private final ChoiceBox replChBox;
    private final WebView fsView;
    private final WebView fjwView;
    
    private final String [] rep = {"t", "jω", "Ф", "iω"};

    public Page3interface(TestSystemGenerator sg, final ResourceBundle lang) {
        Label ktTitleLabel = new Label(lang.getString("Test.p3.ktTitle"));
        Label kLabel = new Label("k =");
        Label t1Label = new Label("T1 =");
        Label t2Label = new Label("T2 =");
        
        ktTitleLabel.setStyle(AppStyles.originalFontStyle());
        kLabel.setStyle(AppStyles.originalFontStyle());
        t1Label.setStyle(AppStyles.originalFontStyle());
        t2Label.setStyle(AppStyles.originalFontStyle());
        
        kTextField = new TextField();
        t1TextField = new TextField();
        t2TextField = new TextField();
        
        kTextField.setStyle(AppStyles.originalFontStyle());
        t1TextField.setStyle(AppStyles.originalFontStyle());
        t2TextField.setStyle(AppStyles.originalFontStyle());
       
        kTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                textFieldUpdate(kTextField, lang);                
            }
        });
        t1TextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                textFieldUpdate(t1TextField, lang);
            }
        });
        t2TextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                textFieldUpdate(t2TextField, lang);
            }
        });
        
        kTextField.setPromptText("k");
        t1TextField.setPromptText("T1");
        t2TextField.setPromptText("T2");
        
        kTextField.setTooltip(new Tooltip(lang.getString("Test.p3.kTextFieldHint")));
        t1TextField.setTooltip(new Tooltip(lang.getString("Test.p3.t1TextFieldHint")));
        t2TextField.setTooltip(new Tooltip(lang.getString("Test.p3.t2TextFieldHint")));
        

        Label replTitleLabel = new Label(lang.getString("Test.p3.replacementSjw"));
        replTitleLabel.setStyle(AppStyles.originalFontStyle());
        Label replLabel = new Label("s →");
        replLabel.setStyle(AppStyles.originalFontStyle());
        replChBox = new ChoiceBox();
        replChBox.setStyle(AppStyles.originalFontStyle());
        replChBox.setItems(FXCollections.observableArrayList(rep));
        
        
        // Заполняем поля ввода числами, введенными ранее
          // Если ранее числа введены не были (их значения равны нулю),
          // оставляем поля ввода пустыми.
        { String [] data = sg.getPageData(2);
          kTextField.setText(data[0]);
          t1TextField.setText(data[1]);
          t2TextField.setText(data[2]); 
          replChBox.getSelectionModel().select(Integer.parseInt(data[3]));
        }
        
        replChBox.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue ov, Number value, Number newValue) {
                    refreshFjwView(lang, newValue.intValue());
                }
            
        });
        
        fsView = new WebView();
        fjwView = new WebView();
        
        refreshFsView(lang);
        refreshFjwView(lang, replChBox.getSelectionModel().getSelectedIndex());
        
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.CENTER);
        ColumnConstraints grid_col0 = new ColumnConstraints();
        ColumnConstraints grid_col1 = new ColumnConstraints();
        ColumnConstraints grid_col2 = new ColumnConstraints();
        grid_col0.setPercentWidth(70);
        
        grid_col1.setPercentWidth(8);
        grid_col2.setPercentWidth(18);
        grid_col1.setHalignment(HPos.RIGHT);
        rootLayout.getColumnConstraints().addAll(grid_col0, grid_col1, grid_col2);
        
        rootLayout.add(fsView, 0, 0, 1, 5);
        rootLayout.add(fjwView, 0, 5, 1, 3);
        
        rootLayout.add(ktTitleLabel, 1, 0, 2, 1);
        rootLayout.add(kLabel, 1, 1);       rootLayout.add(kTextField, 2, 1);
        rootLayout.add(t1Label, 1, 2);      rootLayout.add(t1TextField, 2, 2);
        rootLayout.add(t2Label, 1, 3);      rootLayout.add(t2TextField, 2, 3);
        
        rootLayout.add(replTitleLabel, 1, 5, 2, 1);
        rootLayout.add(replLabel, 1, 6);    rootLayout.add(replChBox, 2, 6);
    }
    
    private void textFieldUpdate(final TextField tf, final ResourceBundle lang) {
        AppStyles.styleSetter(tf);
        refreshFsView(lang);
        if (replChBox.getSelectionModel().getSelectedIndex()!=-1)
            refreshFjwView(lang, replChBox.getSelectionModel().getSelectedIndex());
    }
    
    private String printF(final String rep) {
        String kTxt, t1Txt, t2Txt;
        kTxt = kTextField.getText();
        if (kTxt.equals("")) kTxt = kTextField.getPromptText();
        t1Txt = t1TextField.getText();
        if (t1Txt.equals("")) t1Txt = "<msub><mi>T</mi><mn>1</mn></msub>";
        else t1Txt = "<mi>" + t1Txt + "</mi>";
        t2Txt = t2TextField.getText();
        if (t2Txt.equals("")) t2Txt = "<msub><mi>T</mi><mn>2</mn></msub>";
        else t2Txt = "<mi>" + t2Txt + "</mi>";
        String math = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi><mfenced>"
                    + rep +"</mfenced>"
                    + "<mo>=</mo><mfrac><mrow><msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced>" + rep
                    + "</mfenced></mrow><mrow>"
                    + "<mi>G</mi><mfenced>" + rep
                    + "</mfenced></mrow></mfrac>"
                    + "<mo>=</mo><mfrac><mi>"
                    + kTxt + "</mi><mrow>"
                    + "<mfenced><mrow>" + t1Txt 
                    + "<mo>&#x2219</mo>" + rep
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>" + t2Txt 
                    + "<mo>&#x2219</mo>" + rep
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac>"
                    + "</mrow>"
                + "</math>";
        return math;
    }
    
    private void refreshFsView(final ResourceBundle lang) { 
        String content = "<p align=\"center\">"
                + "<font face=\"" + AppStyles.readingFont() + "\">"
                + lang.getString("Test.p3.Fs")
                + "</font></p>"
                + "<p align=\"center\">" + printF("<mi>s</mi>") + ";</p>";
        fsView.getEngine().loadContent(content);
    }
    
    private void refreshFjwView(final ResourceBundle lang, int repNumber) {
        String repl;
        if (repNumber==-1) repl = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>???</mi>";
        else repl = "<mi>" + rep[repNumber] + "</mi>";
        String content = "<p align=\"center\">"
                + "<font face=\"" + AppStyles.readingFont()
                + "\">" + lang.getString("Test.p3.Fjw") + "</font></p>"
                + "<p align=\"center\">" + printF(repl) + ".</p>";
        fjwView.getEngine().loadContent(content);
    }
    
    /** @return интерфейс 3й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg)  {
        try {
            saveData(sg);
            sg.checkPage(2);

            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.saveStud_p2(kTextField.getText(), 
                t1TextField.getText(), 
                t2TextField.getText(), 
                String.valueOf(replChBox.getSelectionModel().getSelectedIndex()));
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        
    }
}
