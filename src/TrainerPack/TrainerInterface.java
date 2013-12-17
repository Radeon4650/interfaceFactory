package TrainerPack;

import TestPack.TestInterface;
import interfacefactory.InterfaceFactory;
import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */
public class TrainerInterface extends TestInterface {
    
    public TrainerInterface(final ResourceBundle lang, final InterfaceFactory ifFact) {
        super(lang, ifFact);
        modeTitle.setText(lang.getString("TrainerInterface.modeTitle"));
        lessonTitle.setText(lang.getString("TrainerInterface.lessonTitle"));  
    }
    
    @Override
    protected void setCurrentPage(final ResourceBundle lang, int pageNumber) {
        currentPage = TrainerFactory.returnPage(pageNumber, sg, lang);
    }
}
