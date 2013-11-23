/*
 * Генерирует значения коеффициентов для задачи в заданных пределах
 */

package DemoPack;

import DiffModesCommon.DataModel.Fs;
import DiffModesCommon.DataModel.Wk;
import DiffModesCommon.DataModel.Wd;
import DiffModesCommon.DblNum;
import DiffModesCommon.PromptSet;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author radeon
 */

class UVstruct {
    /**@param w частота*/
    private double w;
    /**@param U действительная часть*/
    private double U;
    /**@param V мнимая часть*/
    private double V;
    
    public UVstruct() {
        this.w=0;
        this.V=0;
        this.U=0;
    }

    /** @return частоту ω */
    public double getW() {
        return w;
    }

    /** @param w частота ω    */
    public void setW(double w) {
        this.w = w;
    }

    /**@return действительную часть U(ω)     */
    public double getU() {
        return U;
    }

    /** @param U действительная часть   */
    public void setU(double U) {
        this.U = U;
    }

    /** @return мнимую часть V(ω)  */
    public double getV() {
        return V;
    }

    /** @param V мнимая часть    */
    public void setV(double V) {
        this.V = V;
    }
}
        
public class DemoSystemGenerator {
    /**@param k1MIN минимальное значение k для блока Wk1*/
    private double k1MIN;
    /**@param k1MAX максимальное значение k для блока Wk1*/
    private double k1MAX;
    
    /**@param k2MIN минимальное значение k для блока Wk2*/
    private double k2MIN;
    /**@param k2MAX максимальное значение k для блока Wk2*/
    private double k2MAX;
    
    /**@param k3MIN минимальное значение k для блока Wk3*/
    private double k3MIN;
    /**@param k3MAX максимальное значение k для блока Wk3*/
    private double k3MAX;
    /**@param T31MIN минимальное значение T1 для блока Wk3*/
    private double T31MIN;
    /**@param T31MAX максимальное значение T1 для блока Wk3*/
    private double T31MAX;
    /**@param T32MIN минимальное значение T2 для блока Wk3*/
    private double T32MIN;
    /**@param T32MAX максимальное значение T2 для блока Wk3*/
    private double T32MAX;
    
    /**@param k4MIN минимальное значение k для блока Wk4*/
    private double k4MIN;
    /**@param k4MAX максимальное значение k для блока Wk4*/
    private double k4MAX;
    
    /**@param k5MIN минимальное значение k для блока Wk5*/
    private double k5MIN;
    /**@param k5MAX максимальное значение k для блока Wk5*/
    private double k5MAX;
    
    /**@param k6MIN минимальное значение k для блока Wk6*/
    private double k6MIN;
    /**@param k6MAX максимальное значение k для блока Wk6*/
    private double k6MAX;
    
    private Wk wk1;
    private Wk wk2;
    private Wd wd3;
    private Wd wd4;
    private Wk wk5;
    private Wk wk6;
    private Fs fs;
    /**@param af_len длина массива для построения АФЧХ*/
    private final int af_len = 22;
    /**@param wuvArr массив структур для хранения значения ω, U(ω), V(ω)*/
    private UVstruct[] wuvArr = new UVstruct[af_len];

