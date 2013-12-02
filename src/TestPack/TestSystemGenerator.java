package TestPack;

import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */

class StudentData {
    private double stud_k_fs;
    private double stud_a_fs;
    private double stud_b_fs;
    private double stud_c_fs;
    private double stud_a_chEq;
    private double stud_b_chEq;
    private double stud_c_chEq;
    private double stud_s1;
    private double stud_s2;
    private double stud_T1;
    private double stud_T2;
    
    public StudentData() {
        stud_k_fs = 0;
        stud_a_fs = 0;
        stud_b_fs = 0;
        stud_c_fs = 0;
        stud_a_chEq = 0;
        stud_b_chEq = 0;
        stud_c_chEq = 0;
        stud_s1 = 0;
        stud_s2 = 0;
        stud_T1 = 0;
        stud_T2 = 0;
    }
    
    public void setStudFs(double initK, double initA, double initB, double initC) {
        this.stud_k_fs = initK;
        this.stud_a_fs = initA;
        this.stud_b_fs = initB;
        this.stud_c_fs = initC;
    }
    
    public void setStudChEq(double initA, double initB, double initC) {
        this.stud_a_chEq = initA;
        this.stud_b_chEq = initB;
        this.stud_c_chEq = initC;
    }

    /** @return коэффициент k в Ф(s), введенный студентом */
    public double getStud_k_fs() {
        return stud_k_fs;
    }

    /** @return коэффициент a в Ф(s), введенный студентом */
    public double getStud_a_fs() {
        return stud_a_fs;
    }

    /** @return коэффициент b в Ф(s), введенный студентом */
    public double getStud_b_fs() {
        return stud_b_fs;
    }

    /** @return коэффициент c в Ф(s), введенный студентом */
    public double getStud_c_fs() {
        return stud_c_fs;
    }

    /** @return коэффициент a характеристического уравнения, введенный студентом */
    public double getStud_a_chEq() {
        return stud_a_chEq;
    }

    /** @return коэффициент b характеристического уравнения, введенный студентом */
    public double getStud_b_chEq() {
        return stud_b_chEq;
    }

    /** @return коэффициент c характеристического уравнения, введенный студентом */
    public double getStud_c_chEq() {
        return stud_c_chEq;
    }

    /** @return корень s1 характеристического уравнения, введенный студентом */
    public double getStud_s1() {
        return stud_s1;
    }

    /** @param stud_s1 корень s1 характеристического уравнения, введенный студентом */
    public void setStud_s1(double stud_s1) {
        this.stud_s1 = stud_s1;
    }

    /** @return корень s2 характеристического уравнения, введенный студентом */
    public double getStud_s2() {
        return stud_s2;
    }

    /** @param stud_s2 корень s2 характеристического уравнения, введенный студентом */
    public void setStud_s2(double stud_s2) {
        this.stud_s2 = stud_s2;
    }

    /**@return постоянную времени T1, введенную студентом */
    public double getStud_T1() {
        return stud_T1;
    }

    /**@param stud_T1 постоянная времени Т1, введенная студентом   */
    public void setStud_T1(double stud_T1) {
        this.stud_T1 = stud_T1;
    }

    /**@return постоянную времени T2, введенную студентом */
    public double getStud_T2() {
        return stud_T2;
    }

    /**@param stud_T2 постоянная времени Т2, введенная студентом   */
    public void setStud_T2(double stud_T2) {
        this.stud_T2 = stud_T2;
    }
}


public class TestSystemGenerator extends DemoPack.DemoSystemGenerator {
    private StudentData studData;
    private TestPassingUnit testPU;

