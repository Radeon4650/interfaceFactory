

package TestPack;

import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class ResultPage {
    private VBox rootLayout;
    
    public ResultPage(final ResourceBundle lang, final TestPassingUnit testPU) {
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setSpacing(10);
        
        Button btnTestAgain = new Button(lang.getString("ResPage.btnTestAgain"));
        Label pageTitle = new Label(lang.getString("ResPage.title"));
        Label score = new Label(lang.getString("ResPage.points")+String.valueOf(testPU.getScore()));
        
        WebView detailsView = new WebView();
        detailsView.getEngine().loadContent(testPU.checkResults(lang));
        
        TitledPane detailsPane = new TitledPane();
        detailsPane.setText(lang.getString("ResPage.details"));
        detailsPane.setContent(detailsView);
        detailsPane.setExpanded(false);
        
        rootLayout.getChildren().addAll(pageTitle, score, detailsPane, 
                btnTestAgain);
        
    }
    
    public Node getResultPage() {
        return rootLayout;
    }
}
