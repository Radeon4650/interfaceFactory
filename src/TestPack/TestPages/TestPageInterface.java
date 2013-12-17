/*
 * Абстрактный класс, от которого унаследуются все страницы тестового интерфейса
 */

package TestPack.TestPages;

import TestPack.TestSystemGenerator;
import javafx.scene.Node;

/**
 *
 * @author radeon
 */
abstract public class TestPageInterface {    
    abstract public Node getRootLayout();
    abstract public boolean dataCheck(TestSystemGenerator sg);
    abstract public void saveData(TestSystemGenerator sg);
}
