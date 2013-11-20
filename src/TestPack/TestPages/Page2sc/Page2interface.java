package TestPack.TestPages.Page2sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page2interface {
        private Label infoLab1;
    private VBox rootLayout;

    public Page2interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Test mode page 2");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 2й страницы режима Тест  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
