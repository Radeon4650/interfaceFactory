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
    
    abstract public boolean checkPage(TestSystemGenerator sg);
    
}

/**1-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage1 extends TestPage {
    private Page1interface p1;
    
    public TestPage1(TestSystemGenerator sg, ResourceBundle lang){
        p1 = new Page1interface(sg, lang);
        setRootPageLayout(p1.getRootLayout());
    }

    /**@return результат успешности преобразования данных, 
     * введенных пользователем на странице 1 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p1.dataCheck(sg);
    }
}

/**2-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage2 extends TestPage {
    private Page2interface p2;
    
    public TestPage2(TestSystemGenerator sg, ResourceBundle lang){
        p2 = new Page2interface(sg, lang);
        setRootPageLayout(p2.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 2 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p2.dataCheck(sg);
    }
 }

/**3-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage3 extends TestPage {
    private Page3interface p3;
    
    public TestPage3(TestSystemGenerator sg, ResourceBundle lang){
        p3 = new Page3interface(sg, lang);
        setRootPageLayout(p3.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 3 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p3.dataCheck(sg);
    }
 }

/**4-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage4 extends TestPage {
    private Page4interface p4;
    
    public TestPage4(TestSystemGenerator sg, ResourceBundle lang){
        p4 = new Page4interface(sg, lang);
        setRootPageLayout(p4.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 4 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p4.dataCheck(sg);
    }
 }

/**5-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage5 extends TestPage { 
    private Page5interface p5;
            
    public TestPage5(TestSystemGenerator sg, ResourceBundle lang){
        p5 = new Page5interface(sg, lang);
        setRootPageLayout(p5.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 5 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p5.dataCheck(sg);
    }
}

/**6-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage6 extends TestPage { 
    private Page6interface p6;
            
    public TestPage6(TestSystemGenerator sg, ResourceBundle lang){
        p6 = new Page6interface(sg, lang);
        setRootPageLayout(p6.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 6 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p6.dataCheck(sg);
    }
}

/**7-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage7 extends TestPage { 
    private Page7interface p7;
            
    public TestPage7(TestSystemGenerator sg, ResourceBundle lang){
        p7 = new Page7interface(sg, lang);
        setRootPageLayout(p7.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 7 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p7.dataCheck(sg);
    }
}

/**8-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage8 extends TestPage { 
    private Page8interface p8;
            
    public TestPage8(TestSystemGenerator sg, ResourceBundle lang){
        p8 = new Page8interface(sg, lang);
        setRootPageLayout(p8.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 8 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p8.dataCheck(sg);
    }
}

/**9-я страница пользовательского интерфейса в режиме "Тест"*/
class TestPage9 extends TestPage { 
    private Page9interface p9;
            
    public TestPage9(TestSystemGenerator sg, ResourceBundle lang){
        p9 = new Page9interface(sg, lang);
        setRootPageLayout(p9.getRootLayout());
    }

    /**@return результат успешности преобразования данных,
     * введенных пользователем на странице 9 
     * для проверки правильности решения*/
    public boolean checkPage(TestSystemGenerator sg) {
        return p9.dataCheck(sg);
    }
}

class ConcretePage {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.
     (нумерация начинается с нуля!)*/
    public static TestPage returnPage(int pageNumber, TestSystemGenerator sg, ResourceBundle lang) {
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
        return tp;
    };
}