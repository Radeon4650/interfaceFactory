package TrainerPack.TrainerPages.Page2sc;

import DemoPack.DemoFactory;
import DemoPack.DemoSystemGenerator;
import DiffModesCommon.PromptSet;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
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
    
    public Page2interface(TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);
        sqEqPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        t1t2PromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        
        sqEqPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p2.sqEqPromptBtnHint")));
        t1t2PromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p2.t1t2PromptBtnHint")));
        
        sqEqPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_sqEquation", rootLayout, 4, 2, 1, 8);
            }
        });
        t1t2PromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_T1_T2", rootLayout, 4, 10, 1, 3);
            }
        });
        
        rootLayout.add(sqEqPromptBtn, 4, 2, 1, 8);
        rootLayout.add(t1t2PromptBtn, 4, 10, 1, 3);
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(1, dsg, lang, ctrl), 0, 0, 5, 13);
    }
}
