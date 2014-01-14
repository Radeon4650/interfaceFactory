package TrainerPack.TrainerPages.Page1sc;

import DemoPack.DemoFactory;
import DemoPack.DemoSystemGenerator;
import DiffModesCommon.PromptSet;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import TrainerPack.TrainerInterface;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author radeon
 */
public class Page1interface extends TestPack.TestPages.Page1sc.Page1interface {
    private final Button formulaFsPromptBtn;

    public Page1interface(final TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);     
        formulaFsPromptBtn = new Button(lang.getString("TrainerInterface.promptBtnTitle"));  
        formulaFsPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p1.promptBtnHint")));
        coeffGrid.add(formulaFsPromptBtn, 0, 5, 2, 1);
        formulaFsPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_Fs", coeffGrid, 0, 5, 2, 1);
                sg.hintWatchScore();
            }
        });
 
    }    
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        grid.add(DemoFactory.returnDemoView(0, dsg, lang, ctrl), 0, 0, 2, 2);
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        int pageNumber = 0;
        super.dataCheck(sg, ctrl);
        
        boolean kRes, aRes, bRes, cRes;
        kRes = TrainerInterface.checkTextValue(pageNumber, "k", sg, kTextField, ctrl);
        aRes = TrainerInterface.checkTextValue(pageNumber, "a", sg, aTextField, ctrl);
        bRes = TrainerInterface.checkTextValue(pageNumber, "b", sg, bTextField, ctrl);
        cRes = TrainerInterface.checkTextValue(pageNumber, "c", sg, cTextField, ctrl);
        
        return (kRes & aRes & bRes & cRes);
    }
    

}
