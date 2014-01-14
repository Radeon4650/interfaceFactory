

package TestPack;

import DiffModesCommon.AppStyles;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */
public class TestPassingUnit {
    private int demoWatching;
    private int score;
    private final double autoPrecision = 0.01; 
    
    private final Map<String, Boolean> p0Passed;
    private final Map<String, Boolean> p1Passed;
    private final Map<String, Boolean> p2Passed;
    private final Map<String, Boolean> p3Passed;
    private final Map<String, Boolean> p4Passed;
    private final Map<String, Boolean> p5Passed;
    private final Map<String, Boolean> p6Passed;
//    private final Map<String, Boolean> p7Passed;
    private final Map<String, Boolean> p8Passed;
    
    
    private double precision;     // точность совпадения решения студента и данных, вычисленных автоматически

    /**@param calcPrecision точность совпадения решения студента и данных, вычисленных автоматически*/
    public TestPassingUnit(double calcPrecision) {
        demoWatching = 0;
        score = 0;
        
        p0Passed = new HashMap();
        p1Passed = new HashMap();
        p2Passed = new HashMap();
        p3Passed = new HashMap();
        p4Passed = new HashMap();
        p5Passed = new HashMap();
        p6Passed = new HashMap();
//        p7Passed = new HashMap();
        p8Passed = new HashMap();
        
    // page 0
        p0Passed.put("k", false);        // верный коэффициент k в Ф(s)
        p0Passed.put("a", false);        // верный коэффициент a в Ф(s)
        p0Passed.put("b", false);        // верный коэффициент b в Ф(s)
        p0Passed.put("c", false);        // верный коэффициент c в Ф(s)
    // page 1
        p1Passed.put("a", false);        // верный коэффициент a в характеристическом уравнении
        p1Passed.put("b", false);        // верный коэффициент b в характеристическом уравнении
        p1Passed.put("c", false);        // верный коэффициент c в характеристическом уравнении
        p1Passed.put("D", false);        // верно посчитан дискриминант характеристического уравнения
        p1Passed.put("s1", false);       // верно посчитан корень s1 характеристического уравнения
        p1Passed.put("s2", false);       // верно посчитан корень s2 характеристического уравнения
        p1Passed.put("T1", false);       // верно посчитана постоянная времени Т1
        p1Passed.put("T2", false);       // верно посчитана постоянная времени Т2
    // page 2
        p2Passed.put("k", false);        // верно введен коэффициент k на странице 3
        p2Passed.put("T1", false);       // верно введена постоянная времени Т1 на странице 3
        p2Passed.put("T2", false);       // верно введена постоянная времени Т2 на странице 3
        p2Passed.put("rep", false);      // верно введены данные для замены s→jω
    // page 3
        p3Passed.put("k", false);        // верно введен коэффициент k на странице 4
        p3Passed.put("mU", false);       // верно введен коэффициент mU на странице 4
        p3Passed.put("nU", false);       // верно введен коэффициент nU на странице 4
        p3Passed.put("mV", false);       // верно введен коэффициент mV на странице 4
        p3Passed.put("nV", false);       // верно введен коэффициент nV на странице 4
        p3Passed.put("h", false);        // верно введен коэффициент h на странице 4
        p3Passed.put("e", false);        // верно введен коэффициент e на странице 4
        p3Passed.put("x1", false);       // верно введен коэффициент x1 на странице 4
        p3Passed.put("x2", false);       // верно введен коэффициент x2 на странице 4
        p3Passed.put("x3", false);       // верно введен коэффициент x3 на странице 4
        p3Passed.put("x4", false);       // верно введен коэффициент x4 на странице 4
    // page 4
        p4Passed.put("k", false);       // верно введен коэффициент k для A(w) на странице 5
        p4Passed.put("m", false);       // верно введен коэффициент m для A(w) на странице 5
        p4Passed.put("n", false);       // верно введен коэффициент n для A(w) на странице 5
        
    // page 5
        p5Passed.put("Apb", false);
        p5Passed.put("wpb", false);
    // page 6
        p6Passed.put("Uw", false);
        p6Passed.put("Vw", false);
    // page 7
        //not used yet
    // page 8
        for (int i = 1; i < 13; i++) {      //Верно ли выбраны варианты ответа на странице 9
            p8Passed.put(String.valueOf(i), false);
        }
        
        
        if (calcPrecision>0)
            precision = calcPrecision;
        else precision = autoPrecision;
    }
    
