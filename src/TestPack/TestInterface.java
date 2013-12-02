

package TestPack;

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

/**
 *
 * @author radeon
 */
public class TestInterface {
    /**  Главный layout режима "Тест" */
    private final BorderPane tInterface;
    /** Класс для преверки правильности решения задачи студентом */
    private TestSystemGenerator sg;
    /** Текущий номер страницы режима */
    private int currentPageNumber;
    /** Кнопка перехода к следующему шагу */
    private final Button btnPrevPage;
    /** Кнопка перехода к предыдущему шагу */
    private final Button btnNextPage;
    /** Текущая страница режима */
    private TestPage currentPage;
    /** Кнопка перехода к результатам теста */
    private final Button btnResults;
    private final Label nextStepErrorInfo;
    private ResultPage resPage;
    
    public TestInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        sg = new TestSystemGenerator();
        currentPageNumber = 0;
        currentPage = ConcretePage.returnPage(0, sg, lang);
        resPage = new ResultPage(lang, sg.getTestPU());
        
        tInterface=new BorderPane();
        Label modeTitle = new Label(lang.getString("TestInterface.modeTitle"));
        modeTitle.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.testBtnHint")));
        Label lessonTitle = new Label(lang.getString("TestInterface.lessonTitle"));
        Button btnBack = new Button(lang.getString("TestInterface.btnBackTitle"));
        btnBack.setAlignment(Pos.BOTTOM_LEFT);
        btnBack.setTooltip(new Tooltip(lang.getString("TestInterface.btnBackHint")));
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
                loadNextTestPage(lang);
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
                loadPrevTestPage(lang);
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
                loadResults();
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
        
                
        
        tInterface.setRight(btnNextPage);
        tInterface.setLeft(btnPrevPage);
        tInterface.setTop(topBox); 
        btnPrevPage.setDisable(true);            
        tInterface.setCenter(currentPage.getRootPageLayout());
        tInterface.setBottom(bottomBox);
    }

    /**Загрузить следующую страницу*/
    private void loadNextTestPage(final ResourceBundle lang) {
        // При переходе на следующую страницу производится проверка правильности решения
        if (currentPage.checkPage(sg)) {
        
            if (++currentPageNumber>7) {
              currentPageNumber=8;
              btnResults.setVisible(true);
              btnNextPage.setDisable(true);
            }
            else btnNextPage.setDisable(false);
            
            btnPrevPage.setDisable(false);
            currentPage = ConcretePage.returnPage(currentPageNumber, sg, lang);
            tInterface.setCenter(currentPage.getRootPageLayout());
            nextStepErrorInfo.setVisible(false);
        }
        else nextStepErrorInfo.setVisible(true);
    }
    
    /**Загрузить предыдущую страницу*/
    private void loadPrevTestPage(final ResourceBundle lang) {
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
        currentPage = ConcretePage.returnPage(currentPageNumber, sg, lang);
        tInterface.setCenter(currentPage.getRootPageLayout());
        nextStepErrorInfo.setVisible(false);
    }
    
    /**@return интерфейс режима Тест */
    public BorderPane gettInterface() {
        return tInterface;
    }
    
    /**Загрузить страницу результатов*/
    private void loadResults() {      
        currentPageNumber = 9;
        btnResults.setVisible(false);
        tInterface.setCenter(resPage.getResultPage());
    }
}
