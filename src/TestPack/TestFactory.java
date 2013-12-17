package TestPack;

import TestPack.TestPages.TestPageInterface;
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


public class TestFactory {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.
     (нумерация начинается с нуля!)*/
    public static TestPageInterface returnPage(int pageNumber, TestSystemGenerator sg, ResourceBundle lang) {
        TestPageInterface tpi;
        switch (pageNumber) {     
            case 0:
                tpi = new Page1interface(sg, lang);
                break;
            case 1:
                tpi = new Page2interface(sg, lang);
                break;
            case 2:
                tpi = new Page3interface(sg, lang);
                break;
            case 3:
                tpi = new Page4interface(sg, lang);
                break;
            case 4:
                tpi = new Page5interface(sg, lang);
                break;
            case 5:
                tpi = new Page6interface(sg, lang);
                break;
            case 6:
                tpi = new Page7interface(sg, lang);
                break;
            case 7:
                tpi = new Page8interface(sg, lang);
                break;
            case 8:
                tpi = new Page9interface(sg, lang);
                break;
            default:
                throw new AssertionError();
        }
        return tpi;
    };
}