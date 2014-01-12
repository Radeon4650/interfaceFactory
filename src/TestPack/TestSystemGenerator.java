package TestPack;

import BayesianNetwork.BayesianNetworkComponents;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.chart.LineChart;

/**
 *
 * @author radeon
 */

class StudentData {
    //были ли уже введены правильные ответы ранее?
    private Map<String, Boolean> p0_rightInput;
    private Map<String, Boolean> p1_rightInput;
    private Map<String, Boolean> p2_rightInput;
    private Map<String, Boolean> p3_rightInput;
    private Map<String, Boolean> p4_rightInput;
    private Map<String, Boolean> p5_rightInput;
    private Map<String, Boolean> p6_rightInput;
    private Map<String, Boolean> p7_rightInput;
    private Map<String, Boolean> p8_rightInput;
          
    
    // Значения полей, введенные студентом
    private Map<String, String> p0;
    private Map<String, String> p1;
    private Map<String, String> p2;
    private Map<String, String> p3;
    private Map<String, String> p4;
    private Map<String, String> p5;
    private Map<String, String> p6;
    private Map<String, String> p7;
    private Map<String, String> p8;
    
    
    public StudentData() {
        p0_rightInput = new HashMap();
        p1_rightInput = new HashMap();
        p2_rightInput = new HashMap();
        p3_rightInput = new HashMap();
        p4_rightInput = new HashMap();
        p5_rightInput = new HashMap();
        p6_rightInput = new HashMap();
        p7_rightInput = new HashMap();
        p8_rightInput = new HashMap();
        
        p0 = new HashMap();
        p1 = new HashMap();
        p2 = new HashMap();
        p3 = new HashMap();
        p4 = new HashMap();
        p5 = new HashMap();
        p6 = new HashMap();
        p7 = new HashMap();
        p8 = new HashMap();
        
        
        p0_rightInput.put("k", false);
        p0_rightInput.put("a", false);
        p0_rightInput.put("b", false);
        p0_rightInput.put("c", false);
        
        p1_rightInput.put("a", false);
        p1_rightInput.put("b", false);
        p1_rightInput.put("c", false);
        p1_rightInput.put("D", false);
        p1_rightInput.put("s1", false);
        p1_rightInput.put("s2", false);
        p1_rightInput.put("T1", false);
        p1_rightInput.put("T2", false);
        
        p2_rightInput.put("k", false);
        p2_rightInput.put("T1", false);
        p2_rightInput.put("T2", false);
        p2_rightInput.put("rep", false);
        
        p3_rightInput.put("k", false);
        p3_rightInput.put("mU", false);
        p3_rightInput.put("nU", false);
        p3_rightInput.put("mV", false);
        p3_rightInput.put("nV", false);
        p3_rightInput.put("h", false);
        p3_rightInput.put("e", false);
        p3_rightInput.put("x1", false);
        p3_rightInput.put("x2", false);
        p3_rightInput.put("x3", false);
        p3_rightInput.put("x4", false);
        
        p4_rightInput.put("k", false);
        p4_rightInput.put("n", false);
        p4_rightInput.put("m", false);
        
        p5_rightInput.put("Apb", false);
        p5_rightInput.put("wpb", false);
        
        p6_rightInput.put("Uw", false);
        p6_rightInput.put("Vw", true);
        

                
        p0.put("k", "");
        p0.put("a", "");
        p0.put("b", "");
        p0.put("c", "");
    
        p1.put("a", "");
        p1.put("b", "");
        p1.put("c", "");
        p1.put("D", "");
        p1.put("s1", "");
        p1.put("s2", "");
        p1.put("T1", "");
        p1.put("T2", "");
        
        p2.put("k", "");
        p2.put("T1", "");
        p2.put("T2", "");
        p2.put("rep", "-1");
        
        p3.put("k", "");
        p3.put("mU", "");
        p3.put("nU", "");
        p3.put("mV", "");
        p3.put("nV", "");
        p3.put("h", "");
        p3.put("e", "");
        p3.put("x1", "");
        p3.put("x2", "");
        p3.put("x3", "");
        p3.put("x4", "");
        
        p4.put("k", "");
        p4.put("m", "");
        p4.put("n", "");
        
        p5.put("Apb", "");
        p5.put("wpb", "");
        
        for (int i = 0; i < TestSystemGenerator.getAfLen(); i++) {
            p6.put("U"+String.valueOf(i), "-100.0");
            p6.put("V"+String.valueOf(i), "-100.0");
        }
        
        
        for (int i = 1; i < 13; i++) {
            p8.put(String.valueOf(i), "-1");
            p8_rightInput.put(String.valueOf(i), false);            
        }

    }
    
