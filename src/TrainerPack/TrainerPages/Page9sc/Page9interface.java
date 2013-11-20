
package TrainerPack.TrainerPages.Page9sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page9interface {
    private Label infoLab1;
    private VBox rootLayout;

    public Page9interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Trainer mode page 9");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 9й страницы режима Тренер  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
