package TrainerPack;

import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
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

public class TrainerFactory {
    /**@return экземпляр необходимой страницы в соответствии с номером.
     * @param pageNumber номер страницы, которую необходимо вернуть.
     (нумерация начинается с нуля!)*/
    public static TestPageInterface returnPage(int pageNumber, TestSystemGenerator sg, ResourceBundle lang) {
        TestPageInterface tp;
        switch (pageNumber) {     
            case 0:
                tp = new Page1interface(sg, lang);
                break;
            case 1:
                tp = new Page2interface(sg, lang);
                break;
            case 2:
                tp = new Page3interface(sg, lang);
                break;
            case 3:
                tp = new Page4interface(sg, lang);
                break;
            case 4:
                tp = new Page5interface(sg, lang);
                break;
            case 5:
                tp = new Page6interface(sg, lang);
                break;
            case 6:
                tp = new Page7interface(sg, lang);
                break;
            case 7:
                tp = new Page8interface(sg, lang);
                break;
            case 8:
                tp = new Page9interface(sg, lang);
                break;
            default:
                throw new AssertionError();
        }
        return tp;
    };
}