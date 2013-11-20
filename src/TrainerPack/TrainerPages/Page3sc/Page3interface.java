package TrainerPack.TrainerPages.Page3sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page3interface {
        private Label infoLab1;
    private VBox rootLayout;

    public Page3interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Trainer mode page 3");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 3й страницы режима Тренер  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
