

package TrainerPack.TrainerPages.Page6sc;

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
public class Page6interface extends TestPack.TestPages.Page6sc.Page6interface {
    private Button apbPromptBtn;

    public Page6interface(TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);
        apbPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        apbPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p6.apbPromptBtn")));
        apbPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_passband", rootLayout, 1, 0, 2, 1);
            }
        });
        
        rootLayout.add(apbPromptBtn, 1, 0, 2, 1);
    }

    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(5, dsg, lang, ctrl), 0, 0, 3, 5);
    }
}
