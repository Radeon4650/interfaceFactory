

package DiffModesCommon;

import javafx.scene.control.TextField;

/**
 * Стили для различных элементов графического интерфейса приложения
 * @author radeon
 */
public class AppStyles {
    //info gamma
    static private final String wrongRed = "FF0066";
    static private final String rightGreen = "009966";
    static private final String infoBlue = "336699";
    
    //neutral app gamma
    static private final String gray = "99CC99";
    static private final String black = "000000";
    static private final String red = "CC3300";
    
    static private final String tableTopicClr = "CCFF99";
    static private final String tableLinesClr = "FFCCCC";
//    static private final String rootClr = "CCFFCC";
    static private final String rootClr = "FFFFFF";
    
    static private final String titleFont = "Lobster";
    static private final String originalFont = "Idealist Sans";
    static private final String readingFont = "Aver";
    
    
    static public String titleFont() {
        return titleFont;
    }
    
    static public String originalFont() {
        return originalFont;
    }
    
    static public String readingFont() {
        return readingFont;
    }
    
    /**@return численное представление [синего] цвета, для выделения информационных данных*/
    static public String infoBlueColor() {
        return infoBlue;
    }
    
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
    
    static public String titleFontStyle() {
        return "-fx-font-family: "
                + titleFont() + ";"
                + "-fx-font-size: 20;";
    }
    
    static public String originalFontStyle() {
        return "-fx-font-family: \'"
                + originalFont() + "\';"
                + "-fx-font-size: 16;";
    }
    
    static public String readingFontStyle() {
        return "-fx-font-family: \'"
                + readingFont() + "\';"
                + "-fx-font-size: 16;";
    }
    
    
    /**Устанавливает стиль для поля ввода коэффициентов:
     * символы становятся красными, если введеноое значение не является числом
     * @param tf поле ввода, к которому применяется стиль
     */
    static public void styleSetter (final TextField tf) {
        final String wrongTextInputStyle = AppStyles.testWrongTextFieldInputStyle();
        final String rightTextInputStyle = AppStyles.testRightTextFieldInputStyle();
        
        try {
            Double.parseDouble(tf.getText());
            tf.setStyle(rightTextInputStyle);
            }
        catch (NumberFormatException ex) {
            tf.setStyle(wrongTextInputStyle);
        }
    }
}
