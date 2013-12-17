
package TestPack.TestPages.Page9sc;

import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 *
 * @author radeon
 */
public class Page9interface extends TestPageInterface {
    private Map<Integer, Integer> currentSelectedValue;
    
    private Map<Integer, String[]> setValue;
    private Map<Integer, Integer> setSize; 
    private Map<Integer, ChoiceBox> chBox;
    
    private final GridPane rootLayout;

    public Page9interface(TestSystemGenerator sg, ResourceBundle lang) {
        createCurrentSelectedValues();
        fillSetSize();
        fillSetValues(lang);
        fillChoiceBoxes(sg);
        
        rootLayout = new GridPane();
        addRootLayoutContent(lang);
        setRootLayoutConstraints();      
    }
    
    private void addRootLayoutContent(final ResourceBundle lang) {
        Label pageTitle = new Label(lang.getString("Test.p9.Sequence"));
        rootLayout.add(pageTitle, 0, 0, 2, 1);
        for (int i = 1; i < 13; i++) {
            rootLayout.add(new Label(String.valueOf(i)+") "), 0, i);            
        }
        rootLayout.add(chBox.get(1), 1, 1);     rootLayout.add(chBox.get(7), 1, 7);
        rootLayout.add(chBox.get(2), 1, 2);     rootLayout.add(chBox.get(8), 1, 8);
        rootLayout.add(chBox.get(3), 1, 3);     rootLayout.add(chBox.get(9), 1, 9);
        rootLayout.add(chBox.get(4), 1, 4);     rootLayout.add(chBox.get(10), 1, 10);
        rootLayout.add(chBox.get(5), 1, 5);     rootLayout.add(chBox.get(11), 1, 11);
        rootLayout.add(chBox.get(6), 1, 6);     rootLayout.add(chBox.get(12), 1, 12);
    }
    
    private void setRootLayoutConstraints() {
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        
        col0.setHalignment(HPos.RIGHT);
        col1.setHalignment(HPos.LEFT);
        col1.setPercentWidth(90);
        
        rootLayout.getColumnConstraints().addAll(col0, col1);
        rootLayout.setAlignment(Pos.CENTER);
    }
    
    /**Заполняем значениями конкретный элемент карты со значениями*/
    private void fillConcreteSetValue(int setNum, final ResourceBundle lang) {
        int set_size = this.setSize.get(setNum);
        String[] data = new String[set_size];
        for (int i = 0; i < set_size; i++) {
            data[i] = lang.getString("Test.p9.set"+String.valueOf(setNum)+"."+ String.valueOf(i+1));  
        }
        this.setValue.remove(setNum);
        this.setValue.put(setNum, data);
    }
    
    /**Заполняем всю карту со значениями*/
    private void fillSetValues(final ResourceBundle lang) {
        setValue = new HashMap();
        for (int i = 1; i < 13; i++) {
            fillConcreteSetValue(i, lang);
        }
    }
    
    /**Заполяем карту с размерами*/
    private void fillSetSize() {
        setSize = new HashMap();
        setSize.put(1, 3);          setSize.put(7, 3);
        setSize.put(2, 3);          setSize.put(8, 3);
        setSize.put(3, 4);          setSize.put(9, 3);
        setSize.put(4, 2);          setSize.put(10, 3);
        setSize.put(5, 2);          setSize.put(11, 4);
        setSize.put(6, 3);          setSize.put(12, 3);
    }
    
    /**Заполняем Choice-box'ы и реализуем их функциональность*/
    private void fillChoiceBoxes(final TestSystemGenerator sg) {
        chBox = new HashMap();
        String [] prevSelectedValues = sg.getPageData(8);
        for (int i = 1; i < 13; i++) {
            ChoiceBox ch = new ChoiceBox();
            final int chBoxNumber = i;
            String [] data = this.setValue.get(chBoxNumber);
            ch.setItems(FXCollections.observableArrayList(data));   
            ch.getSelectionModel().select(Integer.parseInt(prevSelectedValues[i-1]));
            setCurrentSelectedValue(chBoxNumber, Integer.parseInt(prevSelectedValues[i-1]));
            ch.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue ov, Number value, Number newValue) {
                    setCurrentSelectedValue(chBoxNumber, newValue.intValue());
                }
            });
            ch.setPrefWidth(1000);
            chBox.put(i, ch);
        }   
    }
    
    /**Создаем HashMap для хранения выбранных в данный момент данных 
     * в Choice-Box'ах*/
    private void createCurrentSelectedValues() {
        this.currentSelectedValue = new HashMap();
        for (int i = 1; i < 13; i++) {
            currentSelectedValue.put(i, -1);
        }
    }
    
    /**Изменяем текущее выбранное значение в конкретном Choice-Box'е*/
    private void setCurrentSelectedValue(int number, int value) {
        this.currentSelectedValue.remove(number);
        this.currentSelectedValue.put(number, value);
    }
    
    /** @return интерфейс 9й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg)  {
        try {
            saveData(sg);
            sg.checkPage(8);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.saveStud_p8(currentSelectedValue);
    }
}
