package TestPack;

import TestPack.TestPages.Page1sc.Page1interface;
import TestPack.TestPages.Page2sc.Page2interface;
import TestPack.TestPages.Page3sc.Page3interface;
import TestPack.TestPages.Page4sc.Page4interface;
import TestPack.TestPages.Page5sc.Page5interface;
import TestPack.TestPages.Page6sc.Page6interface;
import TestPack.TestPages.Page7sc.Page7interface;
import TestPack.TestPages.Page8sc.Page8interface;
import TestPack.TestPages.Page9sc.Page9interface;
import java.util.ResourceBundle;
import javafx.scene.Node;


abstract class TestPage {
    private static Node rootPageLayout;

    public Node getRootPageLayout() {
        return rootPageLayout;
    }

    public void setRootPageLayout(Node aRootPageLayout) {
        rootPageLayout = aRootPageLayout;
    }
     
}

/**1-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage1 extends TestPage {
    public TestPage1(TestSystemGenerator sg, ResourceBundle lang){
        Page1interface p1 = new Page1interface(sg, lang);
        setRootPageLayout(p1.getRootLayout());
    }
}

/**2-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage2 extends TestPage {
    public TestPage2(TestSystemGenerator sg, ResourceBundle lang){
        Page2interface p2 = new Page2interface(sg, lang);
        setRootPageLayout(p2.getRootLayout());
    }
 }

/**3-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage3 extends TestPage {
    public TestPage3(TestSystemGenerator sg, ResourceBundle lang){
        Page3interface p3 = new Page3interface(sg, lang);
        setRootPageLayout(p3.getRootLayout());
    }
 }

/**4-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage4 extends TestPage {
    public TestPage4(TestSystemGenerator sg, ResourceBundle lang){
        Page4interface p4 = new Page4interface(sg, lang);
        setRootPageLayout(p4.getRootLayout());
    }
 }

/**5-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage5 extends TestPage { 
    public TestPage5(TestSystemGenerator sg, ResourceBundle lang){
        Page5interface p5 = new Page5interface(sg, lang);
        setRootPageLayout(p5.getRootLayout());
    }
}

/**6-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage6 extends TestPage { 
    public TestPage6(TestSystemGenerator sg, ResourceBundle lang){
        Page6interface p6 = new Page6interface(sg, lang);
        setRootPageLayout(p6.getRootLayout());
    }
}

/**7-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage7 extends TestPage { 
    public TestPage7(TestSystemGenerator sg, ResourceBundle lang){
        Page7interface p7 = new Page7interface(sg, lang);
        setRootPageLayout(p7.getRootLayout());
    }
}

/**8-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage8 extends TestPage { 
    public TestPage8(TestSystemGenerator sg, ResourceBundle lang){
        Page8interface p8 = new Page8interface(sg, lang);
        setRootPageLayout(p8.getRootLayout());
    }
}

/**9-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage9 extends TestPage { 
    public TestPage9(TestSystemGenerator sg, ResourceBundle lang){
        Page9interface p9 = new Page9interface(sg, lang);
        setRootPageLayout(p9.getRootLayout());
    }
}

class ConcretePageLayout {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.
     (нумерация начинается с нуля!)*/
    public static Node returnRootLayout(int pageNumber, TestSystemGenerator sg, ResourceBundle lang) {
        TestPage tp;
        switch (pageNumber) {     
            case 0:
                tp = new TestPage1(sg, lang);
                break;
            case 1:
                tp = new TestPage2(sg, lang);
                break;
            case 2:
                tp = new TestPage3(sg, lang);
                break;
            case 3:
                tp = new TestPage4(sg, lang);
                break;
            case 4:
                tp = new TestPage5(sg, lang);
                break;
            case 5:
                tp = new TestPage6(sg, lang);
                break;
            case 6:
                tp = new TestPage7(sg, lang);
                break;
            case 7:
                tp = new TestPage8(sg, lang);
                break;
            case 8:
                tp = new TestPage9(sg, lang);
                break;
            default:
                throw new AssertionError();
        }
        return tp.getRootPageLayout();
    };
}