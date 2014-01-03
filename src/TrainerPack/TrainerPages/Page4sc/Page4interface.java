package TrainerPack.TrainerPages.Page4sc;

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
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl) {
        int pageNumber = 3;
        super.dataCheck(sg, ctrl);
//        double auto_x1 = - sg.getFs().getT1();
//        double auto_x2 = - sg.getFs().getT2();
//        double auto_x3 = - sg.getFs().getT1();
//        double auto_x4 = - sg.getFs().getT2();
//        
//        double auto_k = sg.getFs().getK();
//        double auto_h = sg.getFs().getU_w().getH();
//        double auto_e = sg.getFs().getV_w().getE();
//        double auto_mU = sg.getFs().getU_w().getM();
//        double auto_nU = sg.getFs().getU_w().getN();
//        double auto_mV = sg.getFs().getV_w().getM();
//        double auto_nV = sg.getFs().getV_w().getN();
        
        boolean x1Res, x2Res, x3Res, x4Res;
        boolean kRes, hRes, eRes, mURes, nURes, mVRes, nVRes;
        x1Res = TrainerInterface.checkTextValue(pageNumber, "x1", sg, x1tf, ctrl);
        x2Res = TrainerInterface.checkTextValue(pageNumber, "x2", sg, x2tf, ctrl);
        x3Res = TrainerInterface.checkTextValue(pageNumber, "x3", sg, x3tf, ctrl);
        x4Res = TrainerInterface.checkTextValue(pageNumber, "x4", sg, x4tf, ctrl);
        kRes = TrainerInterface.checkTextValue(pageNumber, "k", sg, kTf, ctrl);
        hRes = TrainerInterface.checkTextValue(pageNumber, "h", sg, hTf, ctrl);
        eRes = TrainerInterface.checkTextValue(pageNumber, "e", sg, eTf, ctrl);
        mURes = TrainerInterface.checkTextValue(pageNumber, "mU", sg, mUTf, ctrl);
        nURes = TrainerInterface.checkTextValue(pageNumber, "nU", sg, nUTf, ctrl);
        mVRes = TrainerInterface.checkTextValue(pageNumber, "mV", sg, mVTf, ctrl);
        nVRes = TrainerInterface.checkTextValue(pageNumber, "nV", sg, nVTf, ctrl);
        
        return (x1Res & x2Res & x3Res & x4Res & kRes & hRes & eRes & mURes 
                & nURes & mVRes & nVRes);
    }

}
