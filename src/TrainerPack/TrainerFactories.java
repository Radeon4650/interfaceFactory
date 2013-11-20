package TrainerPack;

import TrainerPack.TrainerPages.Page1sc.Page1interface;
import TrainerPack.TrainerPages.Page2sc.Page2interface;
import TrainerPack.TrainerPages.Page3sc.Page3interface;
import TrainerPack.TrainerPages.Page4sc.Page4interface;
import TrainerPack.TrainerPages.Page5sc.Page5interface;
import TrainerPack.TrainerPages.Page6sc.Page6interface;
import TrainerPack.TrainerPages.Page7sc.Page7interface;
import TrainerPack.TrainerPages.Page8sc.Page8interface;
import TrainerPack.TrainerPages.Page9sc.Page9interface;
import java.util.ResourceBundle;
import javafx.scene.Node;

abstract class TrainerPage {
    private static Node rootPageLayout;

    public Node getRootPageLayout() {
        return rootPageLayout;
    }

    public void setRootPageLayout(Node aRootPageLayout) {
        rootPageLayout = aRootPageLayout;
    }
     
}

/**1-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage1 extends TrainerPage {
    public TrainerPage1(ResourceBundle lang){
        Page1interface p1 = new Page1interface(lang);
        setRootPageLayout(p1.getRootLayout());
    }
}

/**2-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage2 extends TrainerPage {
    public TrainerPage2(ResourceBundle lang){
        Page2interface p2 = new Page2interface(lang);
        setRootPageLayout(p2.getRootLayout());
    }
 }

/**3-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage3 extends TrainerPage {
    public TrainerPage3(ResourceBundle lang){
        Page3interface p3 = new Page3interface(lang);
        setRootPageLayout(p3.getRootLayout());
    }
 }

/**4-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage4 extends TrainerPage {
    public TrainerPage4(ResourceBundle lang){
        Page4interface p4 = new Page4interface(lang);
        setRootPageLayout(p4.getRootLayout());
    }
 }

/**5-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage5 extends TrainerPage { 
    public TrainerPage5(ResourceBundle lang){
        Page5interface p5 = new Page5interface(lang);
        setRootPageLayout(p5.getRootLayout());
    }
}

/**6-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage6 extends TrainerPage { 
    public TrainerPage6(ResourceBundle lang){
        Page6interface p6 = new Page6interface(lang);
        setRootPageLayout(p6.getRootLayout());
    }
}

/**7-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage7 extends TrainerPage { 
    public TrainerPage7(ResourceBundle lang){
        Page7interface p7 = new Page7interface(lang);
        setRootPageLayout(p7.getRootLayout());
    }
}

/**8-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage8 extends TrainerPage { 
    public TrainerPage8(ResourceBundle lang){
        Page8interface p8 = new Page8interface(lang);
        setRootPageLayout(p8.getRootLayout());
    }
}

/**9-я страница пользовательского интерфейса в режиме "Тренер"*/
class TrainerPage9 extends TrainerPage { 
    public TrainerPage9(ResourceBundle lang){
        Page9interface p9 = new Page9interface(lang);
        setRootPageLayout(p9.getRootLayout());
    }
}

class ConcretePageLayout {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.
     (нумерация начинается с нуля!)*/
    public static Node returnRootLayout(int pageNumber, ResourceBundle lang) {
        TrainerPage tp;
        switch (pageNumber) {     
            case 0:
                tp = new TrainerPage1(lang);
                break;
            case 1:
                tp = new TrainerPage2(lang);
                break;
            case 2:
                tp = new TrainerPage3(lang);
                break;
            case 3:
                tp = new TrainerPage4(lang);
                break;
            case 4:
                tp = new TrainerPage5(lang);
                break;
            case 5:
                tp = new TrainerPage6(lang);
                break;
            case 6:
                tp = new TrainerPage7(lang);
                break;
            case 7:
                tp = new TrainerPage8(lang);
                break;
            case 8:
                tp = new TrainerPage9(lang);
                break;
            default:
                throw new AssertionError();
        }
        return tp.getRootPageLayout();
    };
}