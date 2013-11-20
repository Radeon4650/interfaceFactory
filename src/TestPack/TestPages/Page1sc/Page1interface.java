package TestPack.TestPages.Page1sc;

import DiffModesCommon.StructScheme;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page1interface {
    private Label infoLab1;
    private VBox rootLayout;

    public Page1interface(ResourceBundle lang) {
        infoLab1 = new Label();
        infoLab1.setText("Test mode page 1");
        rootLayout = new VBox();
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.getChildren().add(infoLab1);
        WebView wv = new WebView();
        wv.getEngine().loadContent("<html><body>"
                + "<table width = \"100%\"><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Test.p1.structSheme")
                + "</b></p>"
                + StructScheme.getStructScheme()
                + "</td><td width = \"33%\"><p><b>"
                + lang.getString("Test.p1.sourceData")
                + "</b></p>"
//                + sg.getWk1().printInMathML()+";\t"+ sg.getWk5().printInMathML()
//                + ";<br>"
//                + sg.getWk2().printInMathML()+";\t"+ sg.getWk6().printInMathML()
//                + ";<br>"
//                + sg.getWd3().printInMathML()
//                + ";<br>"
//                + sg.getWd4().printInMathML()
                + ".</td></table></body></html>");
        rootLayout.getChildren().add(wv);  
    }
    
    /** @return интерфейс 1й страницы режима Тест  */
    public VBox getRootLayout() {
        return rootLayout;
    }
    
    
}
