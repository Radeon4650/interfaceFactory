
package interfacefactory.DataModel;

import interfacefactory.DblNum;


public class Aw {   //A(w)
    /**@param k коеффициент числителя*/
    protected double k;             
    /**@param n первый коеффициент при w^2 в знаменателе*/
    protected double n;
    /**@param m второй коеффициент при w^2 в знаменателе*/
    protected double m;
    /**@param fA_w_count количество значений для построения графика АЧХ*/
    private final int fA_w_count = 11; 
    /**@param wValue массив значений частоты w для вычисления АЧХ*/
    private final double wValue [];
    /**@param fA_w табличные значения для построения графика АЧХ*/
    private double fA_w [] = new double[getfA_w_count()];
    /**@param Apr значение полосы пропускания*/
    private double Apr;
    /**@param wPr частота полосы пропускания*/
    private double wPr;
    /**@param e параметр для вычисления А(w)*/
    private double e;
    /**@param h параметр для вычисления А(w)*/
    private double h;
    
    /** Класс описания функции АЧХ
    * @param init_kA коеффициент числителя Ф(s)
    * @param T1 постоянная времени T1 Ф(s)
    * @param T2 постоянная времени T2 Ф(s)
    */
    public Aw (double init_kA, double T1, double T2)
    {
        wValue = new double[]{0, 5, 10, 20, 50, 60, 70, 80, 90, 100, 200};
        k = init_kA;
        m = T1*T1;
        n = T2*T2;
        e = Math.rint((T1+T2)*k*10000)/10000;
        h = T1*T2;
        for (int i = 0; i < fA_w_count; i++) {
            fA_w[i] = calc_A(wValue[i]);
        }
        Apr = Math.rint(1000*0.707*fA_w[0])/1000;
        calc_wPr();
    }

    /**Вычислить значение частоты полосы пропускания*/
    private void calc_wPr () {
        int i=0;
        while (getApr() < fA_w[i]) i++;
        double wCurr = wValue[i];
        double Acurr=fA_w[i];
        double dPrev = Acurr;
        final double cnt_precision = 0.5;
        while (Math.abs(getApr()-Acurr)<=Math.abs(getApr()-dPrev)) {
             dPrev=Acurr;
             wCurr-=cnt_precision;
             Acurr = Math.rint(1000*k/Math.sqrt((n*wCurr*wCurr+1)*(m*wCurr*wCurr+1)))/1000;
             }
        wPr = wCurr;
    }
    
    /**@return первый коеффициент при w^2 в знаменателе*/
    public double getN() {
        return n;
    }

    /**@return второй коеффициент при w^2 в знаменателе*/
    public double getM() {
        return m;
    }
    
    /**@return значение знаменателя A(w) для конкретного значения w.
     @param w - частота, для которой вычисляется значение АЧХ.*/
    protected final double calcDenum(double w) {
        return (n*w*w+1)*(m*w*w+1);
    }
    
    /**@return значение A(w) для конкретного значения w.
     @param w - частота, для которой вычисляется значение АЧХ.*/
    public final double calc_A (double w) {
        return (k/Math.sqrt(calcDenum(w)));
    }
    
    /**
     * @return строку в формате MathML для представления функции АЧХ в виде формулы 
     * A(w) = k/(n*w^2+1)*(m*w^2+1)
     */
    public String printInMathML() {
        DblNum M = new DblNum(m);
        DblNum N = new DblNum(n);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mi>A</mi>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    + "<mo>=</mo>"
                    + "<mfrac>"
                    + "<mn>"+String.valueOf(k)+"</mn>"
                    + "<msqrt><mrow>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(M.getNum())+"</mn>" //округление до 3 знаков после запятой
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(M.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>&#x03C9</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(N.getNum())+"</mn>"  //округление до 3 знаков после запятой
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(N.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>&#x03C9</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></msqrt>"
                    + "</mfrac>"
                + "</math>";
    }

    /**
     * @return строку в формате MathML для вычисления полосы пропускания
     */
    public String printInMathMLApr() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>A</mi>"
                    + "<mfenced><msub><mi>&#x03C9</mi>"
                    + "<mi>пр</mi></msub></mfenced>"
                    + "<mo>=</mo><mn>0.707</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mn>"+String.valueOf(fA_w[0])+"</mn>"
                    + "<mo>=</mo>"
                    + "<mn>"+String.valueOf(Apr)+"</mn>"
                    + "</mrow></math>";
    }
    
    /**@return строку в формате MathML со значением частоты полосы пропускания*/
    public String printInMathMLwPr() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>&#x03C9</mi>"
                    + "<mi>пр</mi></msub>"
                    + "<mo>=</mo><mn>"+String.valueOf(Math.round(wPr))+"</mn>"
                    + "<mtext> рад/с</mtext>"
                    + "</mrow></math>";
    }
    
    /**  @return значение частоты в массиве
         @param x - номер значения в массиве */
    public double getWValue(int x) {
        return wValue[x];
    }

    /** @return fA_w - список значений АЧХ  */
    public double getfA_w(int x) {
        return fA_w[x];
    }

    /** @return значение полосы пропускания   */
    public double getApr() {
        return Apr;
    }

    /** @return частоту полосы пропускания  */
    public double getwPr() {
        return wPr;
    }
    
    /**@return запись получения А(w) в формате MathML */
    public String a_wObtaining() {
        DblNum M = new DblNum(m);
        DblNum N = new DblNum(n);
        DblNum H = new DblNum(h);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>A</mi>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    + "<mo>=</mo><msqrt><mrow>"
                    + "<mfrac><mrow>"
                    + "<msup><mn>"+String.valueOf(k)
                    + "</mn><mn>2</mn></msup>"
                    + "<mo>&#x2219</mo>"
                    + "<msup><mfenced><mrow>"
                    + "<mn>1</mn><mo>-</mo>"
                    + "<mn>"+String.valueOf(H.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(H.getDegree())+"</mn>"
                    + "</msup><msup>"
                    + "<mi>&#x03C9</mi><mn>2</mn></msup>"
                    + "</mrow></mfenced><mn>2</mn></msup>"
                    + "<mo>+</mo><msup><mn>"+String.valueOf(e)
                    + "</mn><mn>2</mn></msup>"
                    + "<mo>&#x2219</mo>"
                    + "<msup><mi>&#x03C9</mi><mn>2</mn></msup>"
                    + "</mrow><mrow><msup>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(M.getNum())+"</mn>" //округление до 3 знаков после запятой
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(M.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>&#x03C9</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced><mn>2</mn></msup><msup>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(N.getNum())+"</mn>"  //округление до 3 знаков после запятой
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(N.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>&#x03C9</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced><mn>2</mn></msup>"
                    + "</mrow></mfrac>"
                    + "</mrow></msqrt></mrow></math>";
    }

    /** @return количество значений АЧХ для таблицы   */
    public int getfA_w_count() {
        return fA_w_count;
    }

}