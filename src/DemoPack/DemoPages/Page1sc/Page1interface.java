// Demo интерфейс page 1

package DemoPack.DemoPages.Page1sc;

import DemoPack.DemoPages.DemoPageInterface;
import DiffModesCommon.StructScheme;
import DiffModesCommon.PromptSet;
import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import java.util.ResourceBundle;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.web.WebView;

/**
 *
 * @author Radeon
 */
public class Page1interface extends DemoPageInterface {
    private GridPane rootLayout;
    
    public Page1interface (DemoSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.BASELINE_CENTER);
            
        WebView wv = new WebView();
        
        wv.contextMenuEnabledProperty().set(false);
        wv.setDisable(true);
        
        wv.getEngine().loadContent("<html><body><font face=\"" 
                + AppStyles.readingFont()
                + "\">"
                + "<table><tr height=\"60%\"><td align = \"center\">"
                + "<p><b>"
                + lang.getString("Demo.p1.structSheme")
                + "</b></p>"
                + StructScheme.getStructScheme(lang)
                + "</td><td width=\"33%\"><p align = \"center\"><b>"
                + lang.getString("Demo.p1.sourceData")
                + "</b></p>"
                + sg.getWk1().printInMathML()+";\t"+ sg.getWk5().printInMathML()
                + ";<br>"
                + sg.getWk2().printInMathML()+";\t"+ sg.getWk6().printInMathML()
                + ";<br>"
                + sg.getWd3().printInMathML()
                + ";<br>"
                + sg.getWd4().printInMathML()
                + ".</td></tr><tr height=\"40%\" valign=\"top\"><td align = \"center\"><p><b>"
                + lang.getString("Demo.p1.transFuncGetting")
                + "</b></p>"
                + PromptSet.fsEquation() + ";<br>"
                + sg.getFs().printInMathMLWith_abc_s()
                + ".</td><td>"
                + PromptSet.getPrompt("formula_Fs", lang)
                + "</td></tr></table>"
                + "</font></body></html>");
           
        
        WebView tipView = new WebView();
        tipView.getEngine().loadContent(sg.printFullFsObtainingInMathML(lang));
        
        rootLayout.add(wv, 0, 0);
        
        RowConstraints rc0 = new RowConstraints();
        rc0.setPercentHeight(100);
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(98);
        col0.setHalignment(HPos.CENTER);
     
        
        rootLayout.getRowConstraints().addAll(rc0);
        rootLayout.getColumnConstraints().addAll(col0);
    }
    
    @Override
    public Node getRootLayout(){
        return rootLayout;
    }
}
