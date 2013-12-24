/*
 * Набор подсказок для студентов
 * включает список необходимых для решения задач формул в формате MathML
 */
package DiffModesCommon;

import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;

/**
 * @author Radeon
 */
public class PromptSet {
    
    public static String getPrompt(String param, ResourceBundle lang) {
        String webContent = ""; //<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
        //CCFF00
        switch (param) {
            case "formula_Fs":
                webContent+=formula_Fs(lang);
                break;
            case "formula_sqEquation":
                webContent+=formula_sqEquation(lang);
                break;
            case "formula_T1_T2":
                webContent+=formula_T1_T2(lang);
                break;
            case "formula_Fs_t1t2":
                webContent+=formula_Fs_t1t2(lang);
                break;
            case "replacementSjw":
                webContent+=replacementSjw(lang);
                break;
            case "abridgedMulFormula":
                webContent+=abridgedMulFormula(lang);
                break;
            case "formula_Aw":
                webContent+=formula_Aw(lang);
                break;
            case "formula_passband":
                webContent+=formula_passband(lang);
                break;
            default:
                throw new AssertionError();
        }
        return webContent; 
    }
    
    /**@return подсказку для вычисления передаточной функции Ф(s)
     замкнутой системы по задающему воздействию */
    private static String formula_Fs(ResourceBundle lang) {
         return "<font face=\"" + AppStyles.readingFont()
                 + "\" color=\"" + AppStyles.infoBlueColor()
                 + "\"><p align=\"center\">" 
                 + lang.getString("PromptSet.formulaFS")
                 + "</p></font>"
                + "<p align=\"center\">" 
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi><mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mi>"
                    + lang.getString("PromptSet.formFsOut")
                    + "</mi></msub>"
                    + "<mfenced><mi>s</mi>"
                    + "</mfenced></mrow><mrow>"
                    + "<msub><mi>Y</mi><mi>"
                    + lang.getString("PromptSet.formFsInp")
                    + "</mi></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac><mrow>"
                    + "<mi>W</mi><mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mn>1</mn><mo>+</mo>"
                    + "<mi>W</mi><mfenced><mi>s</mi></mfenced>"
                    + "<mo>&#x2219</mo>"
                    + "<msub><mi>W</mi><mi>"
                    + lang.getString("PromptSet.formFsOC")
                    + "</mi></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                + "</mrow></mfrac></mrow></math></p>";
    }

    /**@return формулу для решения квадратного уравнения */
    private static String formula_sqEquation(ResourceBundle lang) {
        return "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">" 
               + lang.getString("PromptSet.formulaSqEquation")
               + "</p></font>" +
               "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                // D
                    + "<mrow><mi>D</mi><mo>=</mo>"
                    + "<msup><mi>b</mi><mn>2</mn></msup>"
                    + "<mo>+</mo><mn>4</mn>"
                    + "<mi>a</mi><mi>c</mi>"
                    + "</mrow></math>;"
               // s1
               + "<br><br><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>s</mi><mn>1</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                        + "<mo>-</mo><mi>b</mi><mo>-</mo>"
                        + "<msqrt><mi>D</mi></msqrt>"
                    + "</mrow><mrow>"
                        + "<mn>2</mn><mi>a</mi>"
                    + "</mrow></mfrac>"
                    + "</mrow></math>;"
               // s2
               +"<br><br><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>s</mi><mn>2</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                        + "<mo>-</mo><mi>b</mi><mo>+</mo>"
                        + "<msqrt><mi>D</mi></msqrt>"
                    + "</mrow><mrow>"
                        + "<mn>2</mn><mi>a</mi>"
                    + "</mrow></mfrac>"
                    + "</mrow></math>.</p>";
    }

    /**@return формулу для вычисления постоянных времени Т1 и Т2*/
    private static String formula_T1_T2(ResourceBundle lang) {
        return "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">" 
               + lang.getString("PromptSet.formulaT1T2")
               + "</p></font>"+
               "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                // T1
                    + "<mrow><msub><mi>T</mi><mn>1</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<mn>1</mn>"
                    + "</mrow><mrow>"
                    + "<mfenced separators=\"\" open=\"|\" close=\"|\">"
                    + "<msub><mi>s</mi><mn>1</mn></msub></mfenced>"
                    + "</mrow></mfrac></mrow></math>;\t"
                // T2
                + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>T</mi><mn>2</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<mn>1</mn>"
                    + "</mrow><mrow>"
                    + "<mfenced separators=\"\" open=\"|\" close=\"|\">"
                    + "<msub><mi>s</mi><mn>2</mn></msub></mfenced>"
                    + "</mrow></mfrac></mrow></math>.</p>";
    }

