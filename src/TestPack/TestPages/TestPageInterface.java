/*
 * Абстрактный класс, от которого унаследуются все страницы тестового интерфейса
 */

package TestPack.TestPages;

import DemoPack.DemoSystemGenerator;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.scene.Node;

/**
 *
 * @author radeon
 */
abstract public class TestPageInterface {    
    abstract public Node getRootLayout();
    abstract public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl);
    abstract public void saveData(TestSystemGenerator sg);
    abstract public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl);
}
