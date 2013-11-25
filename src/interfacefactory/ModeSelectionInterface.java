package interfacefactory;

import DiffModesCommon.DataModel.Wd;
import DiffModesCommon.DataModel.Wk;
import DiffModesCommon.StructScheme;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class ModeSelectionInterface {
    /**@param msInterface интерфейс выбора режимов*/
    private final VBox msInterface;
    private final Label pageTitle;
    
    final TextField k1tf;
    final TextField k2tf;
    final TextField k3tf;
    final TextField t13tf;
    final TextField t23tf;
    final TextField t14tf;
    final TextField t24tf;
    final TextField k4tf;
    final TextField k5tf;
    final TextField k6tf;
    
    final CheckBox problemSituationChBox;
    final Label errLbl;
    
    public ModeSelectionInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        // Поля для ввода коэффициентов системы
        k1tf = new TextField();
        k2tf = new TextField();
        k3tf = new TextField();
        t13tf = new TextField();
        t23tf = new TextField();
        t14tf = new TextField();
        t24tf = new TextField();
        k4tf = new TextField();
        k5tf = new TextField();
        k6tf = new TextField();
        problemSituationChBox = new CheckBox();
        errLbl = new Label();
        
        
        TabPane modeTabPane = new TabPane();
            Tab tabDemo = new Tab();
            tabDemo.setText(lang.getString("ModeSelectionInterface.demoBtnTitle"));
            Tab tabTrainer = new Tab();
            tabTrainer.setText(lang.getString("ModeSelectionInterface.trainerBtnTitle"));
            Tab tabTest = new Tab();
            tabTest.setText(lang.getString("ModeSelectionInterface.testBtnTitle"));
        
            tabDemo.setContent(demoTabContent(lang, ifFact));
            tabTrainer.setContent(trainerTabContent(lang, ifFact));
            tabTest.setContent(testTabContent(lang, ifFact));
            
        modeTabPane.getTabs().addAll(tabDemo, tabTrainer, tabTest);
        modeTabPane.setSide(Side.TOP);
        modeTabPane.setTabMinWidth(200);
        modeTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        modeTabPane.setPrefSize(1000, 1000);
       
   
        pageTitle = new Label(lang.getString("ModeSelectionInterface.pageTitle"));
        
        msInterface = new VBox();
        msInterface.setAlignment(Pos.CENTER);
        msInterface.getChildren().add(pageTitle);
        msInterface.getChildren().add(modeTabPane);
    }
    
    /**@return содержимое вкладки перехода к Демо-режиму*/
    private Node demoTabContent(final ResourceBundle lang, final InterfaceFactory ifFact) {
        VBox layout = new VBox();
        
        Button btnDemo = new Button(lang.getString("ModeSelectionInterface.demoBtnTitle")+ " >");
        btnDemo.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.demoBtnHint")));
        

        Image demoImg = new Image(getClass().getResourceAsStream("demo_preview.jpg"), 400, 300, false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(demoImg);
        
        Label infoLab = new Label(lang.getString("ModeSelectionInterface.demoPreview"));
        infoLab.wrapTextProperty().setValue(Boolean.TRUE);
        infoLab.setPrefWidth(600);
        
        final TitledPane settingsPane = new TitledPane();
        settingsPane.setText(lang.getString("ModeSelectionInterface.settingsPaneTitle"));
        settingsPane.setExpanded(false);
        settingsPane.setPrefWidth(600);
        settingsPane.setContent(demoTabAdditionalContent(lang));
        
        TitledPane mainPane = new TitledPane(lang.getString("ModeSelectionInterface.demoMainPaneTitle"), layout);
        mainPane.setExpanded(true);
        
        final Accordion accordion = new Accordion ();
        accordion.getPanes().addAll(mainPane, settingsPane);
        accordion.setExpandedPane(mainPane);
        
        layout.getChildren().addAll(imageView, infoLab, btnDemo);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        
        
        errLbl.setText(lang.getString("ModeSelectionInterface.demoError"));
        errLbl.setStyle("-fx-text-fill: #FF0066;"
                + "-fx-wrap-text: true;"
                + "-fx-text-alignment: center;");
        errLbl.setPrefWidth(600);
        errLbl.setVisible(false);
        layout.getChildren().add(errLbl);
        
        btnDemo.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if (problemSituationChBox.isSelected())
                try {
                    // Пробуем парсить введенные данные в соответствующих полях ввода
                    // Если введенные данные являются числом, проверяем их на вхождение в указанные пределы
                    double k1, k2, k3, k4, k5, k6;
                    double t13, t23, t14, t24;
                    NumberFormatException nfe = new NumberFormatException();
                    k1 = Double.parseDouble(k1tf.getText());
                    if ((k1 > 5) || (k1 < 0.5))
                            throw nfe;
                    
                    k2 = Double.parseDouble(k2tf.getText());
                    if ((k2 > 5) || (k2 < 1.5))
                            throw nfe;
                    
                    k3 = Double.parseDouble(k3tf.getText());
                    if ((k3 > 11) || (k3 < 7.5))
                            throw nfe;
                    
                    k4 = Double.parseDouble(k4tf.getText());
                    if ((k4 > -0.001) || (k4 < -1))
                            throw nfe;
                    
                    k5 = Double.parseDouble(k5tf.getText());
                    if ((k5 > 0.1) || (k5 <= 0.05))
                            throw nfe;
                    
                    k6 = Double.parseDouble(k6tf.getText());
                    if ((k6 > 2.5) || (k6 < 0.5))
                            throw nfe;
                    
                    t13 = Double.parseDouble(t13tf.getText());
                    if ((t13 > 1) || (t13 <= 0))
                            throw nfe;
                    
                    t23 = Double.parseDouble(t23tf.getText());
                    if ((t23 > 0.05) || (t23 <= 0.001))
                            throw nfe;
                    
                    t14 = Double.parseDouble(t14tf.getText());
                    if ((t14 > 1) || (t14 <= 0))
                            throw nfe;
                    
                    t24 = Double.parseDouble(t24tf.getText());
                    if ((t24 > 0.05) || (t24 <= 0.001))
                            throw nfe;
                    
                    // Если все данные прошли проверку, можем создавать систему
                    Wk wk1, wk2, wk5, wk6;
                    Wd wd3, wd4;
                    wk1 = new Wk(k1, "E", "Y", 0, 1, 1);
                    wk2 = new Wk(k2, "Y", "Y", 1, 2, 2);
                    wd3 = new Wd(k3, t13, t23, "Y", "Y", 2, 3, 3);
                    wd4 = new Wd(k4, t14, t24, "F", "Y", 0, 4, 4);
                    wk5 = new Wk(k5, "Y", "Y", 0, 5, 5);
                    wk6 = new Wk(k6, "Y", "Y", 5, 6, 6); 
                    
                    System.out.println("Создаю задачу с пользовательскими данными");
                    ifFact.loadDemoInterface(wk1, wk2, wd3, wd4, wk5, wk6);
                }
                catch (NumberFormatException ex) {
                    // Оповещаем пользователя о том, что его данные не прошли проверку
                    // и необходимо внесение изменений
                    System.out.println("Ошибка ввода пользовательских данных");
                    errLbl.setVisible(true);
                }  
                else {
                    errLbl.setVisible(false);
                    System.out.println("Создаю задачу автоматически");
                    ifFact.loadDemoInterface();
                }
            }
        });
        
        return accordion;
    }
    
    /**@return содержимое дополнительной вкладки в Демо-режиме*/
    private Node demoTabAdditionalContent(final ResourceBundle lang) {
        final GridPane grid = new GridPane();
//        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setPrefSize(800, 600);
//        grid.setMinWidth(700);
        
        final Label addPaneInfoLabel = new Label(lang.getString("ModeSelectionInterface.settingsPaneInfo"));
        addPaneInfoLabel.setWrapText(true);
        addPaneInfoLabel.setAlignment(Pos.CENTER);
        grid.add(addPaneInfoLabel, 0, 0, 2, 1);
        
        
        problemSituationChBox.setText(lang.getString("ModeSelectionInterface.settingsPaneProblemSituation"));
        problemSituationChBox.setSelected(false);
        grid.add(problemSituationChBox, 0, 1, 2, 1);
        
        final WebView structSchemeView = new WebView();
        structSchemeView.setContextMenuEnabled(false);
        structSchemeView.getEngine().loadContent("<html><body>"
                + "<table width=\"100%\"><tr><td colspan=\"4\" align=\"center\"><b>"
                + lang.getString("ModeSelectionInterface.settingsPaneStructScheme")
                + "</b></td></tr><tr><td colspan=\"4\" align=\"justify\">"
                + StructScheme.getStructScheme(lang)
                + "</td></tr><tr><td width=\"40%\">"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>W</mi><mn>1</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>1</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow><mi>E</mi>"  
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<msub><mi>k</mi><mn>1</mn></msub></mrow>"
                + "</math>"
                + " ,</td></tr><tr><td>"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>W</mi><mn>2</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>2</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<msub><mi>Y</mi><mn>1</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<msub><mi>k</mi><mn>2</mn></msub></mrow>"
                + "</math>"
                + " ,</td></tr><tr><td>"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>W</mi><mn>3</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>3</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<msub><mi>Y</mi><mn>2</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo><mfrac>"
                    + "<msub><mi>k</mi><mn>3</mn></msub><mrow>"
                    + "<mfenced><mrow><msub><mi>T</mi><mn>13</mn></msub>"
                    + "<mi>s</mi><mo>+</mo><mn>1</mn></mrow></mfenced>"
                    + "<mfenced><mrow><msub><mi>T</mi><mn>23</mn></msub>"
                    + "<mi>s</mi><mo>+</mo><mn>1</mn></mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>"
                + " ,</td></tr><tr><td>"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>W</mi><mn>4</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>4</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow><mi>F</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo><mfrac>"
                    + "<msub><mi>k</mi><mn>4</mn></msub><mrow>"
                    + "<mfenced><mrow><msub><mi>T</mi><mn>14</mn></msub>"
                    + "<mi>s</mi><mo>+</mo><mn>1</mn></mrow></mfenced>"
                    + "<mfenced><mrow><msub><mi>T</mi><mn>24</mn></msub>"
                    + "<mi>s</mi><mo>+</mo><mn>1</mn></mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>" 
                + " ,</td></tr><tr><td>"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>W</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow><mi>Y</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<msub><mi>k</mi><mn>5</mn></msub></mrow>"
                + "</math>"
                + " ,</td></tr><tr><td>"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>W</mi><mn>6</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>6</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<msub><mi>k</mi><mn>6</mn></msub></mrow>"
                + "</math>"
                + " .</td></tr></table></body></html>");
        
        
        
        // Обозначения полей ввода
        Label k1lab = new Label("k1 = ");
        Label k2lab = new Label("k2 = ");
        Label k3lab = new Label("k3 = ");
        Label k4lab = new Label("k4 = ");
        Label k5lab = new Label("k5 = ");
        Label k6lab = new Label("k6 = ");
        Label t13lab = new Label("T 13 = ");
        Label t23lab = new Label("T 23 = ");
        Label t14lab = new Label("T 14 = ");
        Label t24lab = new Label("T 24 = ");  
        
        Label necessaryCoeff = new Label(lang.getString("ModeSelectionInterface.settingsPaneInpCoeff"));
        necessaryCoeff.setAlignment(Pos.CENTER);
        necessaryCoeff.setWrapText(true);
        
        
        
        // Подсказки для полей ввода коэффициентов системы
        k1tf.setPromptText("k1 ∈ [1 ; 4]");
        k2tf.setPromptText("k2 ∈ [2.5 ; 4.5]");
        k3tf.setPromptText("k3 ∈ [8.5 ; 10]");
        k4tf.setPromptText("k4 ∈ [-0.0085 ; -0.01]");
        k5tf.setPromptText("k5 ∈ [0.07 ; 0.08]");
        k6tf.setPromptText("k6 ∈ [1 ; 1.5]");
        t13tf.setPromptText("T 13 ∈ [0.2 ; 0.3]");
        t23tf.setPromptText("T 23 ∈ [0.002 ; 0.003]");
        t14tf.setPromptText("T 14 ∈ [0.2 ; 0.3]");
        t24tf.setPromptText("T 24 ∈ [0.002 ; 0.003]");
        
        k1tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nk1 ∈ [1 ; 4]"));
        k2tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nk2 ∈ [2.5 ; 4.5]"));
        k3tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nk3 ∈ [8.5 ; 10]"));
        k4tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nk4 ∈ [-0.0085 ; -0.01]"));
        k5tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nk5 ∈ [0.07 ; 0.08]"));
        k6tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nk6 ∈ [1 ; 1.5]"));
        t13tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nT 13 ∈ [0.2 ; 0.3]"));
        t23tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nT 23 ∈ [0.002 ; 0.003]"));
        t14tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nT 14 ∈ [0.2 ; 0.3]"));
        t24tf.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.recomendedLimits") +"\nT 24 ∈ [0.002 ; 0.003]"));
        
        
        final GridPane inputPane = new GridPane();
        inputPane.setAlignment(Pos.TOP_LEFT);
        inputPane.add(necessaryCoeff, 0, 0, 5, 1);
        inputPane.add(k1lab, 0, 1);
        inputPane.add(k2lab, 0, 2);
        inputPane.add(k3lab, 0, 3);
        inputPane.add(k4lab, 0, 4);
        inputPane.add(k5lab, 0, 5);
        inputPane.add(k6lab, 0, 6);
            inputPane.add(t13lab, 2, 3);
            inputPane.add(t23lab, 4, 3);
            inputPane.add(t14lab, 2, 4);
            inputPane.add(t24lab, 4, 4);
        inputPane.add(k1tf, 1, 1);
        inputPane.add(k2tf, 1, 2);
        inputPane.add(k3tf, 1, 3);
        inputPane.add(k4tf, 1, 4);
        inputPane.add(k5tf, 1, 5);
        inputPane.add(k6tf, 1, 6);
            inputPane.add(t13tf, 3, 3);
            inputPane.add(t23tf, 5, 3);
            inputPane.add(t14tf, 3, 4);
            inputPane.add(t24tf, 5, 4);
        
        //Ограничения колонок таблицы для ввода коэффициентов
        final ColumnConstraints inpPaneCol0 = new ColumnConstraints();
        final ColumnConstraints inpPaneCol1 = new ColumnConstraints();
        final ColumnConstraints inpPaneCol2 = new ColumnConstraints();
        final ColumnConstraints inpPaneCol3 = new ColumnConstraints();
        final ColumnConstraints inpPaneCol4 = new ColumnConstraints();
        final ColumnConstraints inpPaneCol5 = new ColumnConstraints();
        
        inpPaneCol0.setPercentWidth(10);
        inpPaneCol1.setPercentWidth(20);   
        inpPaneCol2.setPercentWidth(10);
        inpPaneCol3.setPercentWidth(20); 
        inpPaneCol4.setPercentWidth(10);
        inpPaneCol5.setPercentWidth(20); 
        
        inpPaneCol0.setHalignment(HPos.RIGHT);
        inpPaneCol1.setHalignment(HPos.LEFT);
        inpPaneCol2.setHalignment(HPos.RIGHT);
        inpPaneCol3.setHalignment(HPos.LEFT);
        inpPaneCol4.setHalignment(HPos.RIGHT);
        inpPaneCol5.setHalignment(HPos.LEFT);
        
        inputPane.getColumnConstraints().addAll(inpPaneCol0, inpPaneCol1, 
                inpPaneCol2, inpPaneCol3, inpPaneCol4, inpPaneCol5);
            
        //  Создаем ограничения для колонок основной таблицы
        ColumnConstraints gridCol0 = new ColumnConstraints();
        ColumnConstraints gridCol1 = new ColumnConstraints();
        
        // Задаем ширину колонок таблицы в процентах
        gridCol0.setPercentWidth(40);
        gridCol1.setPercentWidth(60);
        
        //  Создаем ограничения для строк основной таблицы
        RowConstraints gridRow0 = new RowConstraints();
        RowConstraints gridRow1 = new RowConstraints();
        RowConstraints gridRow2 = new RowConstraints();
        RowConstraints gridRow3 = new RowConstraints();
        
        gridRow0.setValignment(VPos.TOP);
        gridRow1.setValignment(VPos.TOP);
        gridRow2.setValignment(VPos.CENTER);
        gridRow3.setValignment(VPos.BOTTOM);
        
        gridRow2.setPercentHeight(70);
        
        // Добавляем ограничения в таблицу:
        grid.getColumnConstraints().addAll(gridCol0, gridCol1);
        grid.getRowConstraints().addAll(gridRow0, gridRow1, gridRow2, gridRow3);

        

        

        
        

        
        problemSituationChBox.setOnMouseClicked(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent t) {
                errLbl.setVisible(false);
                grid.getChildren().clear();
                grid.add(addPaneInfoLabel, 0, 0, 2, 1);
                grid.add(problemSituationChBox, 0, 1, 2, 1);
                
                if (problemSituationChBox.isSelected())
                {
                    //Добавляем структурную схему
                    grid.add(structSchemeView, 0, 2, 2, 2);
                    //Добавляем поля ввода коэффициентов
                    grid.add(inputPane, 1, 3);
                }
            }          
        });
        
        
        
        
        
        return grid;
    }
    
    /**@return содержимое вкладки перехода к режиму "Тренер"*/
    private Node trainerTabContent(final ResourceBundle lang, final InterfaceFactory ifFact) {
        VBox layout = new VBox();
        
        Label infoLab = new Label(lang.getString("ModeSelectionInterface.trainerPreview"));
        infoLab.wrapTextProperty().setValue(Boolean.TRUE);
        infoLab.setPrefWidth(600);
        
        Button btnTrainer = new Button(lang.getString("ModeSelectionInterface.trainerBtnTitle")+ " >");
        btnTrainer.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.trainerBtnHint")));
        btnTrainer.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadTrainerInterface();
            }
        });
        
        Image trainerImg = new Image(getClass().getResourceAsStream("trainer_preview.jpg"), 400, 300, false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(trainerImg);
        
        layout.getChildren().addAll(imageView, infoLab, btnTrainer);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        return layout;
    }
    
    /**@return содержимое вкладки перехода к тестовому режиму*/
    private Node testTabContent(final ResourceBundle lang, final InterfaceFactory ifFact) {
        VBox layout = new VBox();
        
        Label infoLab = new Label(lang.getString("ModeSelectionInterface.testPreview"));
        infoLab.wrapTextProperty().setValue(Boolean.TRUE);
        infoLab.setPrefWidth(600);
        
        Button btnTest = new Button(lang.getString("ModeSelectionInterface.testBtnTitle")+ " >");
        btnTest.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.testBtnHint")));
        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                ifFact.loadTestInterface();
            }
        });
              
        Image testImg = new Image(getClass().getResourceAsStream("test_preview.jpg"), 400, 300, false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(testImg);
        
        layout.getChildren().addAll(imageView, infoLab, btnTest);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        return layout;
    }
    
    
    /**@return Интерфейс выбора режимов*/
    public VBox getMsInterface() {
        return msInterface;
    }
 
}
