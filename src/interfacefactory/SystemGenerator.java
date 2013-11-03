/*
 * Генерирует значения коеффициентов для задачи в заданных пределах
 */

package interfacefactory;

import java.util.Random;

/**
 *
 * @author radeon
 */
public class SystemGenerator {
    /**@param k1MIN минимальное значение k для блока Wk1*/
    private final double k1MIN = 1;
    /**@param k1MAX максимальное значение k для блока Wk1*/
    private final double k1MAX = 4;
    
    /**@param k2MIN минимальное значение k для блока Wk2*/
    private final double k2MIN = 2.5;
    /**@param k2MAX максимальное значение k для блока Wk2*/
    private final double k2MAX = 4.5;
    
    /**@param k3MIN минимальное значение k для блока Wk3*/
    private final double k3MIN = 8.5;
    /**@param k3MAX максимальное значение k для блока Wk3*/
    private final double k3MAX = 10;
    /**@param T31MIN минимальное значение T1 для блока Wk3*/
    private final double T31MIN = 0.2;
    /**@param T31MAX максимальное значение T1 для блока Wk3*/
    private final double T31MAX = 0.3;
    /**@param T32MIN минимальное значение T2 для блока Wk3*/
    private final double T32MIN = 0.002;
    /**@param T32MAX максимальное значение T2 для блока Wk3*/
    private final double T32MAX = 0.003;
    
    /**@param k4MIN минимальное значение k для блока Wk4*/
    private final double k4MIN = -0.0085;
    /**@param k4MAX максимальное значение k для блока Wk4*/
    private final double k4MAX = -0.01;
    /**@param T41MIN минимальное значение T1 для блока Wk4*/
    private final double T41MIN = 0.2;
    /**@param T41MAX максимальное значение T1 для блока Wk4*/
    private final double T41MAX = 0.3;
    /**@param T42MIN минимальное значение T2 для блока Wk4*/
    private final double T42MIN = 0.002;
    /**@param T42MAX максимальное значение T2 для блока Wk4*/
    private final double T42MAX = 0.003;
    
    /**@param k5MIN минимальное значение k для блока Wk5*/
    private final double k5MIN = 0.07;
    /**@param k5MAX максимальное значение k для блока Wk5*/
    private final double k5MAX = 0.08;
    
    /**@param k6MIN минимальное значение k для блока Wk6*/
    private final double k6MIN = 1;
    /**@param k6MAX максимальное значение k для блока Wk6*/
    private final double k6MAX = 1.5;
    
    private Wk wk1;
    private Wk wk2;
    private Wd wd3;
    private Wd wd4;
    private Wk wk5;
    private Wk wk6;
    
    public SystemGenerator() {
        Random rnd = new Random();
        double k = (k1MAX-k1MIN)*rnd.nextDouble()+k1MIN;
        double t1, t2;
        wk1 = new Wk(k, "E", "Y", 0, 1, 1);
        k = (k2MAX-k2MIN)*rnd.nextDouble()+k2MIN;
        wk2 = new Wk(k, "Y", "Y", 1, 2, 2);
        k = (k3MAX-k3MIN)*rnd.nextDouble()+k3MIN;
        t1 = (T31MAX-T31MIN)*rnd.nextDouble()+T31MIN;
        t2 = (T32MAX-T32MIN)*rnd.nextDouble()+T32MIN;
        wd3 = new Wd(k, t1, t2, "Y", "Y", 2, 3, 3);
        k = (k4MAX-k4MIN)*rnd.nextDouble()+k4MIN;
        t1 = (T41MAX-T41MIN)*rnd.nextDouble()+T41MIN;
        t2 = (T42MAX-T42MIN)*rnd.nextDouble()+T42MIN;
        wd4 = new Wd(k, t1, t2, "F", "Y", 0, 4, 4);
        k = (k5MAX-k5MIN)*rnd.nextDouble()+k5MIN;
        wk5 = new Wk(k, "Y", "Y", 0, 5, 5);
        k = (k6MAX-k6MIN)*rnd.nextDouble()+k6MIN;
        wk6 = new Wk(k, "Y", "Y", 5, 6, 6);   
    }

    /** @return wk1 - передаточную функцию 1го блока*/
    public Wk getWk1() {
        return wk1;
    }

    /** @return wk2 - передаточную функцию 2го блока*/
    public Wk getWk2() {
        return wk2;
    }

    /** @return wd3 - передаточную функцию 3го блока*/
    public Wd getWd3() {
        return wd3;
    }

    /** @return wd4 - передаточную функцию 4го блока*/
    public Wd getWd4() {
        return wd4;
    }

    /** @return wk5 - передаточную функцию 5го блока*/
    public Wk getWk5() {
        return wk5;
    }

    /** @return wk6 - передаточную функцию 6го блока*/
    public Wk getWk6() {
        return wk6;
    }
}
