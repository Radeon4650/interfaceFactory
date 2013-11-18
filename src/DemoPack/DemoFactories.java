package DemoPack;

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


abstract class DemoPage {
    private static Node rootPageLayout;

    public Node getRootPageLayout() {
        return rootPageLayout;
    }

    public void setRootPageLayout(Node aRootPageLayout) {
        rootPageLayout = aRootPageLayout;
    }
     
}

/**1-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage1 extends DemoPage {
    public DemoPage1(DemoSystemGenerator sg, ResourceBundle lang){
        Page1interface p1 = new Page1interface(sg, lang);
        setRootPageLayout(p1.getRootLayout());
    }
}

/**2-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage2 extends DemoPage {
    public DemoPage2(DemoSystemGenerator sg, ResourceBundle lang){
        Page2interface p2 = new Page2interface(sg, lang);
        setRootPageLayout(p2.getRootLayout());
    }
 }

/**3-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage3 extends DemoPage {
    public DemoPage3(DemoSystemGenerator sg, ResourceBundle lang){
        Page3interface p3 = new Page3interface(sg, lang);
        setRootPageLayout(p3.getRootLayout());
    }
 }

/**4-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage4 extends DemoPage {
    public DemoPage4(DemoSystemGenerator sg, ResourceBundle lang){
        Page4interface p4 = new Page4interface(sg, lang);
        setRootPageLayout(p4.getRootLayout());
    }
 }

/**5-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage5 extends DemoPage { 
    public DemoPage5(DemoSystemGenerator sg, ResourceBundle lang){
        Page5interface p5 = new Page5interface(sg, lang);
        setRootPageLayout(p5.getRootLayout());
    }
}

/**6-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage6 extends DemoPage { 
    public DemoPage6(DemoSystemGenerator sg, ResourceBundle lang){
        Page6interface p6 = new Page6interface(sg, lang);
        setRootPageLayout(p6.getRootLayout());
    }
}

/**7-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage7 extends DemoPage { 
    public DemoPage7(DemoSystemGenerator sg, ResourceBundle lang){
        Page7interface p7 = new Page7interface(sg, lang);
        setRootPageLayout(p7.getRootLayout());
    }
}

/**8-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage8 extends DemoPage { 
    public DemoPage8(DemoSystemGenerator sg, ResourceBundle lang){
        Page8interface p8 = new Page8interface(sg, lang);
        setRootPageLayout(p8.getRootLayout());
    }
}


class ConcretePageLayout {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.*/
    public static Node returnRootLayout(int pageNumber, DemoSystemGenerator sg, ResourceBundle lang) {
        DemoPage dp;
        switch (pageNumber) {     
            case 0:
                dp = new DemoPage1(sg, lang);
                break;
            case 1:
                dp = new DemoPage2(sg, lang);
                break;
            case 2:
                dp = new DemoPage3(sg, lang);
                break;
            case 3:
                dp = new DemoPage4(sg, lang);
                break;
            case 4:
                dp = new DemoPage5(sg, lang);
                break;
            case 5:
                dp = new DemoPage6(sg, lang);
                break;
            case 6:
                dp = new DemoPage7(sg, lang);
                break;
            case 7:
                dp = new DemoPage8(sg, lang);
                break;
            default:
                throw new AssertionError();
        }
        return dp.getRootPageLayout();
    };
}