    private void setPrecision(double prec) {
        this.precision = prec;
    }
    
//----------------- Проверки ---------------------------------------------------
/** Общая проверка-сравнение коэффицентов
     * @return true, если студент ввел число, и оно совпадает с автоматически 
     * посчитанным значением в пределах точности precision;
     * false, если число введено не было, или введенное значение не совпадает 
     * с автоматически посчитанным значением в пределах точности precision;
     * @param autoVal автоматически посчитанное значение
     * @param studVal значение, полученное от студента */
    private boolean checkDoubleValues(double autoVal, double studVal) {
        if (studVal != TestSystemGenerator.getUnwrittedValue())
            return Math.abs(autoVal-studVal)<=precision;
        else return false;
    }
    
    /**Если пользователь слишком часто подглядывает в режим "Демо",
     * его нужно наказывать */
    public void watchDemo() {
        this.demoWatching++;
        this.decreaseScore(10);
    }
    
    /**Если пользователь слишком часто подглядывает в подсказки,
     * его нужно наказывать */
    public void watchHint() {
        this.decreaseScore(2);
    }
    
    /**Установить значение
     * @param pageNumber номер страницы
     * @param key ключ карты
     * @param value значение, которое необходимо поместить  */
    private void setValue(int pageNumber, String key, boolean value) {
        getPassed(pageNumber).remove(key);
        getPassed(pageNumber).put(key, value);
    }
    
    /*** @return результат сравнения двух чисел: 
     * автоматически вычисленного и введенного студентом
     * @param pageNumber номер страницы
     * @param key ключ карты
     * @param autoVal автоматически посчитанное значение
     * @param studVal значение, полученное от студента 
     * @param precision точность совпадения чисел для определения правильности решения*/
    public boolean checkValues(int pageNumber, String key, double autoVal, double studVal, double precision) {
        setPrecision(precision);
        boolean checkResult = checkDoubleValues(autoVal, studVal);
        setValue(pageNumber, key, checkResult);
        return checkResult;
    }
    
    /**Для тех мест, где возникают спорные вопросы о том, кто не прав и что делать*/
    public boolean[] checkDeniable(int pageNumber, String key1, String key2,
            double autoVal1, double autoVal2, double studVal1, double studVal2, double precision) {
        
        boolean[] results = new boolean[2];
        setPrecision(precision);
        
        boolean A, B, C, D;
        A = checkDoubleValues(autoVal1, studVal1);
        B = checkDoubleValues(autoVal1, studVal2);
        C = checkDoubleValues(autoVal2, studVal1);
        D = checkDoubleValues(autoVal2, studVal2);
        
        if ((A&D)|(B&C)) {
            results[0] = true; 
            results[1] = true;
        }
        else {   
            if ((A|C)) {
                results[0] = true;
                results[1] = false;
            }
            else {
                results[0] = false;
                results[1] = B|D;
            }
        }
        setValue(pageNumber, key1, results[0]);
        setValue(pageNumber, key2, results[1]);
        return results;
    }
    
    /**@return результат сравнения двух строк: 
     * необходимой и введенной студентом
     * @param pageNumber номер страницы
     * @param key ключ карты
     * @param autoVal автоматически посчитанное значение
     * @param studVal значение, полученное от студента */
    public boolean checkValues(int pageNumber, String key, String autoVal, String studVal) {
        boolean checkResult = autoVal.equals(studVal);
        setValue(pageNumber, key, checkResult);
        return checkResult;
    }
    
    /**Проверка правильности действительной частотной функции, 
     * выводимой на странице 6[7]*/
    public boolean checkUw_p6() {
        boolean checkResult = p3Passed.get("k") & p3Passed.get("h") 
                & p3Passed.get("mU") & p3Passed.get("nU");
        setValue(6, "Uw", checkResult);
        return checkResult;
    }
    
