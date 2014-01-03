package TrainerPack;

import DiffModesCommon.AppStyles;
import TestPack.TestInterface;
import TestPack.TestSystemGenerator;
import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 *
 * @author radeon
 */
public class TrainerInterface extends TestInterface {
    
    
    
    public TrainerInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {    
        super(lang, ifFact);
        Tooltip lessonTitleTooltip = new Tooltip(lang.getString("ModeSelectionInterface.trainerBtnHint"));
        lessonTitleTooltip.setStyle(AppStyles.tooltipStyle()); 
        modeTitle.setText(lang.getString("TrainerInterface.modeTitle"));
        modeTitle.setTooltip(lessonTitleTooltip);
        lessonTitle.setText(lang.getString("TrainerInterface.lessonTitle")); 
        modeTitle.setStyle(AppStyles.titleFontStyle());
        setCurrentPage(lang, 0);
        tInterface.setCenter(currentPage.getRootLayout());
        nextStepErrorInfo.setText(lang.getString("TrainerInterface.nextStepError"));
        
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
        watchDemoBtn.setVisible(true);
        if (currentPageNumber>7) watchDemoBtn.setDisable(true);
        else watchDemoBtn.setDisable(false);
        if (currentPageNumber>8) watchDemoBtn.setVisible(false);
    }
    
    
    public static boolean checkTextValue(final int pageNumber, final String key, 
            final TestSystemGenerator sg, final TextField inputField, 
            final TrainerControl ctrl) {
        
        boolean rightInput = sg.getStudPassing(pageNumber, key);
        if (ctrl.checkValueResult(rightInput))
            return true;
        else inputField.setStyle(AppStyles.trainerErrorInputStyle());
        return false;
    }; 
}
