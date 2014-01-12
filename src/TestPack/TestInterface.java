

package TestPack;

import TestPack.TestPages.TestPageInterface;
import DiffModesCommon.AppStyles;
import StartDialogs.FXOptionPane;
import TrainerPack.TrainerControl;
import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author radeon
 */
public class TestInterface {
    /**  Главный layout режима "Тест" */
    protected BorderPane tInterface;
    /** Класс для преверки правильности решения задачи студентом */
    protected TestSystemGenerator sg;
    /** Текущий номер страницы режима */
    protected int currentPageNumber;
    /** Кнопка перехода к следующему шагу */
    protected final Button btnPrevPage;
    /** Кнопка перехода к предыдущему шагу */
    protected final Button btnNextPage;
    /** Текущая страница режима */
    protected TestPageInterface currentPage;
    /** Кнопка перехода к результатам теста */
    protected final Button btnResults;
    protected final Label nextStepErrorInfo;
    protected ResultPage resPage;
    protected final Label modeTitle;
    protected final Label lessonTitle;
    protected final Label currentStepLabel;
    protected final Button watchDemoBtn;
    protected TrainerControl ctrl;
    
    public TestInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        sg = new TestSystemGenerator();
        currentPageNumber = 0;
        resPage = new ResultPage(lang, ifFact);
        ctrl = new TrainerControl();
        
