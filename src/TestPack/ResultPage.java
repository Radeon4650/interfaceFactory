

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
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class ResultPage {
    private VBox rootLayout;
    private WebView detailsView;
    private TitledPane detailsPane;
    private Label score;
    
    public ResultPage(final ResourceBundle lang, final InterfaceFactory ifFact) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setSpacing(10);
        
        Button btnTestAgain = new Button(lang.getString("ResPage.btnTestAgain"));
        btnTestAgain.setTooltip(new Tooltip(lang.getString("ResPage.btnTestAgainHint")));
        btnTestAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                // Пересоздать тестовую страницу и начать тест заново.
                ifFact.loadTestInterface();
            }
        });
        Label pageTitle = new Label(lang.getString("ResPage.title"));
        score = new Label();
        detailsView = new WebView();
        
        detailsPane = new TitledPane();
        detailsPane.setText(lang.getString("ResPage.details"));
        detailsPane.setContent(detailsView);
        detailsPane.setExpanded(false);
        
        rootLayout.getChildren().addAll(pageTitle, score, detailsPane, 
                btnTestAgain);      
    }
    
    private void refreshResults(final ResourceBundle lang, final TestPassingUnit testPU) {
        detailsView.getEngine().loadContent(testPU.checkResults(lang));
        score.setText(lang.getString("ResPage.points")+String.valueOf(testPU.getScore()));
    }
    
    public Node getResultPage(final ResourceBundle lang, final TestPassingUnit testPU) {
        refreshResults(lang, testPU);
        return rootLayout;
    }
}