    /**Проверка правильности мнимой частотной функции, 
     * выводимой на странице 6[7]*/
    public boolean checkVw_p6() {
        boolean checkResult = p3Passed.get("e") 
                & p3Passed.get("mV") & p3Passed.get("nV");
        setValue(6, "Vw", checkResult);
        return checkResult;
    }
    
    
//----------------- Результаты -------------------------------------------------    
    /**@return результат прохождения тестов конкретной страницы
     * @param pageNumber номер страницы */
    private String pageResults(int pageNumber, final ResourceBundle lang) {
        String passed = "<font color=\"" + AppStyles.rightGreenColor()
                + "\">" + lang.getString("TPU.passed") + "</font>";
        String failed = "<font color=\"" + AppStyles.wrongRedColor()
                + "\">" + lang.getString("TPU.failed") + "</font>";
        
        String results = "<font face=\""
                + AppStyles.titleFont()
                + "\" color=\"" + AppStyles.infoBlueColor()
                + "\"><i>" + lang.getString("TPU.page") 
                + String.valueOf(pageNumber+1) + ":</i></font><br>";
        if (pageNumber==7) {
            results += "<font face=\"" + AppStyles.readingFont()
                    + "\">" + lang.getString("TPU.p7_chart") + passed + ".</font><br>";
        }
        else for(String key : getPassed(pageNumber).keySet()) {
            results += "<font face=\"" + AppStyles.readingFont() + "\">" 
                + lang.getString("TPU.p"+String.valueOf(pageNumber)+"_"+key)
                + (getPassed(pageNumber).get(key) ? passed : failed )
                + ".</font><br>";
        }
        
        return results;
    }
    
    private String watchDemoResults (final ResourceBundle lang) {
        if (this.demoWatching>0) 
            return "<p>" + lang.getString("TPU.watchDemo")
                + String.valueOf(this.demoWatching)
                + ".</p>";
        return "";
    }
    
    
    /**@return HTML-строку с подробным сообщением о результатах прохождения теста */
    public String checkResults(final ResourceBundle lang) {
        
        return "<html><body><h2 align=\"center\"><font face=\""
                + AppStyles.titleFont() + "\">"
                + lang.getString("TPU.results")
                + "</font></h2>"
                + pageResults(0, lang)
                + pageResults(1, lang)
                + pageResults(2, lang)
                + pageResults(3, lang)
                + pageResults(4, lang)
                + pageResults(5, lang)
                + pageResults(6, lang)
                + pageResults(7, lang)
                + pageResults(8, lang)
                + watchDemoResults(lang)
                + "</body></html>";
    }

    
//------------------- Оценки ---------------------------------------------------
    
    /** @return текущие баллы    */
    public int getScore() {
        return score;
    }

    /**@param score установить значение баллов (оценку)  */
    public void setScore(int score) {
        this.score = score;
    }
    
    /** Увеличение оценки (количества баллов)
     * @param value на сколько увеличить оценку */
    public void increaseScore(int value) {
        this.score = getScore() + value;
    }
    
    /** Уменьшение оценки (количества баллов)
     * @param value на сколько уменьшить оценку */
    public void decreaseScore(int value) {
        this.score = getScore() - value;
        if (score<0) score = 0;
    }

    
//----------------- Getter'ы ---------------------------------------------------    

    /**@return правильно ли введены данные на странице 1 [0]. */
    private Map<String, Boolean> getP0Passed() {
        return p0Passed;
    }

    /**@return правильно ли введены данные на странице 2 [1]. */
    private Map<String, Boolean> getP1Passed() {
        return p1Passed;
    }

    /**@return правильно ли введены данные на странице 3 [2]. */
    private Map<String, Boolean> getP2Passed() {
        return p2Passed;
    }

    /**@return правильно ли введены данные на странице 4 [3]. */
    private Map<String, Boolean> getP3Passed() {
        return p3Passed;
    }

    /**@return правильно ли введены данные на странице 5 [4]. */
    private Map<String, Boolean> getP4Passed() {
        return p4Passed;
    }

    /**@return правильно ли введены данные на странице 6 [5]. */
    private Map<String, Boolean> getP5Passed() {
        return p5Passed;
    }

    /**@return правильно ли введены данные на странице 7 [6]. */
    private Map<String, Boolean> getP6Passed() {
        return p6Passed;
    }

    /**@return правильно ли введены данные на странице 8 [7]. */
  /*  private Map<String, Boolean> getP7Passed() {
        return p7Passed;
    } */

    /**@return правильно ли введены данные на странице 9 [8]. */
    private Map<String, Boolean> getP8Passed() {
        return p8Passed;
    }
    
    /**@return правильно ли введены данные на странице*/
    public Map<String, Boolean> getPassed(int pageNumber) {
        switch (pageNumber) {
            case 0: return getP0Passed();
            case 1: return getP1Passed();
            case 2: return getP2Passed();
            case 3: return getP3Passed();
            case 4: return getP4Passed();
            case 5: return getP5Passed();
            case 6: return getP6Passed();
//            case 7: return getP7Passed();
            case 8: return getP8Passed();                                                             
            default: throw new AssertionError();
        }
    }
    
}
