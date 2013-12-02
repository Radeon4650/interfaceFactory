

package TestPack;

import DiffModesCommon.AppStyles;
import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */
public class TestPassingUnit {
    private int score;
    private final double autoPrecision = 0.1; 
    
    private boolean fs_k_passed;        // верный коэффициент k в Ф(s)
    private boolean fs_a_passed;        // верный коэффициент a в Ф(s)
    private boolean fs_b_passed;        // верный коэффициент b в Ф(s)
    private boolean fs_c_passed;        // верный коэффициент c в Ф(s)
    private boolean chEq_a_passed;      // верный коэффициент a в характеристическом уравнении
    private boolean chEq_b_passed;      // верный коэффициент b в характеристическом уравнении
    private boolean chEq_c_passed;      // верный коэффициент c в характеристическом уравнении
    private boolean chEq_D_passed;      // верно посчитан дискриминант характеристического уравнения
    private boolean chEq_s1_passed;     // верно посчитан корень s1 характеристического уравнения
    private boolean chEq_s2_passed;     // верно посчитан корень s2 характеристического уравнения
    private boolean chEq_t1_passed;     // верно посчитана постоянная времени Т1
    private boolean chEq_t2_passed;     // верно посчитана постоянная времени Т2
  
    private double precision;     // точность совпадения решения студента и данных, вычисленных автоматически

    /**@param calcPrecision точность совпадения решения студента и данных, вычисленных автоматически*/
    public TestPassingUnit(double calcPrecision) {
        score = 0;
        
        fs_k_passed = false;        
        fs_a_passed = false;        
        fs_b_passed = false;        
        fs_c_passed = false;        
        chEq_a_passed = false;      
        chEq_b_passed = false;      
        chEq_c_passed = false;     
        chEq_D_passed = false;      
        chEq_s1_passed = false;     
        chEq_s2_passed = false;     
        chEq_t1_passed = false;    
        chEq_t2_passed = false;
        
        if (calcPrecision>0)
            precision = calcPrecision;
        else precision = autoPrecision;
    }
    
    
    
    /** Проверка коэффициента k в Ф(s)
     * @param autoK коеффициент k в Ф(s), посчитанный автоматически
     * @param studK коеффициент k в Ф(s), посчитанный студентом */
    public boolean check_fs_k(double autoK, double studK) {
         fs_k_passed = Math.abs(autoK-studK)<=precision;
         return fs_k_passed;
    }
    
    /** Проверка коэффициента a в Ф(s)
     * @param autoA коеффициент a в Ф(s), посчитанный автоматически
     * @param studA коеффициент a в Ф(s), посчитанный студентом */
    public boolean check_fs_a (double autoA, double studA) {  
        fs_a_passed = Math.abs(autoA-studA)<=precision;
        return fs_a_passed;
    }   
    
    /** Проверка коэффициента b в Ф(s)
     * @param autoB коеффициент b в Ф(s), посчитанный автоматически
     * @param studB коеффициент b в Ф(s), посчитанный студентом */
    public boolean check_fs_b (double autoB, double studB) {        
        fs_b_passed = Math.abs(autoB-studB)<=precision;
        return fs_b_passed;
    }
    
    /** Проверка коэффициента c в Ф(s)
     * @param autoC коеффициент c в Ф(s), посчитанный автоматически
     * @param studC коеффициент c в Ф(s), посчитанный студентом */
    public boolean check_fs_c (double autoC, double studC) {       
        fs_c_passed = Math.abs(autoC-studC)<=precision;
        return fs_c_passed;
    }
    
    /** Проверка коэффициента a в характеристическом уравнении
     * @param autoA коеффициент a в характеристическом уравнении, посчитанный автоматически
     * @param studA коеффициент a в характеристическом уравнении, посчитанный студентом */
    public boolean check_chEq_a (double autoA, double studA) {     
        chEq_a_passed = Math.abs(autoA-studA)<=precision;
        return chEq_a_passed;
    }
    
