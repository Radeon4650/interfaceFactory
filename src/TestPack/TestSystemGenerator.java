package TestPack;

import DiffModesCommon.DataModel.Fs;

/**
 *
 * @author radeon
 */

class TestPassingUnit {
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
}


public class TestSystemGenerator extends DemoPack.DemoSystemGenerator{
    private Fs studentsFs;

    public TestSystemGenerator() {
        super();
//        setStudentsFs(0, 0, 0, 0);
    }

    /**@return передаточную функцию, посчитанную студентом     */
    public Fs getStudentsFs() {
        return studentsFs;
    }

    /** Формула представляется в виде Ф(s) = k/(a*s^2 + b*s + c)
     * @param init_k введенный студентом коеффициент k
     * @param init_a введенный студентом коеффициент a
     * @param init_b введенный студентом коеффициент b
     * @param init_c введенный студентом коеффициент c
     */
    public void setStudentsFs(double init_k, double init_a, double init_b, double init_c) {
        this.studentsFs = new Fs(init_k, init_a, init_b, init_c);
    }
 
    /**@return совпадение вычислений коэффициента \"k\" студента и компьютера 
     * с заданной точностью
     * true - если вычисленный студентом и компьютером коэффициенты \"k\"
     * совпадают с заданной точностью;
     * false - если вычисленный студентом и компьютером коэффициенты \"k\"
     * совпадают с заданной точностью
     * либо если одна из передаточных функций не создана;
     * @param precision точность совпадения*/
    public boolean overlapFs_k(double precision) {
        try {
            return (Math.abs(getStudentsFs().getK()-getFs().getK())<=precision);}
        catch (Exception e) {
            System.out.println("Overlap comparison of \"k\" parameters failed");
            return false;
    }
    }
    
    /**@return совпадение вычислений коэффициента \"a\" студента и компьютера 
     * с заданной точностью
     * true - если вычисленный студентом и компьютером коэффициенты \"a\"
     * совпадают с заданной точностью;
     * false - если вычисленный студентом и компьютером коэффициенты \"a\"
     * совпадают с заданной точностью
     * либо если одна из передаточных функций не создана;
     * @param precision точность совпадения*/
    public boolean overlapFs_a(double precision) {
        try {
            return (Math.abs(getStudentsFs().getA()-getFs().getA())<=precision);}
        catch (Exception e) {
            System.out.println("Overlap comparison of \"a\" parameters failed");
            return false;
    }
    }

    /**@return совпадение вычислений коэффициента \"b\" студента и компьютера 
     * с заданной точностью
     * true - если вычисленный студентом и компьютером коэффициенты \"b\"
     * совпадают с заданной точностью;
     * false - если вычисленный студентом и компьютером коэффициенты \"b\"
     * совпадают с заданной точностью
     * либо если одна из передаточных функций не создана;
     * @param precision точность совпадения*/
    public boolean overlapFs_b(double precision) {
        try {
            return (Math.abs(getStudentsFs().getB()-getFs().getB())<=precision);}
        catch (Exception e) {
            System.out.println("Overlap comparison of \"b\" parameters failed");
            return false;
    }
    }

    /**@return совпадение вычислений коэффициента \"c\" студента и компьютера 
     * с заданной точностью
     * true - если вычисленный студентом и компьютером коэффициенты \"c\"
     * совпадают с заданной точностью;
     * false - если вычисленный студентом и компьютером коэффициенты \"c\"
     * совпадают с заданной точностью
     * либо если одна из передаточных функций не создана;
     * @param precision точность совпадения*/
    public boolean overlapFs_c(double precision) {
        try {
            return (Math.abs(getStudentsFs().getC()-getFs().getC())<=precision);}
        catch (Exception e) {
            System.out.println("Overlap comparison of \"c\" parameters failed");
            return false;
    }
    }

    /**@return true, если введенные пользователем данные (k, a, b, c) совпадают с 
     * вычисленными компьютером с заданной точностью.
     * Иначе возвращает false
     * @param precision точность сравнения */
    public boolean overlapFsCheck(double precision) {
        boolean overlap = overlapFs_k(precision);
        overlap = overlap & overlapFs_a(precision);
        overlap = overlap & overlapFs_b(precision);
        overlap = overlap & overlapFs_c(precision);
        if (overlap) System.out.println("Overlap check passed successfully!");
        else System.out.println("Overlap check failed.");
        return overlap;
    }
}
