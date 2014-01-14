

package TestPack;

import DiffModesCommon.AppStyles;
import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class ResultPage {
    private final VBox rootLayout;
    private final WebView detailsView;
    private final TitledPane detailsPane;
    private final Label score;
    private final VBox detailBox;
    private final Label chartTitle;
    private final Label recomendTitle;
    private final Label recomendDetails;
    
    public ResultPage(final ResourceBundle lang, final InterfaceFactory ifFact) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setSpacing(10);
        
        Button btnTestAgain = new Button(lang.getString("ResPage.btnTestAgain"));
        btnTestAgain.setStyle(AppStyles.originalFontStyle());
        btnTestAgain.setTooltip(new Tooltip(lang.getString("ResPage.btnTestAgainHint")));
        btnTestAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                // Пересоздать тестовую страницу и начать тест заново.
                ifFact.loadTestInterface();
            }
        });
        Label pageTitle = new Label(lang.getString("ResPage.title"));
        pageTitle.setStyle(AppStyles.titleFontStyle());
        score = new Label();
        score.setStyle(AppStyles.originalFontStyle());
        
        chartTitle = new Label(lang.getString("ResPage.bayesianChartTitle"));
        chartTitle.setStyle(AppStyles.readingFontStyle());
        chartTitle.setWrapText(true);
        chartTitle.setTextAlignment(TextAlignment.CENTER);
        recomendTitle = new Label(lang.getString("ResPage.recomendTitle"));
        recomendTitle.setStyle(AppStyles.readingFontStyle());
        recomendTitle.setWrapText(true);
        recomendTitle.setTextAlignment(TextAlignment.CENTER);
        recomendDetails = new Label();
        recomendDetails.setStyle(AppStyles.originalFontStyle());
        recomendDetails.setWrapText(true);
  
        detailBox = new VBox();
        detailBox.setAlignment(Pos.CENTER);
        detailBox.setSpacing(10);
        detailBox.setStyle(AppStyles.mainStageRootStyle());
        ScrollPane sp = new ScrollPane();
        sp.setContent(detailBox);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setFitToWidth(true);
        sp.setPrefHeight(1000);
        
        detailsView = new WebView();
        detailsView.setPrefHeight(1100);
        
        detailsPane = new TitledPane();
        detailsPane.setText(lang.getString("ResPage.details"));
        detailsPane.setContent(sp);
        detailsPane.setExpanded(false);
        detailsPane.setStyle(AppStyles.originalFontStyle());
        
        rootLayout.getChildren().addAll(pageTitle, score, detailsPane, 
                btnTestAgain);      
    }
    
    private void refreshResults(final ResourceBundle lang, final TestPassingUnit testPU, final Node chart, String recDet) {
        detailBox.getChildren().clear();
        detailsView.getEngine().loadContent(testPU.checkResults(lang));
        score.setText(lang.getString("ResPage.points")+String.valueOf(testPU.getScore()));
        recomendDetails.setText(recDet);
        detailBox.getChildren().add(detailsView);
        detailBox.getChildren().add(chartTitle);
        detailBox.getChildren().add(chart);
        detailBox.getChildren().add(recomendTitle);
        detailBox.getChildren().add(recomendDetails);
    }
    
    public Node getResultPage(final ResourceBundle lang, final TestPassingUnit testPU, 
            final Node chart, String recDet) {
        refreshResults(lang, testPU, chart, recDet);
        return rootLayout;
    }
}
