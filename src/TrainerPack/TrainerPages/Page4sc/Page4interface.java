package TrainerPack.TrainerPages.Page4sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page4interface {
        private Label infoLab1;
    private VBox rootLayout;

    public Page4interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Trainer mode page 4");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 4й страницы режима Тренер  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