        tInterface=new BorderPane();
        modeTitle = new Label(lang.getString("TestInterface.modeTitle"));
        modeTitle.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.testBtnHint")));
        modeTitle.setStyle(AppStyles.titleFontStyle());
        lessonTitle = new Label(lang.getString("TestInterface.lessonTitle"));
        lessonTitle.setStyle(AppStyles.titleFontStyle() + "-fx-font-size: 24;" 
                + "-fx-text-fill: #" + AppStyles.rightGreenColor() + ";");
        currentStepLabel = new Label();
        currentStepLabel.setText(lang.getString("TestInterface.step")
                + String.valueOf(currentPageNumber+1));
        currentStepLabel.setStyle(AppStyles.titleFontStyle());
        
        
        Button btnBack = new Button(lang.getString("TestInterface.btnBackTitle"));
        btnBack.setAlignment(Pos.BOTTOM_LEFT);
        btnBack.setStyle(AppStyles.readingFontStyle());
            VBox hintVBox = new VBox();
            Label btnBackLbl1 = new Label(lang.getString("TestInterface.btnBackHint"));
            Label btnBackLbl2 = new Label(lang.getString("TestInterface.btnBackHintAttention"));
            btnBackLbl2.setStyle(AppStyles.errorLblStyle());
            Label btnBackLbl3 = new Label(lang.getString("TestInterface.btnBackHintMsg"));
            hintVBox.getChildren().addAll(btnBackLbl1, btnBackLbl2, btnBackLbl3);
            Tooltip btnBackTooltip = new Tooltip();
            btnBackTooltip.setGraphic(hintVBox);
        btnBack.setTooltip(btnBackTooltip);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                String message, title;
                title = lang.getString("TestInterface.btnBackMessageTitle");
                message = lang.getString("TestInterface.btnBackMessage");
                if (FXOptionPane.showConfirmDialog(new Stage(), message, title, lang)==FXOptionPane.Response.YES)
                {   
                    ifFact.loadInitialInterface();
                    clearTestMemory();
                }
            }
        });
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(modeTitle, lessonTitle, currentStepLabel);
        topBox.setPadding(new Insets(5, 5, 5, 5));
        topBox.setSpacing(50);
        
        Image imageRight = new Image(getClass().getResourceAsStream("rightArrow.png"));
        btnNextPage = new Button();
        btnNextPage.setGraphic(new ImageView(imageRight));
        btnNextPage.setTooltip(new Tooltip(lang.getString("TestInterface.navigation.nextStep")));
        btnNextPage.setAlignment(Pos.CENTER);
        btnNextPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                loadNextPage(lang);
                }
        });
                
        Image imageLeft = new Image(getClass().getResourceAsStream("leftArrow.png"));
        btnPrevPage = new Button();
        btnPrevPage.setGraphic(new ImageView(imageLeft));
        btnPrevPage.setTooltip(new Tooltip(lang.getString("TestInterface.navigation.prevStep")));
        btnPrevPage.setAlignment(Pos.CENTER);
        btnPrevPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                loadPrevPage(lang);
                }
        });
        
        btnResults = new Button();
        btnResults.setStyle(AppStyles.readingFontStyle());
        btnResults.setText(lang.getString("TestInterface.navigation.getResults"));
        btnResults.setVisible(false);
        btnResults.setTooltip(new Tooltip(lang.getString("TestInterface.navigation.btnResultsHint")));
        btnResults.setAlignment(Pos.BOTTOM_RIGHT);
        btnResults.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                loadResults(lang, sg.getTestPU());
                }
        });
        
        nextStepErrorInfo = new Label();
        nextStepErrorInfo.setText(lang.getString("TestInterface.nextPageError"));
        nextStepErrorInfo.setAlignment(Pos.CENTER);
        nextStepErrorInfo.setStyle(AppStyles.errorLblStyle() 
                + AppStyles.readingFontStyle());
        nextStepErrorInfo.setVisible(false);
        
        watchDemoBtn = new Button();
        watchDemoBtn.setText(lang.getString("TrainerInterface.watchDemo"));
        watchDemoBtn.setAlignment(Pos.BOTTOM_LEFT);
        watchDemoBtn.setStyle(AppStyles.readingFontStyle());
        watchDemoBtn.setVisible(false);
        
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().addAll(btnBack, watchDemoBtn, nextStepErrorInfo, btnResults);
        bottomBox.setMinWidth(700);
        bottomBox.setSpacing(20);
        bottomBox.setPadding(new Insets(5, 5, 5, 5));
        
        setCurrentPage(lang, 0);
        
        tInterface.setRight(btnNextPage);
        tInterface.setLeft(btnPrevPage);
        tInterface.setTop(topBox); 
        btnPrevPage.setDisable(true);            
        tInterface.setCenter(currentPage.getRootLayout());
        tInterface.setBottom(bottomBox);
    }

    protected void clearTestMemory() {
        tInterface.getChildren().clear();
        tInterface=null;
        sg=null;
        resPage=null;
        ctrl=null;
    }
    
    
    protected void setCurrentPage(final ResourceBundle lang, int pageNumber) {
        currentPage = TestFactory.returnPage(pageNumber, sg, lang);
    }
    
    /**Загрузить следующую страницу*/
    private void loadNextPage(final ResourceBundle lang) {
        // При переходе на следующую страницу производится проверка правильности решения
        if (currentPage.dataCheck(sg, ctrl)) {
        
            if (++currentPageNumber>7) {
              currentPageNumber=8;
              btnResults.setVisible(true);
              btnNextPage.setDisable(true);
            }
            else btnNextPage.setDisable(false);   
            btnPrevPage.setDisable(false);
            setCurrentPage(lang, currentPageNumber);
            tInterface.setCenter(currentPage.getRootLayout());
            nextStepErrorInfo.setVisible(false);
        }
        else nextStepErrorInfo.setVisible(true);
        currentStepLabel.setText(lang.getString("TestInterface.step")
                + String.valueOf(currentPageNumber+1));
    }
    
    /**Загрузить предыдущую страницу*/
    private void loadPrevPage(final ResourceBundle lang) {
        currentPage.saveData(sg);
        if (--currentPageNumber<1) {
            currentPageNumber=0;
            btnPrevPage.setDisable(true);
        }
        else btnPrevPage.setDisable(false);
        
        if (currentPageNumber>7) {
            btnNextPage.setDisable(true);
            btnResults.setVisible(true);
        }
        else {
            btnNextPage.setDisable(false);    
            btnResults.setVisible(false);
        }
        setCurrentPage(lang, currentPageNumber);
        tInterface.setCenter(currentPage.getRootLayout());
        nextStepErrorInfo.setVisible(false);
        currentStepLabel.setText(lang.getString("TestInterface.step")
                + String.valueOf(currentPageNumber+1));
    }
    
    /**@return интерфейс режима Тест */
    public BorderPane gettInterface() {
        return tInterface;
    }
    
    /**Загрузить страницу результатов*/
    private void loadResults(final ResourceBundle lang, final TestPassingUnit testPU) {      
        currentPageNumber = 9;
        currentStepLabel.setText(lang.getString("ResPage.Summary"));
        btnResults.setVisible(false);
        currentPage.dataCheck(sg, ctrl);
        tInterface.setCenter(resPage.getResultPage(lang, testPU));
    }
}
