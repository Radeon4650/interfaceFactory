package TrainerPack;

import DiffModesCommon.AppStyles;
import TestPack.TestInterface;
import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author radeon
 */
public class TrainerInterface extends TestInterface {
    private final TrainerControl ctrl;
    
    
    public TrainerInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {    
        super(lang, ifFact);
        ctrl = new TrainerControl();
        modeTitle.setText(lang.getString("TrainerInterface.modeTitle"));
        modeTitle.setTooltip(new Tooltip(lang.getString("ModeSelectionInterface.trainerBtnHint")));
        lessonTitle.setText(lang.getString("TrainerInterface.lessonTitle")); 
        modeTitle.setStyle(AppStyles.titleFontStyle());
        setCurrentPage(lang, 0);
        tInterface.setCenter(currentPage.getRootLayout());
        
        watchDemoBtn.setVisible(true);
        watchDemoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                currentPage.watchDemo(sg, lang, ctrl);
            }
        });
    }
    
    @Override
    protected void setCurrentPage(final ResourceBundle lang, int pageNumber) {
        currentPage = TrainerFactory.returnPage(pageNumber, ctrl, sg, lang);
    }
}
