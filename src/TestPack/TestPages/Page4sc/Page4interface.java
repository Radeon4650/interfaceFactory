package TestPack.TestPages.Page4sc;

import TestPack.TestSystemGenerator;
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

    public Page4interface(TestSystemGenerator sg, ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Test mode page 4");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 4й страницы режима Тест  */
    public VBox getRootLayout() {
        return rootLayout;
    }
}
