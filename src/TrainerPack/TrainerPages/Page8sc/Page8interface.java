

package TrainerPack.TrainerPages.Page8sc;

import DemoPack.DemoFactory;
import DemoPack.DemoSystemGenerator;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */
public class Page8interface extends TestPack.TestPages.Page8sc.Page8interface {


    public Page8interface(TestSystemGenerator sg, ResourceBundle lang, TrainerControl ctrl) {
        super(sg, lang);

    }

    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        rootLayout.add(DemoFactory.returnDemoView(7, dsg, lang, ctrl), 0, 0);
    }
}
