package TrainerPack.TrainerPages.Page3sc;

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
public class Page3interface extends TestPack.TestPages.Page3sc.Page3interface {
    Button tfPromptBtn;
    Button replPromptBtn;
    
    public Page3interface(TestSystemGenerator sg, final ResourceBundle lang, final TrainerControl ctrl) {
        super(sg, lang);
        tfPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        replPromptBtn = new Button("< " + lang.getString("TrainerInterface.promptBtnTitle"));
        
        tfPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p3.tfPromptBtn")));
        replPromptBtn.setTooltip(new Tooltip(lang.getString("Trainer.p3.replPromptBtn")));
        
        tfPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "formula_Fs_t1t2", rootLayout, 1, 4, 2, 1);
            }
        });
        replPromptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                PromptSet.putPrompt(lang, ctrl, "replacementSjw", rootLayout, 1, 7, 2, 1);
            }
        });
        
        rootLayout.add(tfPromptBtn, 1, 4, 2, 1);
        rootLayout.add(replPromptBtn, 1, 7, 2, 1);
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(2, dsg, lang, ctrl), 0, 0, 4, 8);
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        int pageNumber = 2;
        super.dataCheck(sg, ctrl);
//        double auto_k = sg.getFs().getK();
//        double auto_t1 = sg.getFs().getT1();
//        double auto_t2 = sg.getFs().getT2();
        
        
        boolean kRes, t1Res, t2Res;
        kRes = TrainerInterface.checkTextValue(pageNumber, "k", sg, kTextField, ctrl);
        t1Res = TrainerInterface.checkTextValue(pageNumber, "T1", sg, t1TextField, ctrl);
        t2Res = TrainerInterface.checkTextValue(pageNumber, "T2", sg, t2TextField, ctrl);
        
        return (kRes &t1Res & t2Res);
    }
}