    public TestSystemGenerator() {
        super();
    //        setStudentsFs(0, 0, 0, 0);
        testPU = new TestPassingUnit(0.01);      
        studData = new StudentData();
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
    public void setStudentsFs(double init_k, double init_a, double init_b, double init_c) {
        this.studData.setStudFs(init_k, init_a, init_b, init_c);
    }
    
    public void setStudentChEqCoeff (double init_a, double init_b, double init_c) {
        this.studData.setStudChEq(init_a, init_b, init_c);
    }
    
 
//    /**@return совпадение вычислений коэффициента \"k\" студента и компьютера 
//     * с заданной точностью
//     * true - если вычисленный студентом и компьютером коэффициенты \"k\"
//     * совпадают с заданной точностью;
//     * false - если вычисленный студентом и компьютером коэффициенты \"k\"
//     * совпадают с заданной точностью
//     * либо если одна из передаточных функций не создана;
//     * @param precision точность совпадения*/
//    public boolean overlapFs_k(double precision) {
//        try {
//            return (Math.abs(getStudentsFs().getK()-getFs().getK())<=precision);}
//        catch (Exception e) {
//            System.out.println("Overlap comparison of \"k\" parameters failed");
//            return false;
//    }
//    }
//    
//    /**@return совпадение вычислений коэффициента \"a\" студента и компьютера 
//     * с заданной точностью
//     * true - если вычисленный студентом и компьютером коэффициенты \"a\"
//     * совпадают с заданной точностью;
//     * false - если вычисленный студентом и компьютером коэффициенты \"a\"
//     * совпадают с заданной точностью
//     * либо если одна из передаточных функций не создана;
//     * @param precision точность совпадения*/
//    public boolean overlapFs_a(double precision) {
//        try {
//            return (Math.abs(getStudentsFs().getA()-getFs().getA())<=precision);}
//        catch (Exception e) {
//            System.out.println("Overlap comparison of \"a\" parameters failed");
//            return false;
//    }
//    }
//
//    /**@return совпадение вычислений коэффициента \"b\" студента и компьютера 
//     * с заданной точностью
//     * true - если вычисленный студентом и компьютером коэффициенты \"b\"
//     * совпадают с заданной точностью;
//     * false - если вычисленный студентом и компьютером коэффициенты \"b\"
//     * совпадают с заданной точностью
//     * либо если одна из передаточных функций не создана;
//     * @param precision точность совпадения*/
//    public boolean overlapFs_b(double precision) {
//        try {
//            return (Math.abs(getStudentsFs().getB()-getFs().getB())<=precision);}
//        catch (Exception e) {
//            System.out.println("Overlap comparison of \"b\" parameters failed");
//            return false;
//    }
//    }
//
//    /**@return совпадение вычислений коэффициента \"c\" студента и компьютера 
//     * с заданной точностью
//     * true - если вычисленный студентом и компьютером коэффициенты \"c\"
//     * совпадают с заданной точностью;
//     * false - если вычисленный студентом и компьютером коэффициенты \"c\"
//     * совпадают с заданной точностью
//     * либо если одна из передаточных функций не создана;
//     * @param precision точность совпадения*/
//    public boolean overlapFs_c(double precision) {
//        try {
//            return (Math.abs(getStudentsFs().getC()-getFs().getC())<=precision);}
//        catch (Exception e) {
//            System.out.println("Overlap comparison of \"c\" parameters failed");
//            return false;
//    }
//    }
//
//    /**@return true, если введенные пользователем данные (k, a, b, c) совпадают с 
//     * вычисленными компьютером с заданной точностью.
//     * Иначе возвращает false
//     * @param precision точность сравнения */
//    public boolean overlapFsCheck(double precision) {
//        boolean overlap = overlapFs_k(precision);
//        overlap = overlap & overlapFs_a(precision);
//        overlap = overlap & overlapFs_b(precision);
//        overlap = overlap & overlapFs_c(precision);
//        if (overlap) System.out.println("Overlap check passed successfully!");
//        else System.out.println("Overlap check failed.");
//        return overlap;
//    }
    
    /**Проверка правильности решения, введенного на соответствующей странице
     * @param pageNumber номер страницы    */
    public void checkPage(int pageNumber) {
        switch (pageNumber) {
            case 0:
                checkPage0();
                break;
            case 1:
                checkPage1();
                break;
            case 2:
                checkPage2();
                break;
            case 3:
                checkPage3();
                break;
            case 4:
                checkPage4();
                break;
            case 5:
                checkPage5();
                break;
            case 6:
                checkPage6();
                break;
            case 7:
                checkPage7();
                break;
            case 8:
                checkPage8();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    /**Проверка правильности решения для страницы 1 [0]*/
    private void checkPage0() {
        getTestPU().check_fs_k(this.getFs().getK(), studData.getStud_k_fs());
        getTestPU().check_fs_a(this.getFs().getA(), studData.getStud_a_fs());
        getTestPU().check_fs_b(this.getFs().getB(), studData.getStud_b_fs());
        getTestPU().check_fs_c(this.getFs().getC(), studData.getStud_c_fs());
    }
    
    /**Проверка правильности решения для страницы 2 [1]*/
    private void checkPage1() {
        
    }
    
    /**Проверка правильности решения для страницы 3 [2]*/
    private void checkPage2() {
        
    }
    
    /**Проверка правильности решения для страницы 4 [3]*/
    private void checkPage3() {
        
    }
    
    /**Проверка правильности решения для страницы 5 [4]*/
    private void checkPage4() {
        
    }
    
    /**Проверка правильности решения для страницы 6 [5]*/
    private void checkPage5() {
        
    }
    
    /**Проверка правильности решения для страницы 7 [6]*/
    private void checkPage6() {
        
    }
    
    /**Проверка правильности решения для страницы 8 [7]*/
    private void checkPage7() {
        
    }
    
    /**Проверка правильности решения для страницы 9 [8]*/
    private void checkPage8() {
        
    }

    /**
     * @return the testPU
     */
    public TestPassingUnit getTestPU() {
        return testPU;
    }
}