    private void loadAcsProperties(String fileName) {
        try {
//  Пробуем считать настройки из файла
            Properties dsgProp = new Properties();
            dsgProp.load(getClass().getClassLoader().getResourceAsStream(fileName));
            System.out.println("File <" +fileName+ "> is opened, ACS properties are successfully loaded.");
            k1MIN=Double.parseDouble((dsgProp.getProperty("k1MIN", "1")));
            k1MAX=Double.parseDouble((dsgProp.getProperty("k1MAX", "4")));
            k2MIN=Double.parseDouble((dsgProp.getProperty("k2MIN", "2.5")));
            k2MAX=Double.parseDouble((dsgProp.getProperty("k2MAX", "4.5")));
            k3MIN=Double.parseDouble((dsgProp.getProperty("k3MIN", "8.5")));
            k3MAX=Double.parseDouble((dsgProp.getProperty("k3MAX", "10")));
            T31MIN=Double.parseDouble((dsgProp.getProperty("T31MIN", "0.2")));
            T31MAX=Double.parseDouble((dsgProp.getProperty("T31MAX", "0.3")));
            T32MIN=Double.parseDouble((dsgProp.getProperty("T32MIN", "0.002")));
            T32MAX=Double.parseDouble((dsgProp.getProperty("T32MAX", "0.003")));
            k4MIN=Double.parseDouble((dsgProp.getProperty("k4MIN", "-0.0085")));
            k4MAX=Double.parseDouble((dsgProp.getProperty("k4MAX", "-0.01")));
            k5MIN=Double.parseDouble((dsgProp.getProperty("k5MIN", "0.07")));
            k5MAX=Double.parseDouble((dsgProp.getProperty("k5MAX", "0.08")));
            k6MIN=Double.parseDouble((dsgProp.getProperty("k6MIN", "1")));
            k6MAX=Double.parseDouble((dsgProp.getProperty("k6MAX", "1.5")));
        }
        catch (IOException ex){
// При обнаружении ошибки задаем параметры с помощью хард-кода            
            System.out.println("I/O Error. Setting the standard ACS properties.");
            k1MIN=1;        k3MIN=8.5;      T32MIN=0.002;       k5MIN=0.07;
            k1MAX=4;        k3MAX=10;       T32MAX=0.003;       k5MAX=0.08;
            k2MIN=2.5;      T31MIN=0.2;     k4MIN=-0.0085;      k6MIN=1; 
            k2MAX=4.5;      T31MAX=0.3;     k4MAX=-0.01;        k6MAX=1.5;
        }
    }
    
    public DemoSystemGenerator() {
        
        loadAcsProperties("DiffModesCommon/SystemGenerator.properties");        
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
        setWuvArr();
    }

    /**@return ~void записывает в массив константные значения частоты
     для вычисления U(ω) и V(ω)*/
    private void setWarr() {
        wuvArr[0].setW(0);
        wuvArr[1].setW(50);
        wuvArr[2].setW(100);
        wuvArr[3].setW(200);
        wuvArr[4].setW(300);
        wuvArr[5].setW(400);
        wuvArr[6].setW(500);
        wuvArr[7].setW(600);
        wuvArr[8].setW(700);
        wuvArr[9].setW(800);
        wuvArr[10].setW(900);
        wuvArr[11].setW(1000);
        wuvArr[12].setW(1100);
        wuvArr[13].setW(1200);
        wuvArr[14].setW(1300);
        wuvArr[15].setW(1400);
        wuvArr[16].setW(1500);
        wuvArr[17].setW(1600);
        wuvArr[18].setW(1700);
        wuvArr[19].setW(1800);
        wuvArr[20].setW(1900);
        wuvArr[21].setW(2000);
    }
  
    /**@return ~void выделяет память для каждого элемента массива, а также
     * вычисляет и записывает в массив значения U(ω) и V(ω)*/
    private void setWuvArr() {
        for (int i = 0; i < getAfLen(); i++) 
            wuvArr[i]=new UVstruct();
        setWarr();
        for (int i = 0; i < getAfLen(); i++) {
            wuvArr[i].setU(Math.rint(1000*fs.getU_w().calc_U(wuvArr[i].getW()))/1000);
            wuvArr[i].setV(Math.rint(10000*fs.getV_w().calc_V(wuvArr[i].getW()))/10000); 
        }
    }
    
    /**@return длину массивов для построения графика АФЧХ*/
    public int getAfLen() {
        return af_len;
    }
    
    /**@return значение частоты в массиве
     @param x номер элемента в массиве*/
    public double getW(int x) {
        return wuvArr[x].getW();
    }
    
    /**@return значение действительной частотной функции в массиве
     @param x номер элемента в массиве*/
    public double getU(int x) {
        return wuvArr[x].getU();
    }
    
