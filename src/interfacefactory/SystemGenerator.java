/*
 * Генерирует значения коеффициентов для задачи в заданных пределах
 */

package interfacefactory;

import interfacefactory.DataModel.Fs;
import interfacefactory.DataModel.Wk;
import interfacefactory.DataModel.Wd;
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
    private Fs fs;
    private final int af_len = 22;
    private final int[] w;
    private double [] u = new double[af_len];
    private double [] v = new double[af_len];
    
    public SystemGenerator() {
        Random rnd = new Random();
        double k = Math.rint(((k1MAX-k1MIN)*rnd.nextDouble()+k1MIN)*100)/100;
        double t1, t2;
        wk1 = new Wk(k, "E", "Y", 0, 1, 1);
        k = Math.rint(((k2MAX-k2MIN)*rnd.nextDouble()+k2MIN)*100)/100;
        wk2 = new Wk(k, "Y", "Y", 1, 2, 2);
        k = Math.rint(((k3MAX-k3MIN)*rnd.nextDouble()+k3MIN)*100)/100;
        t1 = Math.rint(((T31MAX-T31MIN)*rnd.nextDouble()+T31MIN)*1000)/1000;
        t2 = Math.rint(((T32MAX-T32MIN)*rnd.nextDouble()+T32MIN)*1000)/1000;
        wd3 = new Wd(k, t1, t2, "Y", "Y", 2, 3, 3);
        k = Math.rint(((k4MAX-k4MIN)*rnd.nextDouble()+k4MIN)*10000)/10000;
        wd4 = new Wd(k, t1, t2, "F", "Y", 0, 4, 4);
        k = Math.rint(((k5MAX-k5MIN)*rnd.nextDouble()+k5MIN)*1000)/1000;
        wk5 = new Wk(k, "Y", "Y", 0, 5, 5);
        k = Math.rint(((k6MAX-k6MIN)*rnd.nextDouble()+k6MIN)*100)/100;
        wk6 = new Wk(k, "Y", "Y", 5, 6, 6);   
        fs = new Fs(wk1, wk2, wd3, wk5, wk6);
        w = new int[] {0, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,
            1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000};
        for (int i = 0; i < af_len; i++) {
            u[i] = Math.rint(1000*fs.getU_w().calc_U(w[i]))/1000;
            v[i] = Math.rint(10000*fs.getV_w().calc_V(w[i]))/10000; 
        }
    }

    /**@return длину массивов для построения графика АФЧХ*/
    public int getAfLen() {
        return af_len;
    }
    
    /**@return значение частоты в массиве
     @param x номер элемента в массиве*/
    public int getW(int x) {
        return w[x];
    }
    
    /**@return значение действительной частотной функции в массиве
     @param x номер элемента в массиве*/
    public double getU(int x) {
        return u[x];
    }
    
    /**@return значение действительной частотной функции в массиве
     @param x номер элемента в массиве*/
    public double getV(int x) {
        return v[x];
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

    /** @return fs - передаточную функцию системы*/
    public Fs getFs() {
        return fs;
    }
}
