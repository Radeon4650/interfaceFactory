

package TestPack.TestPages.Page6sc;

import TestPack.TestSystemGenerator;
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

    public Page6interface(TestSystemGenerator sg, ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Test mode page 6");
        rootLayout = new VBox();
        rootLayout.getChildren().add(infoLab1);
    }
    
    /** @return интерфейс 6й страницы режима Тест  */
    public VBox getRootLayout() {
        return rootLayout;
    }
    
    public boolean dataCheck(TestSystemGenerator sg)  {
//        double[] dc = new double[0];
//        try {
//            dc[0] = Double.parseDouble(kTextField.getText());
//        }
//        catch (NumberFormatException nfe) {
//            dc[0]=-1;
//        }
//        try {
//            dc[1] = Double.parseDouble(aTextField.getText());
//        }
//        catch (NumberFormatException nfe) {
//            dc[1]=-1;
//        }
//        try {
//            dc[2] = Double.parseDouble(bTextField.getText());
//        }
//        catch (NumberFormatException nfe) {
//            dc[2]=-1;
//        }
//        try {
//            dc[3] = Double.parseDouble(cTextField.getText());
//        }
//        catch (NumberFormatException nfe) {
//            dc[3]=-1;
//        }
        
        return true;
    }
}
