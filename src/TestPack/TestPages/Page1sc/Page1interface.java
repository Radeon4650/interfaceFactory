package TestPack.TestPages.Page1sc;

import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Fs;
import DiffModesCommon.StructScheme;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page1interface extends TestPageInterface{
    private VBox rootLayout;
    protected GridPane grid;
    protected GridPane coeffGrid;
    protected final TextField kTextField;
    protected final TextField aTextField;
    protected final TextField bTextField;
    protected final TextField cTextField;
    private final Label kLabel;
    private final Label aLabel;
    private final Label bLabel;
    private final Label cLabel;
    protected final WebView transFunc;

    /**Загружает передаточную функцию системы с коеффициентами, введенными 
     * в соответствующие поля в окне*/
    private void loadTransFunc(final ResourceBundle lang) {
        String a, b, c, k;
        if (aTextField.getText().equals(""))
            a = aTextField.getPromptText();
        else a = aTextField.getText();
        
        if (bTextField.getText().equals(""))
            b = bTextField.getPromptText();
        else b = bTextField.getText();
        
        if (cTextField.getText().equals(""))
            c = cTextField.getPromptText();
        else c = cTextField.getText();
        
        if (kTextField.getText().equals(""))
            k = kTextField.getPromptText();
        else k = kTextField.getText();
        
        transFunc.getEngine().loadContent("<html><body><p align=\"center\">"
                + "<font face=\"" + AppStyles.readingFont() + "\">"
                + lang.getString("Test.p1.transFuncTitle")
                + "</font></p><p align=\"center\">"
                + Fs.printInMathMLWith_abc_s(k, a, b, c)
                + ".</p></body></html>"
        );
    }
    
    public Page1interface(TestSystemGenerator sg, final ResourceBundle lang) {
        grid = new GridPane();
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width = \"100%\"><tr><td align = \"center\">"
                + "<p><font face=\"" + AppStyles.readingFont() + "\">"
                + lang.getString("Test.p1.structSheme")
                + "</font></p>"
                + StructScheme.getStructScheme(lang)
                + "</td><td width = \"33%\"><p>"
                + "<font face=\"" + AppStyles.readingFont() + "\">"
                + lang.getString("Test.p1.sourceData")
                + "</font></p>"
                + sg.getWk1().printInMathML()+";\t"+ sg.getWk5().printInMathML()
                + ";<br>"
                + sg.getWk2().printInMathML()+";\t"+ sg.getWk6().printInMathML()
                + ";<br>"
                + sg.getWd3().printInMathML()
                + ";<br>"
                + sg.getWd4().printInMathML()
                + ".</td></tr></table></body></html>"
        );
        grid.add(wv, 0, 0, 2, 1);
        
        transFunc = new WebView();  
        transFunc.setMaxHeight(120);
        grid.add(transFunc, 0, 1);
        
        coeffGrid = new GridPane();
        kLabel = new Label("k =");
        aLabel = new Label("a =");
        bLabel = new Label("b =");
        cLabel = new Label("c =");
        Label coeffLabel = new Label(lang.getString("Test.p1.transFuncGetting"));
        coeffLabel.setAlignment(Pos.CENTER);
        coeffLabel.setWrapText(true);
        kLabel.setStyle(AppStyles.originalFontStyle());
        aLabel.setStyle(AppStyles.originalFontStyle());
        bLabel.setStyle(AppStyles.originalFontStyle());
        cLabel.setStyle(AppStyles.originalFontStyle());
        coeffLabel.setStyle(AppStyles.originalFontStyle());
        
        
        // сделать цвет шрифта красным или серым для всех:
        kTextField = new TextField();
        aTextField = new TextField();
        bTextField = new TextField();
        cTextField = new TextField();
        
          // Заполняем поля ввода числами, введенными ранее
          // Если ранее числа введены не были (их значения равны нулю),
          // оставляем поля ввода пустыми.
        { String [] data = sg.getPageData(0);
          kTextField.setText(data[0]);
          aTextField.setText(data[1]);
          bTextField.setText(data[2]);
          cTextField.setText(data[3]); }

        kTextField.setPromptText("k");
        aTextField.setPromptText("a");
        bTextField.setPromptText("b");
        cTextField.setPromptText("c");
        
        kTextField.setStyle(AppStyles.originalFontStyle());
        aTextField.setStyle(AppStyles.originalFontStyle());
        bTextField.setStyle(AppStyles.originalFontStyle());
        cTextField.setStyle(AppStyles.originalFontStyle());
        
        coeffGrid.add(coeffLabel, 0, 0, 2, 1);
        coeffGrid.add(kLabel, 0, 1);
        coeffGrid.add(aLabel, 0, 2);
        coeffGrid.add(bLabel, 0, 3);
        coeffGrid.add(cLabel, 0, 4);
        coeffGrid.add(kTextField, 1, 1);
        coeffGrid.add(aTextField, 1, 2);
        coeffGrid.add(bTextField, 1, 3);
        coeffGrid.add(cTextField, 1, 4);
        
        
        kTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(kTextField);
                loadTransFunc(lang);
                }
        });
        
        aTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(aTextField);
                loadTransFunc(lang);
            }
        });
        
        bTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(bTextField);
                loadTransFunc(lang);
                }
        });
        
        cTextField.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(cTextField);
                loadTransFunc(lang);
                }
        });    
        
        loadTransFunc(lang);
        
        grid.add(coeffGrid, 1, 1);
        RowConstraints grid_rc0 = new RowConstraints();
        RowConstraints grid_rc1 = new RowConstraints();
        grid_rc0.setPercentHeight(60);
        grid_rc1.setPercentHeight(40);
        grid_rc1.setValignment(VPos.CENTER);
        grid.getRowConstraints().addAll(grid_rc0, grid_rc1);
        
//        grid.setGridLinesVisible(true);
        ColumnConstraints grid_col1 = new ColumnConstraints();
        ColumnConstraints grid_col2 = new ColumnConstraints();
        grid_col1.setPercentWidth(60);
        grid_col2.setPercentWidth(40);
        grid.getColumnConstraints().addAll(grid_col1, grid_col2);
        
        ColumnConstraints coeffGrid_col1 = new ColumnConstraints();
        ColumnConstraints coeffGrid_col2 = new ColumnConstraints();
        coeffGrid_col1.setPercentWidth(15);
        coeffGrid_col1.setHalignment(HPos.RIGHT);
        coeffGrid_col2.setPercentWidth(85);
        coeffGrid.getColumnConstraints().addAll(coeffGrid_col1, coeffGrid_col2);
        
        rootLayout.getChildren().add(grid);  
    }
    
    /** @return интерфейс 1й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        if (kTextField.getText().equals("")) return false;
        if (aTextField.getText().equals("")) return false;
        if (bTextField.getText().equals("")) return false;
        if (cTextField.getText().equals("")) return false;
        
        saveData(sg);
        sg.checkPage(0);
        return true;
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.setStudentsFs_p0(kTextField.getText(), aTextField.getText(), bTextField.getText(), cTextField.getText());
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        
    }
}
