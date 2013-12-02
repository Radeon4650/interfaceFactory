

package DiffModesCommon;

/**
 * Стили для различных элементов графического интерфейса приложения
 * @author radeon
 */
public class AppStyles {
    //info gamma
    static private final String wrongRed = "FF0066";
    static private final String rightGreen = "009966";
    
    //neutral app gamma
    static private final String gray = "99CC99";
    static private final String black = "000000";
    static private final String red = "CC3300";
    
    static private final String tableTopicClr = "CCFF99";
    static private final String tableLinesClr = "FFCCCC";
    static private final String rootClr = "CCFFCC";
    
    
    /**@return численное представление [красного] цвета, обозначающего ошибочный ввод данных*/
    static public String wrongRedColor() {
        return wrongRed;
    }
    
    /**@return численное представление [зеленого] цвета, обозначающего верный ввод данных*/
    static public String rightGreenColor() {
        return rightGreen;
    }
    
    /**@return численное представление цвета для шапки таблицы стр.7 режима Демо*/
    static public String demoTableTopicColor() {
        return tableTopicClr;
    }
    
    /**@return численное представление цвета для линий таблицы стр.7 режима Демо*/
    static public String demoTableLinesColor() {
        return tableLinesClr;
    }
    
    /**@return стиль для текстового поля, в которое введена некорректная информация*/
    static public String testWrongTextFieldInputStyle() {
        return "-fx-text-fill: #" + wrongRedColor() + ";"
            + "-fx-prompt-text-fill: #" + gray + ";"         
            + "-fx-highlight-fill: #" + red + ";";
    }
    
    /**@return стиль для текстового поля, в которое введена адекватная информация*/
    static public String testRightTextFieldInputStyle() {
        return "-fx-text-fill: #" + black + ";"               
            + "-fx-prompt-text-fill: #" + gray + ";"         
            + "-fx-highlight-fill: #" + rightGreenColor() + ";";
    }

    /**@return стиль для корневого узла интерфейса приложения*/
    static public String mainStageRootStyle() {
        return "-fx-background-color: #"+ rootClr +";";
    }
    
    /**@return стиль текстового сообщения об ошибке*/
    static public String errorLblStyle() {
        return "-fx-text-fill: #" + wrongRedColor() + ";"
             + "-fx-wrap-text: true;"
             + "-fx-text-alignment: center;";
    }
}
