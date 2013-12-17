

package TestPack;

import TestPack.TestPages.TestPageInterface;
import DiffModesCommon.AppStyles;
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

/**
 *
 * @author radeon
 */
public class TestInterface {
    /**  Главный layout режима "Тест" */
    protected final BorderPane tInterface;
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
    
    public TestInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        sg = new TestSystemGenerator();
        currentPageNumber = 0;
        resPage = new ResultPage(lang, ifFact);
        
        tInterface=new BorderPane();
        modeTitle = new Label(lang.getString("TestInterface.modeTitle"));
        modeTitle.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.testBtnHint")));
        lessonTitle = new Label(lang.getString("TestInterface.lessonTitle"));
        Button btnBack = new Button(lang.getString("TestInterface.btnBackTitle"));
        btnBack.setAlignment(Pos.BOTTOM_LEFT);
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
                ifFact.loadInitialInterface();
            }
        });
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(modeTitle, lessonTitle);
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
        nextStepErrorInfo.setStyle(AppStyles.errorLblStyle());
        nextStepErrorInfo.setVisible(false);
        
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().addAll(btnBack, nextStepErrorInfo, btnResults);
        bottomBox.setMinWidth(700);
        bottomBox.setSpacing(100);
        bottomBox.setPadding(new Insets(5, 5, 5, 5));
        
        this.setCurrentPage(lang, 0);
        
        tInterface.setRight(btnNextPage);
        tInterface.setLeft(btnPrevPage);
        tInterface.setTop(topBox); 
        btnPrevPage.setDisable(true);            
        tInterface.setCenter(currentPage.getRootLayout());
        tInterface.setBottom(bottomBox);
    }

    protected void setCurrentPage(final ResourceBundle lang, int pageNumber) {
        currentPage = TestFactory.returnPage(pageNumber, sg, lang);
    }
    
    /**Загрузить следующую страницу*/
    private void loadNextPage(final ResourceBundle lang) {
        // При переходе на следующую страницу производится проверка правильности решения
        if (currentPage.dataCheck(sg)) {
        
            if (++currentPageNumber>7) {
              currentPageNumber=8;
              btnResults.setVisible(true);
              btnNextPage.setDisable(true);
            }
            else btnNextPage.setDisable(false);
            
            btnPrevPage.setDisable(false);
            this.setCurrentPage(lang, currentPageNumber);
            tInterface.setCenter(currentPage.getRootLayout());
            nextStepErrorInfo.setVisible(false);
        }
        else nextStepErrorInfo.setVisible(true);
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
        this.setCurrentPage(lang, currentPageNumber);
        tInterface.setCenter(currentPage.getRootLayout());
        nextStepErrorInfo.setVisible(false);
    }
    
    /**@return интерфейс режима Тест */
    public BorderPane gettInterface() {
        return tInterface;
    }
    
    /**Загрузить страницу результатов*/
    private void loadResults(final ResourceBundle lang, final TestPassingUnit testPU) {      
        currentPageNumber = 9;
        btnResults.setVisible(false);
        currentPage.dataCheck(sg);
        tInterface.setCenter(resPage.getResultPage(lang, testPU));
    }
}
