package interfacefactory;

/**
 *Класс, в котором хранятся число в обычном представлении (double)
 * и приведенное к виду а∙10^b 
 * например, dblNum == 0.00023;
 *           num == 2.3;
 *           degree == 4;
 * @param number - вещественное число, которое нужно представить как число и показатель степени при 10. 
 * @author Radeon
 */
public class DblNum {
    private double num;       
    private int degree;
    private double dblNum;
    
    public DblNum(double number) {
        dblNum = number;
        redefDegree();
    }
    
    private void redefDegree() {
        num = Math.abs(getDblNum());
        degree = 0;
        while (getNum()<=1)
        {
            degree -- ;
            num *= 10;
        }
        num = Math.signum(getDblNum())*Math.rint(getNum()*1000)/1000;
    }

    /**@return число, приведенное к 1 знаку перед запятой*/
    public double getNum() {
        return num;
    }

    /**@return показатель степени при 10*/
    public int getDegree() {
        return degree;
    }

    /**@return начальное число с плавающей точкой*/
    public double getDblNum() {
        return dblNum;
    }
}