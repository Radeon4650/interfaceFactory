package TrainerPack.TrainerPages.Page4sc;

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
public class Page4interface extends TestPack.TestPages.Page4sc.Page4interface {
    private Button abrPromptBtn;

    public Page4interface(TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);
        abrPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        abrPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p4.abrPromptBtn")));
        abrPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "abridgedMulFormula", rootLayout, 1, 5, 2, 2);
            }
        });
        
        rootLayout.add(abrPromptBtn, 1, 5, 2, 2);
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(3, dsg, lang, ctrl), 0, 0, 3, 16);
    }

}
