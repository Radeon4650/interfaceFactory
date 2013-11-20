package TestPack.TestPages.Page7sc;

import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page7interface {
    private Label infoLab1;
    private VBox rootLayout;

    public Page7interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Test mode page 7");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 7й страницы режима Тест  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
