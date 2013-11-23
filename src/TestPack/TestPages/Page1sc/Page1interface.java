package TestPack.TestPages.Page1sc;

import DiffModesCommon.DataModel.Fs;
import DiffModesCommon.StructScheme;
import TestPack.TestSystemGenerator;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page1interface {
    private Label infoLab1;
    private VBox rootLayout;
    private GridPane grid;
    private final TextField kTextField;
    private final TextField aTextField;
    private final TextField bTextField;
    private final TextField cTextField;
    private final Label kLabel;
    private final Label aLabel;
    private final Label bLabel;
    private final Label cLabel;
    final WebView transFunc;

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
        
        transFunc.getEngine().loadContent("<html><body><b><p align=\"center\">"
                + lang.getString("Test.p1.transFuncTitle")
                + "</p></b><p align=\"center\">"
                + Fs.printInMathMLWith_abc_s(k, a, b, c)
                + ".</p></body></html>"
        );
    }
    
    /**Устанавливает стиль для поля ввода коэффициентов:
     * символы становятся красными, если введеноое значение не является числом*/
    private void styleSetter (final TextField tf) {
        final String wrongTextInputStyle;
        final String rightTextInputStyle;
        wrongTextInputStyle = "-fx-text-fill: #FF0066;"
                            + "-fx-prompt-text-fill: #99CC99;"
                            + "-fx-highlight-fill: #CC3300;";
        rightTextInputStyle = "-fx-text-fill: #000000;"
                            + "-fx-prompt-text-fill: #99CC99;"
                            + "-fx-highlight-fill: #009966;";
        try {
            Double.parseDouble(tf.getText());
            tf.setStyle(rightTextInputStyle);
            }
        catch (NumberFormatException ex) {
            tf.setStyle(wrongTextInputStyle);
        }
    }
    
    public Page1interface(TestSystemGenerator sg, final ResourceBundle lang) {
        infoLab1 = new Label();
        grid = new GridPane();
        infoLab1.setText("Test mode page 1");
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width = \"100%\"><tr><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Test.p1.structSheme")
                + "</b></p>"
                + StructScheme.getStructScheme()
                + "</td><td width = \"33%\"><p><b>"
                + lang.getString("Test.p1.sourceData")
                + "</b></p>"
                + sg.getWk1().printInMathML()+";\t"+ sg.getWk5().printInMathML()
                + ";<br>"
                + sg.getWk2().printInMathML()+";\t"+ sg.getWk6().printInMathML()
                + ";<br>"
                + sg.getWd3().printInMathML()
                + ";<br>"
                + sg.getWd4().printInMathML()
                + ".</td></tr></table></body></html>");
        grid.add(wv, 0, 0, 2, 1);
        
        transFunc = new WebView();    
        grid.add(transFunc, 0, 1);
        
        GridPane coeffGrid = new GridPane();
        coeffGrid.setGridLinesVisible(true);
        kLabel = new Label("k =");
        aLabel = new Label("a =");
        bLabel = new Label("b =");
        cLabel = new Label("c =");
        Label coeffLabel = new Label(lang.getString("Test.p1.transFuncGetting"));
        coeffLabel.setAlignment(Pos.CENTER);
        coeffLabel.setWrapText(true);
        
        
        // сделать цвет шрифта красным или серым для всех:
        kTextField = new TextField();
        aTextField = new TextField();
        bTextField = new TextField();
        cTextField = new TextField();

        kTextField.setPromptText("k");
        aTextField.setPromptText("a");
        bTextField.setPromptText("b");
        cTextField.setPromptText("c");
        
        coeffGrid.add(coeffLabel, 0, 0, 3, 1);
        coeffGrid.add(kLabel, 0, 1);
        coeffGrid.add(aLabel, 0, 2);
        coeffGrid.add(bLabel, 0, 3);
        coeffGrid.add(cLabel, 0, 4);
        coeffGrid.add(kTextField, 1, 1);
        coeffGrid.add(aTextField, 1, 2);
        coeffGrid.add(bTextField, 1, 3);
        coeffGrid.add(cTextField, 1, 4);
        
        
        kTextField.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent> () {
            @Override
            public void handle(InputMethodEvent t) {
                styleSetter(kTextField);
                loadTransFunc(lang);
                }
        });
        
        aTextField.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent> () {
            @Override
            public void handle(InputMethodEvent t) {
                styleSetter(aTextField);
                loadTransFunc(lang);
            }
        });
        
        bTextField.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent> () {
            @Override
            public void handle(InputMethodEvent t) {
                styleSetter(bTextField);
                loadTransFunc(lang);
                }
        });
        
        cTextField.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent> () {
            @Override
            public void handle(InputMethodEvent t) {
                styleSetter(cTextField);
                loadTransFunc(lang);
                }
        });    
        
        loadTransFunc(lang);
        
        grid.add(coeffGrid, 1, 1);
        
        grid.setGridLinesVisible(true);
        ColumnConstraints grid_col1 = new ColumnConstraints();
        ColumnConstraints grid_col2 = new ColumnConstraints();
        grid_col1.setPercentWidth(70);
        grid_col2.setPercentWidth(30);
        grid.getColumnConstraints().addAll(grid_col1, grid_col2);
        
        ColumnConstraints coeffGrid_col1 = new ColumnConstraints();
        ColumnConstraints coeffGrid_col2 = new ColumnConstraints();
        ColumnConstraints coeffGrid_col3 = new ColumnConstraints();
        coeffGrid_col1.setPercentWidth(15);
        coeffGrid_col1.setHalignment(HPos.RIGHT);
        coeffGrid_col2.setPercentWidth(40);
        coeffGrid_col3.setPercentWidth(45);
        coeffGrid.getColumnConstraints().addAll(coeffGrid_col1, coeffGrid_col2, coeffGrid_col3);
        
        rootLayout.getChildren().add(grid);  
    }
    
    /** @return интерфейс 1й страницы режима Тест  */
    public VBox getRootLayout() {
        return rootLayout;
    }
    
    
}