    public void setStudFs(String initK, String initA, String initB, String initC) {
        this.p0.remove("k"); this.p0.put("k", initK);
        this.p0.remove("a"); this.p0.put("a", initA);
        this.p0.remove("b"); this.p0.put("b", initB);
        this.p0.remove("c"); this.p0.put("c", initC);
    }
    
    public void setStudChEq(String initA, String initB, String initC) {
        this.p1.remove("a"); this.p1.put("a", initA);
        this.p1.remove("b"); this.p1.put("b", initB);
        this.p1.remove("c"); this.p1.put("c", initC);
    }

    /**@return были ли уже введены правильные ответы ранее*/
    public Map<String, Boolean> getP_rightInput(int pageNumber) {
        switch (pageNumber) {
            case 0: return getP0_rightInput();
            case 1: return getP1_rightInput();
            case 2: return getP2_rightInput();
            case 3: return getP3_rightInput();
            case 4: return getP4_rightInput();
            case 5: return getP5_rightInput();
            case 6: return getP6_rightInput();
            case 7: return getP7_rightInput();
            case 8: return getP8_rightInput();                        
            default:
                throw new AssertionError();
        }
    }
    
    /**@return были ли уже введены правильные ответы ранее на странице 1 [0]. */
    private Map<String, Boolean> getP0_rightInput() {
        return p0_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 2 [1]. */
    private Map<String, Boolean> getP1_rightInput() {
        return p1_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 3 [2]. */
    private Map<String, Boolean> getP2_rightInput() {
        return p2_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 4 [3]. */
    private Map<String, Boolean> getP3_rightInput() {
        return p3_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 5 [4]. */
    private Map<String, Boolean> getP4_rightInput() {
        return p4_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 6 [5]. */
    private Map<String, Boolean> getP5_rightInput() {
        return p5_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 7 [6]. */
    private Map<String, Boolean> getP6_rightInput() {
        return p6_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 8 [7]. */
    private Map<String, Boolean> getP7_rightInput() {
        return p7_rightInput;
    }

    /**@return были ли уже введены правильные ответы ранее на странице 9 [8]. */
    private Map<String, Boolean> getP8_rightInput() {
        return p8_rightInput;
    }

    /**@return Значения полей, введенные студентом.
    * @param pageNumber номер страницы*/
    public Map<String, String> getP(int pageNumber) {
        switch (pageNumber) {
            case 0: return getP0();
            case 1: return getP1();
            case 2: return getP2();
            case 3: return getP3();
            case 4: return getP4();
            case 5: return getP5();
            case 6: return getP6();
            case 7: return getP7();
            case 8: return getP8();                        
            default:
                throw new AssertionError();
    }}
    
    /**@return Значения полей, введенные студентом на странице 1 [0]. */
    private Map<String, String> getP0() {
        return p0;
    }

    /**@return Значения полей, введенные студентом на странице 2 [1]. */
    private Map<String, String> getP1() {
        return p1;
    }

    /**@return Значения полей, введенные студентом на странице 3 [2]. */
    private Map<String, String> getP2() {
        return p2;
    }

    /**@return Значения полей, введенные студентом на странице 4 [3]. */
    private Map<String, String> getP3() {
        return p3;
    }

    /**@return Значения полей, введенные студентом на странице 5 [4]. */
    private Map<String, String> getP4() {
        return p4;
    }

    /**@return Значения полей, введенные студентом на странице 6 [5]. */
    private Map<String, String> getP5() {
        return p5;
    }

    /**@return Значения полей, введенные студентом на странице 7 [6]. */
    private Map<String, String> getP6() {
        return p6;
    }

    /**@return Значения полей, введенные студентом на странице 8 [7]. */
    private Map<String, String> getP7() {
        return p7;
    }

    /**@return Значения полей, введенные студентом на странице 9 [8]. */
    private Map<String, String> getP8() {
        return p8;
    }

}

class CalcPrecisions {
    private Map<String, Double> precision;
            
    public CalcPrecisions() {
        precision = new HashMap();
        precision.put("k_0", 0.01);
        precision.put("a_0", 0.001);
        precision.put("b_0", 0.01);
        precision.put("c_0", 0.1);
        
        precision.put("k_1", 0.01);
        precision.put("a_1", 0.001);
        precision.put("b_1", 0.01);
        precision.put("c_1", 0.1);
        precision.put("D_1", 0.01);
        precision.put("s1_1", 0.5);
        precision.put("s2_1", 0.5);
        precision.put("T1_1", 0.001);
        precision.put("T2_1", 0.001);
        
        precision.put("k_2", 0.01);
        precision.put("T1_2", 0.001);
        precision.put("T2_2", 0.001);
        
        precision.put("k_3", 0.01);
        precision.put("mU_3", 0.001);
        precision.put("nU_3", 0.001);
        precision.put("mV_3", 0.001);
        precision.put("nV_3", 0.001);
        precision.put("h_3", 0.01);
        precision.put("e_3", 0.01);
        precision.put("x1_3", 0.001);
        precision.put("x2_3", 0.001);
        precision.put("x3_3", 0.001);
        precision.put("x4_3", 0.001);
        
        precision.put("k_4", 0.01);
        precision.put("m_4", 0.001);
        precision.put("n_4", 0.001);
        
        precision.put("Apb_5", 0.01);
        precision.put("wpb_5", 5.0);
        
        loadProperties("TestPack/Precisions.properties");  
    }
    
    private void loadProperties(String fileName) {
        try {
//  Пробуем считать настройки из файла
            Properties precProp = new Properties();
            precProp.load(getClass().getClassLoader().getResourceAsStream(fileName));
            System.out.println("File <" +fileName+ "> is opened, Precision properties are successfully loaded.");
            double buffer;
            for (String key : precision.keySet()) {
                buffer = Double.parseDouble((precProp.getProperty(key)));
                precision.put(key, buffer);
            }
        }
        catch (IOException ex){
// При обнаружении ошибки задаем параметры с помощью хард-кода            
            System.out.println("I/O Error. Setting the standard Precision properties.");
        }
    }     
    
    public double getPrecision(String key) {
        return this.precision.get(key);
    }
}



public class TestSystemGenerator extends DemoPack.DemoSystemGenerator {
    //правильные ответы для определения последовательности на странице 9 [8]:
    private final String [] rightSequenceValues = {"2", "0", "2", "1", "1", "0,2", "1,2", "2", "2", "0", "2", "2"};
    static private final int unwrittedValue = -10; // значение величины, которая не была введена студентом
    private final int incMark = 5;  //количество баллов, получаемых за верно введенное решение
    private final int decMark = 1;  //количество штрафных баллов, снимаемых при ошибочном решении
    
    private StudentData studData;
    private TestPassingUnit testPU;
    private CalcPrecisions prec;
    private BayesianNetworkComponents b_net;
    

    public TestSystemGenerator() {
        super();
        testPU = new TestPassingUnit(0.01);      
        studData = new StudentData();
        prec = new CalcPrecisions();
        b_net = new BayesianNetworkComponents();
    }

    public LineChart<Number, Number> getBayesianChart(final ResourceBundle lang) {
        return this.b_net.getLearningChart(lang);
    }
    
    /**@return Зачение, введенное студентом на конкретной странице
     * @param pageNumber номер страницы для поиска* 
     * @param key ключ для поиска на конкретной странице*/
    public String getStudValue(int pageNumber, String key) {
        return this.studData.getP(pageNumber).get(key);
    }
    
    /**@return Правильность решения, введенного студентом на конкретной странице
     * @param pageNumber номер страницы для поиска* 
     * @param key ключ для поиска на конкретной странице*/
    public boolean getStudPassing(int pageNumber, String key) {
        return this.testPU.getPassed(pageNumber).get(key);
    }
    
    /**@return HTML-строку с подробным сообщением о результатах прохождения теста */
    public String printTestResults(ResourceBundle lang) {
        return getTestPU().checkResults(lang);
    }

    /** Формула представляется в виде Ф(s) = k/(a*s^2 + b*s + c)
     * @param init_k введенный студентом коеффициент k
     * @param init_a введенный студентом коеффициент a
     * @param init_b введенный студентом коеффициент b
     * @param init_c введенный студентом коеффициент c
     */
    public void setStudentsFs_p0(String init_k, String init_a, String init_b, String init_c) {
        this.studData.setStudFs(init_k, init_a, init_b, init_c);
    }
    
    public void setStudentChEqCoeff_p1 (String init_a, String init_b, String init_c) {
        this.studData.setStudChEq(init_a, init_b, init_c);
    }
    
    public void setStudD_p1(String initD) {
        this.studData.getP(1).put("D", initD);
    }
    
    public void setStudS_p1(String s1, String s2) {
        this.studData.getP(1).put("s1", s1);
        this.studData.getP(1).put("s2", s2);
    }
    
    public void setStudT_p1(String t1, String t2) {
        this.studData.getP(1).put("T1", t1);
        this.studData.getP(1).put("T2", t2);
    }
    
    private void setStudFsT_p2(String k, String t1, String t2) {
        this.studData.getP(2).put("k", k);
        this.studData.getP(2).put("T1", t1);
        this.studData.getP(2).put("T2", t2);
    }
    
    private void setStudRepl_p2(String replNum) {
        this.studData.getP(2).put("rep", replNum);
    }
    
    public void saveStud_p2(String k, String t1, String t2, String replNum) {
        setStudFsT_p2(k, t1, t2);
        setStudRepl_p2(replNum);
    }
    
    public void saveStud_p3(String k, String mU, String nU, String mV, 
            String nV, String h, String e, String x1, String x2, 
            String x3, String x4) {
        this.studData.getP(3).clear();
        
        this.studData.getP(3).put("k", k);
        this.studData.getP(3).put("mU", mU);
        this.studData.getP(3).put("nU", nU);
        this.studData.getP(3).put("mV", mV);
        this.studData.getP(3).put("nV", nV);
        this.studData.getP(3).put("h", h);
        this.studData.getP(3).put("e", e);
        this.studData.getP(3).put("x1", x1);
        this.studData.getP(3).put("x2", x2);
        this.studData.getP(3).put("x3", x3);
        this.studData.getP(3).put("x4", x4);
    }
    
    public void saveStud_p4(String k, String m, String n) {
        this.studData.getP(4).clear();
        this.studData.getP(4).put("k", k);
        this.studData.getP(4).put("m", m);
        this.studData.getP(4).put("n", n);
    }
    
    public void saveStud_p5(String Apb, String wpb) {
        this.studData.getP(5).clear();
        this.studData.getP(5).put("Apb", Apb);
        this.studData.getP(5).put("wpb", wpb);
    }
    
    public void saveStud_p6(String [] Uw_arr, String [] Vw_arr) {
        this.studData.getP(6).clear();
        for (int i = 0; i < Uw_arr.length; i++) 
            this.studData.getP(6).put("U"+String.valueOf(i), Uw_arr[i]);    
        for (int i = 0; i < Vw_arr.length; i++) 
            this.studData.getP(6).put("V"+String.valueOf(i), Vw_arr[i]);        
    }
    
    public void saveStud_p8(Map<Integer, Integer> selectedValues) {
        this.studData.getP(8).clear();
        for (int i : selectedValues.keySet() ) {
            this.studData.getP(8).put(String.valueOf(i), String.valueOf(selectedValues.get(i)));
        }
    }
    
    /**Проверка правильности решения, введенного на соответствующей странице
     * @param pageNumber номер страницы    */
    public void checkPage(int pageNumber) {
        switch (pageNumber) {
            case 0: checkPage0(); break;
            case 1: checkPage1(); break;
            case 2: checkPage2(); break;
            case 3: checkPage3(); break;
            case 4: checkPage4(); break;
            case 5: checkPage5(); break;
            case 6: checkPage6(); break;
            case 7: checkPage7(); break;
            case 8: checkPage8(); break;
            default: throw new AssertionError();
        }
    }
    
    /**Выполняет изменение оценки обучающегося на данном этапе,
     * основываясь на предыдущем решении и текущем введенном значении 
     * @param prevRes правильность предыдущего решения
     * @param currentRes правильность текущего решения
     * @param incValue количество баллов, на которое следует увеличить оценку, 
     * если текущее решение верно
     * @param decValue количество баллов, на которое следует уменьшить оценку, 
     * если текущее решение ошибочно
     */
    private void estimate(boolean prevRes, boolean currentRes, int incValue, int decValue) {
        if (prevRes) {
            if (!currentRes) {
                /*Если на предыдущем шаге было введено правильное решение,
                а на текущем - неправильное, снимается в 2 раза больше баллов 
                в качестве штрафных санкций*/
                getTestPU().decreaseScore(decValue*2);
            }
            /*Если предыдущее и текущее значение верно, 
            баллы остаются без изменений*/
        }
        else {
            if (currentRes) {
                /*Если предыдущее значение было неверно, а заново введенное
                проходит проверку на правильность, оценка увеличивается*/
                getTestPU().increaseScore(incValue);
            }
            /*Если предыдущее значение и заново введенное не прошли проверку 
            на правильность вычисления, оценка снижается*/
            else getTestPU().decreaseScore(decValue);
        }
    }
    
    /**Выполняет изменение оценки обучающегося на данном этапе,
     * основываясь на предыдущем решении и текущем введенном значении 
     * @param prevRes правильность предыдущего решения
     * @param currentRes правильность текущего решения*/
    private void estimate(boolean prevRes, boolean currentRes) {
        estimate(prevRes, currentRes, incMark, decMark);
    }
    
    /**Внесение изменений в баесовскую сеть для конкретного значения*/
    private void bayesianChange(String netName, boolean answerRight, boolean diagnosisApproved) {
        this.b_net.changeNetworkElement(netName, answerRight, diagnosisApproved);
    }
    
     private void checkDoubleValue(int pageNumber, String key, double autoValue, 
             double studValue, String netName, boolean diagnosisApproved) {
         boolean prevRes, currRes;
         double precision = this.prec.getPrecision(key+"_"+String.valueOf(pageNumber));
         prevRes = studData.getP_rightInput(pageNumber).get(key);                               //Узнаем, было ли ранее введено правильное решение
         currRes = getTestPU().checkValues(pageNumber, key, autoValue, studValue, precision);   //Проверяем правильность текущего решения
         if ((!prevRes) & currRes) {                                                            //Если текущее решение правильно - делаем пометку
            studData.getP_rightInput(pageNumber).remove(key);
            studData.getP_rightInput(pageNumber).put(key, currRes);
         }
         estimate(prevRes, currRes);                                                            //Выставляем оценку
         
         bayesianChange(netName, currRes, diagnosisApproved);
     }
     
     private void checkStringValue(int pageNumber, String key, String autoValue, 
             String studValue) {
         boolean prevRes, currRes;
         prevRes = studData.getP_rightInput(pageNumber).get(key);
         currRes = getTestPU().checkValues(pageNumber, key, autoValue, studValue);
         if ((!prevRes) & currRes) {
            studData.getP_rightInput(pageNumber).remove(key);
            studData.getP_rightInput(pageNumber).put(key, currRes);
         }
         estimate(prevRes, currRes);
     }
     
     /**@return результат парсинга строки в число. 
      * Если преобразование не удалось, 
      * возвращается значение, заданное по умолчанию. 
      * @param pageNumber номер страницы
      * @param key ключ к карте
      */
     private double tryParce(int pageNumber, String key) {     
         try { return Double.parseDouble(studData.getP(pageNumber).get(key)); }
         catch (NumberFormatException ex) { return getUnwrittedValue(); }
     }
    
    
    /**Проверка правильности решения для страницы 1 [0]*/
    private void checkPage0() {
        double k, a, b, c;
        int pageNumber = 0;
        String netName = "TransferFunction";
        boolean diagnosisApproved = false;
        
        k = tryParce(pageNumber, "k");
        a = tryParce(pageNumber, "a");
        b = tryParce(pageNumber, "b");
        c = tryParce(pageNumber, "c");
        
        checkDoubleValue(pageNumber, "k", this.getFs().getK(), k, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "a", this.getFs().getA(), a, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "b", this.getFs().getB(), b, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "c", this.getFs().getC(), c, netName, diagnosisApproved);                                    
    }
    
    
    
    /**Проверка правильности решения для страницы 2 [1]*/
    private void checkPage1() {
        double a, b, c, D, s1, s2, T1, T2;
        int pageNumber = 1;
        String netName = "SquareEquation";
        boolean diagnosisApproved = false;
        
        a = tryParce(pageNumber, "a");
        b = tryParce(pageNumber, "b");
        c = tryParce(pageNumber, "c");
        D = tryParce(pageNumber, "D");
        s1 = tryParce(pageNumber, "s1");
        s2 = tryParce(pageNumber, "s2");
        T1 = tryParce(pageNumber, "T1");
        T2 = tryParce(pageNumber, "T2");
        
        checkDoubleValue(pageNumber, "a", this.getFs().getA(), a, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "b", this.getFs().getB(), b, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "c", this.getFs().getC(), c, netName, diagnosisApproved); 
        checkDoubleValue(pageNumber, "D", this.getFs().getD(), D, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "s1", this.getFs().getS1(), s1, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "s2", this.getFs().getS2(), s2, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "T1", this.getFs().getT1(), T1, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "T2", this.getFs().getT2(), T2, netName, diagnosisApproved);
        
    }
    
    
    
    /**Проверка правильности решения для страницы 3 [2]*/
    private void checkPage2() {
        double k, T1, T2;
        int pageNumber = 2;
        String netName = "FrequencyCharacteristic";
        boolean diagnosisApproved = false;
        
        k = tryParce(pageNumber, "k");
        T1 = tryParce(pageNumber, "T1");
        T2 = tryParce(pageNumber, "T2");
        
        checkDoubleValue(pageNumber, "k", this.getFs().getK(), k, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "T1", this.getFs().getT1(), T1, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "T2", this.getFs().getT2(), T2, netName, diagnosisApproved);
        checkStringValue(pageNumber, "rep", "1", studData.getP(2).get("rep"));
    }
    
    
    
    /**Проверка правильности решения для страницы 4 [3]*/
    private void checkPage3() {
        double k, mU, nU, mV, nV, h, e, x1, x2, x3, x4;
        int pageNumber = 3;
        String netName = "U(w)";
        
        boolean diagnosisApproved = false;
        
        k = tryParce(pageNumber, "k");
        mU = tryParce(pageNumber, "mU");
        nU = tryParce(pageNumber, "nU");
        mV = tryParce(pageNumber, "mV");
        nV = tryParce(pageNumber, "nV");
        h = tryParce(pageNumber, "h");
        e = tryParce(pageNumber, "e");
        x1 = tryParce(pageNumber, "x1");
        x2 = tryParce(pageNumber, "x2");
        x3 = tryParce(pageNumber, "x3");
        x4 = tryParce(pageNumber, "x4");
        
        checkDoubleValue(pageNumber, "k", this.getFs().getK(), k, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "mU", this.getFs().getU_w().getM(), mU, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "nU", this.getFs().getU_w().getN(), nU, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "h", this.getFs().getU_w().getH(), h, netName, diagnosisApproved);
        
        checkDoubleValue(pageNumber, "x1", -this.getFs().getT1(), x1, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "x3", -this.getFs().getT1(), x3, netName, diagnosisApproved);
        
        netName = "V(w)";
        checkDoubleValue(pageNumber, "mV", this.getFs().getV_w().getM(), mV, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "nV", this.getFs().getV_w().getN(), nV, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "e", this.getFs().getV_w().getE(), e, netName, diagnosisApproved);  
        
        checkDoubleValue(pageNumber, "x2", -this.getFs().getT2(), x2, netName, diagnosisApproved);  
        checkDoubleValue(pageNumber, "x4", -this.getFs().getT2(), x4, netName, diagnosisApproved);
    }
    
    
    
    /**Проверка правильности решения для страницы 5 [4]*/
    private void checkPage4() {
        double k, m, n;
        int pageNumber = 4;
        String netName = "A(w)";
        boolean diagnosisApproved = false;
        
        k = tryParce(pageNumber, "k");
        m = tryParce(pageNumber, "m");
        n = tryParce(pageNumber, "n");
        
        checkDoubleValue(pageNumber, "k", this.getFs().getK(), k, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "m", this.getFs().getA_w().getM(), m, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "n", this.getFs().getA_w().getN(), n, netName, diagnosisApproved);
    }
    
    
    
    /**Проверка правильности решения для страницы 6 [5]*/
    private void checkPage5() {
        int pageNumber = 5;
        double a, w;
        String netName = "A(w_pb)";
        
        boolean diagnosisApproved = false;
        
        a = tryParce(pageNumber, "Apb");
        w = tryParce(pageNumber, "wpb");
        
        checkDoubleValue(pageNumber, "Apb", this.getFs().getA_w().getApr(), a, netName, diagnosisApproved);
        checkDoubleValue(pageNumber, "wpb", this.getFs().getA_w().getwPr(), w, netName, diagnosisApproved);
    }
    
    
    
    /**Проверка правильности решения для страницы 7 [6]*/
    private void checkPage6() {
        boolean prevRes, currRes;
        prevRes = this.studData.getP_rightInput(6).get("Uw");
        currRes = testPU.checkUw_p6();
        estimate(prevRes, currRes);
        prevRes = this.studData.getP_rightInput(6).get("Vw");
        currRes = testPU.checkVw_p6();
        estimate(prevRes, currRes);
    }
    
    
    
    /**Проверка правильности решения для страницы 8 [7]*/
    private void checkPage7() {
        //не требуется, т.к. на странице выводится график и пользовательские данные не вводятся
    }
    
    
    
    /**Проверка правильности решения для страницы 9 [8]*/
    private void checkPage8() {
        int pageNumber = 8;
        String key;
        for (int i = 0; i < rightSequenceValues.length; i++) 
            if ((i!=5)&(i!=6)) {
            key = String.valueOf(i+1);
            checkStringValue(pageNumber, key, rightSequenceValues[i], 
                    this.studData.getP(pageNumber).get(key));   
        }
        if (this.studData.getP(pageNumber).get("6").equals("0")) {
            checkStringValue(pageNumber, "6", "0", this.studData.getP(pageNumber).get("6"));
            checkStringValue(pageNumber, "7", "2", this.studData.getP(pageNumber).get("7"));
        }
        else {
            checkStringValue(pageNumber, "6", "2", this.studData.getP(pageNumber).get("6"));
            checkStringValue(pageNumber, "7", "1", this.studData.getP(pageNumber).get("7"));
        }
    }

    
    
    /** @return массив данных для конкретной страницы.
     * @param pageNumber номер страницы */
    public String[] getPageData(int pageNumber) {
        switch (pageNumber) {
            case 0: return page0data();
            case 1: return page1data();
            case 2: return page2data();
            case 3: return page3data();
            case 4: return page4data();
            case 5: return page5data();
            case 6: return page6data();
            case 7: return page7data();
            case 8: return page8data();
            default: throw new AssertionError();
        }
    }
    
    /**@return массив данных для 0й страницы: k, a, b, c. */
    private String[] page0data() {
        String [] data = {studData.getP(0).get("k"), 
            studData.getP(0).get("a"), 
            studData.getP(0).get("b"), 
            studData.getP(0).get("c")};
        return data;
    }
    
    /**@return массив данных для 1й страницы: a, b, c, D, s1, s2, T1, T2. */
    private String[] page1data() {
        String [] data = {studData.getP(1).get("a"), 
            studData.getP(1).get("b"), 
            studData.getP(1).get("c"),
            studData.getP(1).get("D"), 
            studData.getP(1).get("s1"), 
            studData.getP(1).get("s2"),
            studData.getP(1).get("T1"), 
            studData.getP(1).get("T2")};
        return data;
    }
    
    /**@return массив данных для 2й страницы: k, T1, T2, номер в списке замены. */
    private String[] page2data() {
        String [] data = {studData.getP(2).get("k"), 
            studData.getP(2).get("T1"), 
            studData.getP(2).get("T2"), 
            studData.getP(2).get("rep")};
        return data;
    }
    
    /**@return массив данных для 3й страницы: k, mU, nU, mV, nV, h, e, x1, x2, x3, x4. */
    private String[] page3data() {
        String [] data = {studData.getP(3).get("k"), 
            studData.getP(3).get("mU"),
            studData.getP(3).get("nU"),
            studData.getP(3).get("mV"),
            studData.getP(3).get("nV"),
            studData.getP(3).get("h"),
            studData.getP(3).get("e"),
            studData.getP(3).get("x1"),
            studData.getP(3).get("x2"),
            studData.getP(3).get("x3"),
            studData.getP(3).get("x4")};
        return data;
    }
    
    /**@return массив данных для 4й страницы: k, m, n. */
    private String[] page4data() {
        String [] data = {studData.getP(4).get("k"), 
            studData.getP(4).get("m"),
            studData.getP(4).get("n")};
        return data;
    }
    
    /**@return массив данных для 5й страницы: A(w пр), w пр. */
    private String[] page5data() {
        String [] data = {studData.getP(5).get("Apb"), 
            studData.getP(5).get("wpb")};
        return data;
    }
    
    /**@return массив данных для 6й страницы*/
    private String[] page6data() {
        int dataCount = getAfLen();
        String [] data = new String [2*dataCount];
        for (int i = 0; i < dataCount; i++) {
            data[i] = studData.getP(6).get("U"+String.valueOf(i));
            data[i+dataCount] = studData.getP(6).get("V"+String.valueOf(i)); 
        }
        return data;
    }
    
    /**@return массив данных для 7й страницы*/
    private String[] page7data() {
        String [] data = {};
        return data;
    }
    
    /**@return массив данных для 8й страницы*/
    private String[] page8data() {
        int dataLen = this.studData.getP(8).size();
        String [] data = new String[dataLen];
        for (int i = 1; i < dataLen+1; i++) {
            data[i-1] = this.studData.getP(8).get(String.valueOf(i));          
        }
        return data;
    }
    
    /** @return the testPU */
    public TestPassingUnit getTestPU() {
        return testPU;
    }

    /**  @return значение величины, которая не была введена студентом  */
     public static int getUnwrittedValue() {
        return unwrittedValue;
    }
}
