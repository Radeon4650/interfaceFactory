/*
 * Набор подсказок для студентов
 * включает список необходимых для решения задач формул в формате MathML
 */
package interfacefactory;

import javafx.scene.web.WebView;

/**
 * @author Radeon
 */
public class PromptSet {
    
    public static WebView getPrompt(String param) {
        String webContent = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
        //CCFF00
        switch (param) {
            case "formula_Fs":
                webContent+=formula_Fs();
                break;
            case "formula_sqEquation":
                webContent+=formula_sqEquation();
                break;
            case "formula_T1_T2":
                webContent+=formula_T1_T2();
                break;
            case "formula_Fs_t1t2":
                webContent+=formula_Fs_t1t2();
                break;
            case "replacementSjw":
                webContent+=replacementSjw();
                break;
            case "abridgedMulFormula":
                webContent+=abridgedMulFormula();
                break;
            case "formula_Aw":
                webContent+=formula_Aw();
                break;
            case "formula_passband":
                webContent+=formula_passband();
                break;
            default:
                throw new AssertionError();
        }
        WebView webView = new WebView();
        webView.getEngine().loadContent(webContent);
        return webView; 
    }
    
    /**@return подсказку для вычисления передаточной функции Ф(s)
     замкнутой системы по задающему воздействию */
    public static String formula_Fs() {
         return "<p align=\"center\">Формула для вычисления передаточной функции "
                + "замкнутой системы по задающему воздействию:</p>"
                + "<p align=\"center\">" 
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi><mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mi>out</mi></msub>"
                    + "<mfenced><mi>s</mi>"
                    + "</mfenced></mrow><mrow>"
                    + "<msub><mi>Y</mi><mi>inp</mi></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac><mrow>"
                    + "<mi>W</mi><mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mn>1</mn><mo>+</mo>"
                    + "<mi>W</mi><mfenced><mi>s</mi></mfenced>"
                    + "<mo>&#x2219</mo>"
                    + "<msub><mi>W</mi><mi>OC</mi></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                + "</mrow></mfrac></mrow></math></p>";
    }

    /**@return формулу для решения квадратного уравнения */
    public static String formula_sqEquation() {
        return "<p align=\"center\">Решение квадратных уравнений:</p>"+
               "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                // D
                    + "<mrow><mi>D</mi><mo>=</mo>"
                    + "<msup><mi>b</mi><mn>2</mn></msup>"
                    + "<mo>+</mo><mn>4</mn>"
                    + "<mi>a</mi><mi>c</mi>"
                    + "</mrow></math>"
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
                    + "</mrow></math>"
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
                    + "</mrow></math></p>";
    }

    /**@return формулу для вычисления постоянных времени Т1 и Т2*/
    public static String formula_T1_T2() {
        return "<p align=\"center\">Получение постоянных времени:</p>"+
               "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                // T1
                    + "<mrow><msub><mi>T</mi><mn>1</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<mn>1</mn>"
                    + "</mrow><mrow>"
                    + "<mfenced separators=\"\" open=\"|\" close=\"|\">"
                    + "<msub><mi>s</mi><mn>1</mn></msub></mfenced>"
                    + "</mrow></mfrac></mrow></math>"
                // T2
                + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>T</mi><mn>2</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<mn>1</mn>"
                    + "</mrow><mrow>"
                    + "<mfenced separators=\"\" open=\"|\" close=\"|\">"
                    + "<msub><mi>s</mi><mn>2</mn></msub></mfenced>"
                    + "</mrow></mfrac></mrow></math></p>";
    }

    /**@return подсказку для представления передаточной функции 
     с помощью постоянных времени Т1 и Т2*/
    public static String formula_Fs_t1t2() {
        return "<p align=\"center\">Необходимо представить передаточную функцию в виде:</p>"
                + "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
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
    public static String replacementSjw() {
        return  "<p align=\"center\">Производим замену:</p>" +
                "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>s</mi>"
                    + "<mo>&#x2192</mo>"
                    + "<mi>j<mi><mi>&#x03C9</mi>"
                    +"</mrow></math></p>";
    }

    /**@return формулу сокращенного умножения
     a^2 + b^2 = (a+b)*(a-b) */
    public static String abridgedMulFormula() {
        return  "<p align=\"center\">Формула сокращенного умножения:</p>"+
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
                    + "<mrow><mi>j<mi>"
                    + "<mtext> - мнимая единица</mtext>"
                    +"</mrow></math>"
                + "<br><br><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msup><mi>j</mi><mn>2</mn></msup>"
                        + "<mo>=-</mo>"
                        + "<mn>1</mn>"
                    +"</mrow></math></p>";
    }

    /**@return формулу вычисления функции АЧХ*/
    public static String formula_Aw () {
        return  "<p align=\"center\">Формула для вычисления функции АЧХ:</p>"+
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
    public static String formula_passband() {
        return  "<p align=\"center\">Формула вычисления полосы пропускания системы:</p>"+
                "<p align=\"center\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>A</mi>"
                    + "<mfenced><msub><mi>&#x03C9</mi>"
                    + "<mi>пр</mi></msub></mfenced>"
                    + "<mo>=</mo><mn>0.707</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>A</mi><mfenced><mn>0</mn></mfenced>"
                    + "</mrow></math></p>";
    }
}