    /**@return значение действительной частотной функции в массиве
     @param x номер элемента в массиве*/
    public double getV(int x) {
        return wuvArr[x].getV();
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
    
    
    /**
     * @param lang языковое расширение приложения
     * @return расширенное представление того, как получается передаточная 
     * функция системы*/
    public String printFullFsObtainingInMathML(ResourceBundle lang) {
        String denomStr = "<mrow>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(wd3.getT1())+"</mn>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(wd3.getT2())+"</mn>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow>";
        
        String enumStr = "<mn>" + String.valueOf(getWk1().getK()) + "</mn>"
                + "<mo>&#x2219</mo>"
                + "<mn>" + String.valueOf(getWk2().getK()) + "</mn>"
                + "<mo>&#x2219</mo>"
                + "<mn>" + String.valueOf(getWd3().getK()) + "</mn>"
                + "<mo>&#x2219</mo>"
                + "<mn>" + String.valueOf(getWk5().getK()) + "</mn>";
        
        String addStr = "<mn>" + String.valueOf(getWk1().getK()) + "</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mn>" + String.valueOf(getWk2().getK()) + "</mn>"
                    + "<mo>&#x2219</mo>"
                    +"<mfrac>"
                    + "<mn>"+String.valueOf(wd3.getK())+"</mn>"
                    + denomStr
                    + "</mfrac>"
                    + "<mo>&#x2219</mo>"
                    + "<mn>" + String.valueOf(getWk5().getK()) + "</mn>";
        
        String formula = PromptSet.fsEquation();
        formula = "<html><body bgcolor=\"#A0BEC4\"><p align=\"center\"><b>" 
                + lang.getString("Demo.p1.detOfCalc") 
                + "</b></p>"
                + formula.substring(0, formula.indexOf("</math>"));
        
        formula += "<mo>=</mo>"
                + "</math><br><br><math>"
                + "<mrow><mo>=</mo><mfrac><mrow>"
                + addStr
                + "</mrow><mrow>"
                + "<mn>1</mn><mo>+</mo>"
                + addStr
                + "<mo>&#x2219</mo>"
                + "<mn>" + String.valueOf(wk6.getK()) + "</mn>"
                + "</mrow></mfrac><mo>=</mo></mrow>"
                + "</math><br><br><math>"
                + "<mrow><mo>=</mo>"
                + "<mfrac><mrow>"
                + enumStr
                + "</mrow>"
                + denomStr
                + "</mfrac><mo>&#x2219</mo><mfrac>"
                + denomStr
                + "<mrow>"
                + denomStr
                + "<mo>+</mo>"
                + enumStr
                + "<mo>&#x2219</mo>"
                + "<mn>" + String.valueOf(wk6.getK())+"</mn>"
                + "</mrow></mfrac><mo>=</mo></mrow>";
        
        double enumCalc = wk1.getK()*wk2.getK()*wd3.getK()*wk5.getK();
        DblNum e = new DblNum(wd3.getT1()*wd3.getT2());
        formula += "</math><br><br><math>"
                + "<mrow><mo>=</mo><mfrac>"
                + "<mn>" + String.valueOf(Math.rint(enumCalc*1000)/1000) + "</mn>"
                + "<mrow><mfenced><mrow>"
                + "<mn>" + String.valueOf(e.getNum()) 
                + "</mn><mo>&#x2219</mo><msup>"
                + "<mn>10</mn>"
                + "<mn>" + String.valueOf(e.getDegree()) + "</mn>"
                + "</msup></mn>"
                + "<msup><mi>s</mi><mn>2</mn></msup>"
                + "<mo>+</mo>"
                + "<mn>" + String.valueOf(wd3.getT1()+wd3.getT2()) + "</mn>"
                + "<mi>s</mi>"
                + "<mo>+</mo><mn>1</mn>"
                + "</mrow></mfenced><mo>+</mo>";
        
        enumCalc = Math.rint(enumCalc*wk6.getK()*1000)/1000;
        addStr = getFs().printInMathMLWith_abc_s();
        addStr = addStr.substring(addStr.lastIndexOf("=</mo>")+6);
        formula += "<mn>" + String.valueOf(enumCalc) + "</mn>"
                + "</mrow></mfrac><mo>&#x2219</mo><mfrac>"
                + "<mn>" + String.valueOf(enumCalc+1) + "</mn>"
                + "<mn>" + String.valueOf(enumCalc+1) + "</mn>"
                + "</mfrac><mo>=</mo></mrow>"
                + "</math><br><br><math>"
                + "<mo>=</mo>"
                + addStr + ".</body></html>";
        return formula;
    }
}
