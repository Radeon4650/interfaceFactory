package TrainerPack.TrainerPages.Page7sc;

import DemoPack.DemoFactory;
import DemoPack.DemoSystemGenerator;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */
public class Page7interface extends TestPack.TestPages.Page7sc.Page7interface {


    public Page7interface(TestSystemGenerator sg, ResourceBundle lang, TrainerControl ctrl) {
        super(sg, lang);

    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(6, dsg, lang, ctrl), 0, 0, 1, 3);
    }
}