    /** Проверка коэффициента b в характеристическом уравнении
     * @param autoB коеффициент b в характеристическом уравнении, посчитанный автоматически
     * @param studB коеффициент b в характеристическом уравнении, посчитанный студентом */
    public boolean check_chEq_b (double autoB, double studB) {     
        chEq_b_passed = Math.abs(autoB-studB)<=precision;
        return chEq_b_passed;
    }
    
    /** Проверка коэффициента c в характеристическом уравнении
     * @param autoC коеффициент c в характеристическом уравнении, посчитанный автоматически
     * @param studC коеффициент c в характеристическом уравнении, посчитанный студентом */
    public boolean check_chEq_c (double autoC, double studC) {    
        chEq_c_passed = Math.abs(autoC-studC)<=precision;
        return chEq_c_passed;
    }
    
    /** Проверка дискриминанта характеристического уравнения
     * @param autoD дискриминант характеристического уравнения, посчитанный автоматически
     * @param studD дискриминант характеристического уравнения, посчитанный студентом */
    public boolean check_chEq_D (double autoD, double studD) {    
        chEq_D_passed = Math.abs(autoD-studD)<=precision;
        return chEq_D_passed;
    }
    
    /** Проверка корня s1 характеристического уравнения
     * @param autoS1 корень s1 характеристического уравнения, посчитанный автоматически
     * @param studS1 корень s1 характеристического уравнения, посчитанный студентом */
    public boolean check_chEq_s1 (double autoS1, double studS1) {   
        chEq_s1_passed = Math.abs(autoS1-studS1)<=precision;
        return chEq_s1_passed;
    }
    
    /** Проверка корня s2 характеристического уравнения
     * @param autoS2 корень s2 характеристического уравнения, посчитанный автоматически
     * @param studS2 корень s2 характеристического уравнения, посчитанный студентом */
    public boolean check_chEq_s2 (double autoS2, double studS2) {   
        chEq_s2_passed = Math.abs(autoS2-studS2)<=precision;
        return chEq_s2_passed;
    }
    
    /** Проверка постоянной времени Т1
     * @param autoT1 постоянная времени Т1, посчитанная автоматически
     * @param studT1 постоянная времени Т1, посчитанная студентом */
    public boolean check_chEq_t1 (double autoT1, double studT1) {    
        chEq_t1_passed = Math.abs(autoT1-studT1)<=precision;
        return chEq_t1_passed;
    }
    
    /** Проверка постоянной времени Т2
     * @param autoT2 постоянная времени Т2, посчитанная автоматически
     * @param studT2 постоянная времени Т2, посчитанная студентом */
    public boolean check_chEq_t2 (double autoT2, double studT2) {
        chEq_t2_passed = Math.abs(autoT2-studT2)<=precision;
        return chEq_t2_passed;
    }

    /**@return HTML-строку с подробным сообщением о результатах прохождения теста */
    public String checkResults(final ResourceBundle lang) {
        String passed = "<font color=\"" + AppStyles.rightGreenColor()
                + "\">" + lang.getString("TPU.passed") + "</font>";
        String failed = "<font color=\"" + AppStyles.wrongRedColor()
                + "\">" + lang.getString("TPU.failed") + "</font>";
        
        return "<html><body><h2 align=\"center\">"
                + lang.getString("TPU.results")
                + "</h2>" + lang.getString("TPU.fs_k")
                + (fs_k_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.fs_a")
                + (fs_a_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.fs_b")
                + (fs_b_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.fs_c")
                + (fs_c_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_a")
                + (chEq_a_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_b")
                + (chEq_b_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_c")
                + (chEq_c_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_D")
                + (chEq_D_passed ? passed : failed )            
                + ";<br>" + lang.getString("TPU.chEq_s1")
                + (chEq_s1_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_s2")
                + (chEq_s2_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_t1")
                + (chEq_t1_passed ? passed : failed )
                + ";<br>" + lang.getString("TPU.chEq_t2")
                + (chEq_t2_passed ? passed : failed )
                + ".</body></html>";
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
}
