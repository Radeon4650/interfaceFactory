

package TrainerPack.TrainerPages.Page6sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page6interface {
        private Label infoLab1;
    private VBox rootLayout;

    public Page6interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Trainer mode page 6");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 6й страницы режима Тренер  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
