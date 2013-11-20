package TrainerPack.TrainerPages.Page5sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page5interface {
        private Label infoLab1;
    private VBox rootLayout;

    public Page5interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Trainer mode page 5");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 5й страницы режима Тренер  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
