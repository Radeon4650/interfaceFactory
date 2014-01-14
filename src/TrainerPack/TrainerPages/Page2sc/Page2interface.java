package TrainerPack.TrainerPages.Page2sc;

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
public class Page2interface extends TestPack.TestPages.Page2sc.Page2interface {
    private final Button sqEqPromptBtn;
    private final Button t1t2PromptBtn;
    
    public Page2interface(final TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);
        sqEqPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        t1t2PromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        
        sqEqPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p2.sqEqPromptBtnHint")));
        t1t2PromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p2.t1t2PromptBtnHint")));
        
        sqEqPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_sqEquation", rootLayout, 4, 2, 1, 8);
                sg.hintWatchScore();
            }
        });
        t1t2PromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_T1_T2", rootLayout, 4, 10, 1, 3);
                sg.hintWatchScore();
            }
        });
        
        rootLayout.add(sqEqPromptBtn, 4, 2, 1, 8);
        rootLayout.add(t1t2PromptBtn, 4, 10, 1, 3);
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(1, dsg, lang, ctrl), 0, 0, 5, 13);
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        int pageNumber = 1;
        super.dataCheck(sg, ctrl);
        
        
        boolean aRes, bRes, cRes, dRes, s1Res, s2Res, t1Res, t2Res;
        aRes = TrainerInterface.checkTextValue(pageNumber, "a", sg, aTextField, ctrl);
        bRes = TrainerInterface.checkTextValue(pageNumber, "b", sg, bTextField, ctrl);
        cRes = TrainerInterface.checkTextValue(pageNumber, "c", sg, cTextField, ctrl);
        dRes = TrainerInterface.checkTextValue(pageNumber, "D", sg, DTextField, ctrl);
        s1Res = TrainerInterface.checkTextValue(pageNumber, "s1", sg, s1TextField, ctrl);
        s2Res = TrainerInterface.checkTextValue(pageNumber, "s2", sg, s2TextField, ctrl);
        t1Res = TrainerInterface.checkTextValue(pageNumber, "T1", sg, t1TextField, ctrl);
        t2Res = TrainerInterface.checkTextValue(pageNumber, "T2", sg, t2TextField, ctrl);
        
        return (aRes & bRes & cRes & dRes & s1Res & s2Res &t1Res & t2Res);
    }
}