    /**@return подсказку для представления передаточной функции 
     с помощью постоянных времени Т1 и Т2*/
    private static String formula_Fs_t1t2(ResourceBundle lang) {
        return "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">" 
                + lang.getString("PromptSet.formulaFst1t2")
                + "</p></font>"
                + "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mi>"
                    + lang.getString("PromptSet.formFsOut")
                    + "</mi></msub>"
                    + "<mfenced><mi>s</mi>"
                    + "</mfenced></mrow><mrow>"
                    + "<msub><mi>Y</mi><mi>"
                    + lang.getString("PromptSet.formFsInp")
                    + "</mi></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac><mrow>"
                    + "<mi>k</mi>"
                    + "</mrow><mrow>"
                    + "<mfenced><mrow>"
                    + "<msub><mi>T</mi><mn>1</mn></msub>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>s</mi><mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<msub><mi>T</mi><mn>2</mn></msub>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>s</mi><mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    +"</mrow></mfrac></mrow></math></p>";
    }

    /**@return подсказку о необходимости замены s->jw 
     при получении частотной передаточной функции*/
    private static String replacementSjw(ResourceBundle lang) {
        return  "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">"
                + lang.getString("PromptSet.replacementSjw")
                + "</p></font>" +
                "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>s</mi>"
                    + "<mo>&#x2192</mo>"
                    + "<mi>j</mi><mi>&#x03C9</mi>"
                    +"</mrow></math></p>";
    }

    /**@return формулу сокращенного умножения
     a^2 + b^2 = (a+b)*(a-b) */
    private static String abridgedMulFormula(ResourceBundle lang) {
        return  "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">"
                + lang.getString("PromptSet.abridgedMulFormula")
                + "</p></font>"+
                "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msup><mi>a</mi><mn>2</mn></msup>"
                        + "<mo>-</mo>"
                        + "<msup><mi>b</mi><mn>2</mn></msup>"
                        + "<mo>=</mo>"
                        + "<mfenced><mrow>"
                        + "<mi>a</mi><mo>+</mo><mi>b</mi>"
                        + "</mrow></mfenced>"
                        + "<mfenced><mrow>"
                        + "<mi>a</mi><mo>-</mo><mi>b</mi>"
                        + "</mrow></mfenced>"
                    +"</mrow></math>"
                + "<br><br><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>j</mi>"
                    + "<mtext>"
                    + lang.getString("PromptSet.imaginaryUnit")
                    +"</mtext>"
                    +"</mrow></math>"
                + "<br><br><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msup><mi>j</mi><mn>2</mn></msup>"
                        + "<mo>=-</mo>"
                        + "<mn>1</mn>"
                    +"</mrow></math></p>";
    }

    /**@return формулу вычисления функции АЧХ*/
    private static String formula_Aw (ResourceBundle lang) {
        return  "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">"
                + lang.getString("PromptSet.formulaAw")
                + "</p></font>"+
                "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>A</mi>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    + "<mo>=</mo><msqrt><mrow>"
                    + "<msup><mi>U</mi><mn>2</mn></msup>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    + "<mo>+</mo>"
                    + "<msup><mi>V</mi><mn>2</mn></msup>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    +"</mrow></msqrt></mrow></math></p>";
    }

    /**@return формулу вычисления полосы пропускания*/
    private static String formula_passband(ResourceBundle lang) {
        return  "<font face=\"" + AppStyles.readingFont()
               + "\" color=\"" + AppStyles.infoBlueColor()
               + "\"><p align=\"center\">"
                + lang.getString("PromptSet.formulaPassband")
                + "</p></font>"+
                "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>A</mi>"
                    + "<mfenced><msub><mi>&#x03C9</mi>"
                    + "<mi>"
                    + lang.getString("PromptSet.pbSup")
                    + "</mi></msub></mfenced>"
                    + "<mo>=</mo><mn>0.707</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>A</mi><mfenced><mn>0</mn></mfenced>"
                    + "</mrow></math></p>";
    }

    /**@return формулу для вычисления передаточной функции системы
     с помощью передаточных функций блоков*/
    public static String fsEquation() {
        return "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mi>G</mi><mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac><mrow>"
                    + "<msub><mi>W</mi><mn>1</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>2</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>3</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mn>1</mn><mo>+</mo>"
                    + "<msub><mi>W</mi><mn>1</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>2</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>3</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<msub><mi>W</mi><mn>6</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac></math>";
    }
    
    /**Помещает выбранную подсказку по указанному "адресу" в сетке
     * @param lang Переводчик
     * @param ctrl класс контроля за обучением с тренером
     * @param promptName название подсказки, 
     * которую необходимо поместить в указанное место
     * @param pane сетка, в которую необходимо поместить подсказку
     * @param i1 столбец
     * @param i2 строка
     * @param i3 на сколько столбцов растянуть
     * @param i4 на сколько строк растянуть */
    public static void putPrompt(ResourceBundle lang, TrainerControl ctrl, 
            String promptName, GridPane pane, int i1, int i2, int i3, int i4) {
        String prompt = PromptSet.getPrompt(promptName, lang);
        WebView promptView = new WebView();
        promptView.getEngine().loadContent(prompt);
        promptView.setContextMenuEnabled(false);        
        pane.add(promptView, i1, i2, i3, i4);       //на ее место вставляем подсказку
        ctrl.useHint(promptName);                   //делаем пометку, что студент увидел формулу
    }
}
