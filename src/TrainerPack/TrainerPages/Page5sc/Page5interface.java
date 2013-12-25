package TrainerPack.TrainerPages.Page5sc;

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
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 *
 * @author radeon
 */

public class Page5interface extends TestPack.TestPages.Page5sc.Page5interface {
    private Button apcPromptBtn;

    public Page5interface(TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);
        apcPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        apcPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p5.apcPromptBtn")));
        apcPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_Aw", rootLayout, 1, 1, 2, 1);
            }
        });
        
        rootLayout.add(apcPromptBtn, 1, 1, 2, 1);
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(4, dsg, lang, ctrl), 0, 0, 3, 8);
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        int pageNumber = 4;
        super.dataCheck(sg, ctrl);
//        double auto_k = sg.getFs().getK();
//        double auto_m = sg.getFs().getA_w().getM();
//        double auto_n = sg.getFs().getA_w().getN();
        
        boolean kRes, mRes, nRes;
        kRes = TrainerInterface.checkTextValue(pageNumber, "k", sg, kTf, ctrl);
        mRes = TrainerInterface.checkTextValue(pageNumber, "m", sg, mTf, ctrl);
        nRes = TrainerInterface.checkTextValue(pageNumber, "n", sg, nTf, ctrl);
        
        return (kRes & mRes & nRes);
    }
}
