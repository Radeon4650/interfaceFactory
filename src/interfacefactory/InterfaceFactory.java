package interfacefactory;

import DemoPack.DemoInterface;
import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Wd;
import DiffModesCommon.DataModel.Wk;
import StartDialogs.FXOptionPane;
import StartDialogs.Server1;
import TestPack.TestInterface;
import TrainerPack.TrainerInterface;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Radeon
 */
public class InterfaceFactory extends Application {
    /**@param lang набор ресурсов для локализации*/
    private ResourceBundle lang;
    private final int port= 12671;
    private Scene scene;
    final StackPane root = new StackPane();

    @Override
    public void init() throws Exception {
        super.init(); 
        BayesianNetwork.BayesianNetwork.check_OS();
    }
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException {    
        
             //-------Проверка открытия нескольких приложений одновременно----------------
         Server1 myServer=new Server1(port);
       final Thread myThread=new Thread(myServer);
        try {
        myThread.start();
        Thread.sleep(300);
        myServer.isStart();
        //--------Локализация--------------------
        // Для выбора языка необходимо при запуске передать программе 
        // параметр lang со значением текущей локали (ru, ua, en)
                chooseLang(FXOptionPane.showStartDialog(primaryStage, "Выберите язык:", "Вход").toString());
        } catch (IOException ex) {
                        FXOptionPane.showMessageDialog(primaryStage, "Обучающая программа уже запущена!", "Действие отменено");
            Logger.getLogger(InterfaceFactory.class.getName()).log(Level.SEVERE, null, ex);
            myThread.interrupt();
            System.exit(13);
        }
       
     //-------Close MAIN Window---------------------------
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        myThread.interrupt();
        System.exit(12);
    }
        });
    //---------GUI---------------------------
        loadFonts();
        root.setStyle(AppStyles.mainStageRootStyle());
        
        loadInitialInterface();
        
        scene = new Scene(root, 1010, 650);
        
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
    
    private void loadFonts() {
        Font.loadFont(InterfaceFactory.class.getResource("Lobster.ttf").toExternalForm(), 10);
        Font.loadFont(InterfaceFactory.class.getResource("Aver.ttf").toExternalForm(), 10);
        Font.loadFont(InterfaceFactory.class.getResource("Idealist Sans Light.ttf").toExternalForm(), 10);
    }
    
    /**@return выбор языка для приложения*/
    private void chooseLang(String locale) {
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

    /**загружает интерфейс демо-режима с автоматически созданным условием задачи*/
    public void loadDemoInterface() {
        DemoInterface demo = new DemoInterface(lang, this);
        root.getChildren().clear();
        root.getChildren().add(demo.getdInterface());
    }
    
    /**загружает интерфейс демо-режима с введенным пользователем условием задачи
     * @param wk1 передаточная функция простейшего структурного блока (#1 на схеме)
     * @param wk2 передаточная функция простейшего структурного блока (#2 на схеме)
     * @param wd3 передаточная функция структурного блока 2го порядка (#3 на схеме)
     * @param wd4 передаточная функция структурного блока 2го порядка (#4 на схеме)
     * @param wk5 передаточная функция простейшего структурного блока (#5 на схеме)
     * @param wk6 передаточная функция простейшего структурного блока (#6 на схеме)
     */
    public void loadDemoInterface(Wk wk1, Wk wk2, Wd wd3, Wd wd4, Wk wk5, Wk wk6) {
        DemoInterface demo = new DemoInterface(lang, this, wk1, wk2, wd3, wd4, wk5, wk6);
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
