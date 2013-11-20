package interfacefactory;

import DemoPack.DemoInterface;
import TestPack.TestInterface;
import TrainerPack.TrainerInterface;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Radeon
 */
public class InterfaceFactory extends Application {
    /**@param lang набор ресурсов для локализации*/
    private ResourceBundle lang;
    final StackPane root = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {    
        
    //--------Локализация--------------------
    // Для выбора языка необходимо при запуске передать программе 
    // параметр lang со значением текущей локали (ru, ua, en)
        chooseLang(getParameters());
    //---------------------------------------

        
    //---------GUI---------------------------
        root.setStyle("-fx-background-color: #ffeba7;");
        
        loadInitialInterface();
        
        Scene scene = new Scene(root, 1010, 650);
        
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setTitle(lang.getString("applicationTitle"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    /** @return текущий набор соответствий ключ=строка для локализации приложения 
     для определенного языка пользователя */
    public ResourceBundle getLang() {
        return lang;
    }

    /** @param rb the lang to set */
    private void setLang(ResourceBundle rb) {
        this.lang = rb;
    }
    
    /**@return выбор языка для приложения*/
    private void chooseLang(Parameters parameters) {
        String locale = (parameters.getNamed().get("lang") == null?"":parameters.getNamed().get("lang"));
        switch (locale) {
            case ("en"):    //English
            case ("EN"): 
                setLang(ResourceBundle.getBundle("lang.lang", new Locale("en", "EN")));
                break;
            case "ru":      //Russian
            case "RU":
                setLang(ResourceBundle.getBundle("lang.lang", new Locale("ru", "RU")));
                break;
            case "ua":      //Ukrainian
            case "UA":
                setLang(ResourceBundle.getBundle("lang.lang", new Locale("ua", "UA")));
                break;
            default:        //Russian is the default language of application
                setLang(ResourceBundle.getBundle("lang.lang", new Locale("ru", "RU")));
        }
    }

    /**загружает интерфейс демо-режима*/
    public void loadDemoInterface() {
        DemoInterface demo = new DemoInterface(lang, this);
        root.getChildren().clear();
        root.getChildren().add(demo.getdInterface());
    }
    
    /**загружает интерфейс режима Тренер*/
    public void loadTrainerInterface() {
        TrainerInterface trainer = new TrainerInterface(lang, this);
        root.getChildren().clear();
        root.getChildren().add(trainer.gettInterface());
    }
    
    /**загружает интерфейс режима Тест*/
    public void loadTestInterface() {
        TestInterface test = new TestInterface(lang, this);
        root.getChildren().clear();
        root.getChildren().add(test.gettInterface());
    }

    /**загружает форму выбора режима работы*/
    public void loadInitialInterface() {
        ModeSelectionInterface msIf = new ModeSelectionInterface(lang, this);
        root.getChildren().clear();
        root.getChildren().add(msIf.getMsInterface());
    }
}
