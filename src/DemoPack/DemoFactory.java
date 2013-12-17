package DemoPack;

import DemoPack.DemoPages.DemoPageInterface;
import DemoPack.DemoPages.Page1sc.Page1interface;
import DemoPack.DemoPages.Page2sc.Page2interface;
import DemoPack.DemoPages.Page3sc.Page3interface;
import DemoPack.DemoPages.Page4sc.Page4interface;
import DemoPack.DemoPages.Page5sc.Page5interface;
import DemoPack.DemoPages.Page6sc.Page6interface;
import DemoPack.DemoPages.Page7sc.Page7interface;
import DemoPack.DemoPages.Page8sc.Page8interface;
import java.util.ResourceBundle;
import javafx.scene.Node;


public class DemoFactory {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.*/
    public static Node returnRootLayout(int pageNumber, DemoSystemGenerator sg, ResourceBundle lang) {
        DemoPageInterface dp;
        switch (pageNumber) {     
            case 0:
                dp = new Page1interface(sg, lang);
                break;
            case 1:
                dp = new Page2interface(sg, lang);
                break;
            case 2:
                dp = new Page3interface(sg, lang);
                break;
            case 3:
                dp = new Page4interface(sg, lang);
                break;
            case 4:
                dp = new Page5interface(sg, lang);
                break;
            case 5:
                dp = new Page6interface(sg, lang);
                break;
            case 6:
                dp = new Page7interface(sg, lang);
                break;
            case 7:
                dp = new Page8interface(sg, lang);
                break;
            default:
                throw new AssertionError();
        }
        return dp.getRootLayout();
    };
}
