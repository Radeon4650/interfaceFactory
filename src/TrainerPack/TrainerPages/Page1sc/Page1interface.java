package TrainerPack.TrainerPages.Page1sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page1interface {
    private Label infoLab1;
    private VBox rootLayout;

    public Page1interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Trainer mode page 1");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 1й страницы режима Тренер  */
    public VBox getRootLayout() {
        return rootLayout;
    }
    
    
}
