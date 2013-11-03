package DemoPack;

import DemoPack.DemoPages.Page1sc.Page1interface;
import DemoPack.DemoPages.Page2sc.Page2interface;
import DemoPack.DemoPages.Page3sc.Page3interface;
import DemoPack.DemoPages.Page4sc.Page4interface;
import DemoPack.DemoPages.Page5sc.Page5interface;
import DemoPack.DemoPages.Page6sc.Page6interface;
import DemoPack.DemoPages.Page7sc.Page7interface;
import DemoPack.DemoPages.Page8sc.Page8interface;
import interfacefactory.SystemGenerator;
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
    public DemoPage1(SystemGenerator sg){
        Page1interface p1 = new Page1interface(sg);
        setRootPageLayout(p1.getRootLayout());
    }
}

/**2-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage2 extends DemoPage {
    public DemoPage2(SystemGenerator sg){
        Page2interface p2 = new Page2interface(sg);
        setRootPageLayout(p2.getRootLayout());
    }
 }

/**3-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage3 extends DemoPage {
    public DemoPage3(SystemGenerator sg){
        Page3interface p3 = new Page3interface(sg);
        setRootPageLayout(p3.getRootLayout());
    }
 }

/**4-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage4 extends DemoPage {
    public DemoPage4(SystemGenerator sg){
        Page4interface p4 = new Page4interface(sg);
        setRootPageLayout(p4.getRootLayout());
    }
 }

/**5-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage5 extends DemoPage { 
    public DemoPage5(SystemGenerator sg){
        Page5interface p5 = new Page5interface(sg);
        setRootPageLayout(p5.getRootLayout());
    }
}

/**6-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage6 extends DemoPage { 
    public DemoPage6(SystemGenerator sg){
        Page6interface p6 = new Page6interface(sg);
        setRootPageLayout(p6.getRootLayout());
    }
}

/**7-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage7 extends DemoPage { 
    public DemoPage7(SystemGenerator sg){
        Page7interface p7 = new Page7interface(sg);
        setRootPageLayout(p7.getRootLayout());
    }
}

/**8-я страница пользовательского интерфейса в режиме "Демо"*/
class DemoPage8 extends DemoPage { 
    public DemoPage8(SystemGenerator sg){
        Page8interface p8 = new Page8interface(sg);
        setRootPageLayout(p8.getRootLayout());
    }
}


class ConcretePageLayout {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.*/
    public static Node returnRootLayout(int pageNumber, SystemGenerator sg) {
        DemoPage dp;
        switch (pageNumber) {     
            case 0:
                dp = new DemoPage1(sg);
                break;
            case 1:
                dp = new DemoPage2(sg);
                break;
            case 2:
                dp = new DemoPage3(sg);
                break;
            case 3:
                dp = new DemoPage4(sg);
                break;
            case 4:
                dp = new DemoPage5(sg);
                break;
            case 5:
                dp = new DemoPage6(sg);
                break;
            case 6:
                dp = new DemoPage7(sg);
                break;
            case 7:
                dp = new DemoPage8(sg);
                break;
            default:
                throw new AssertionError();
        }
        return dp.getRootPageLayout();
    };
}
