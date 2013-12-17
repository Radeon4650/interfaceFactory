
package DiffModesCommon.DataModel;

import DiffModesCommon.AppStyles;
import DiffModesCommon.DblNum;


class AwStruct {
    /**@param w частота ω*/
    private double w;
    /**@param A значение АЧХ для частоты ω*/
    private double A;

    public AwStruct() {
        this.w=0;
        this.A=0;
    }
    
    /** @return частоту ω  */
    public double getW() {
        return w;
    }

    /** @param w частота    */
    public void setW(double w) {
        this.w = w;
    }

    /** @return значение АЧХ для частоты ω  */
    public double getA() {
        return A;
    }

    /** @param A значение АЧХ   */
    public void setA(double A) {
        this.A = A;
    }
}

public class Aw {   //A(w)
    /**@param k коеффициент числителя*/
    protected double k;             
    /**@param n первый коеффициент при w^2 в знаменателе*/
    protected double n;
    /**@param m второй коеффициент при w^2 в знаменателе*/
    protected double m;
    /**@param fA_w_count количество значений для построения графика АЧХ*/
    private final int fA_w_count = 11; 
    
//    /**@param wValue массив значений частоты w для вычисления АЧХ*/
//    private final double wValue [];
//    /**@param fA_w табличные значения для построения графика АЧХ*/
//    private double fA_w [] = new double[getfA_w_count()];
    private AwStruct awArr [] = new AwStruct[fA_w_count];
    
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
        k = init_kA;
        m = T1*T1;
        n = T2*T2;
        e = Math.rint((T1+T2)*k*10000)/10000;
        h = T1*T2;
        fillAwArr();
        Apr = Math.rint(1000*0.707*awArr[0].getA())/1000;
        calc_wPr();
    }

    /**Вычислить значение частоты полосы пропускания*/
    private void calc_wPr () {
        int i=0;
        while (getApr() < awArr[i].getA()) i++;
        double wCurr = awArr[i].getW();
        double Acurr=awArr[i].getA();
        double dPrev = Acurr;
        final double cnt_precision = 0.5;
        while (Math.abs(getApr()-Acurr)<=Math.abs(getApr()-dPrev)) {
             dPrev=Acurr;
             wCurr-=cnt_precision;
             Acurr = Math.rint(1000*k/Math.sqrt((n*wCurr*wCurr+1)*(m*wCurr*wCurr+1)))/1000;
             }
        wPr = Math.round(wCurr);
    }
    
    /**@return ~void заполняет массив соответствующими значениями ω и А(ω)*/
    private void fillAwArr() {
        for (int i = 0; i < getfA_w_count(); i++) 
            awArr[i]=new AwStruct();
        awArr[0].setW(0); 
        awArr[1].setW(5);
        awArr[2].setW(10);
        awArr[3].setW(20);
        awArr[4].setW(50);
        awArr[5].setW(60);
        awArr[6].setW(70);
        awArr[7].setW(80);
        awArr[8].setW(90);
        awArr[9].setW(100);
        awArr[10].setW(200);
        for (int i = 0; i < getfA_w_count(); i++) {
            awArr[i].setA(calc_A(awArr[i].getW()));
        }
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
     * @param langPr перевод подписи [w_]пр на текущий язык
     */
    public String printInMathMLApr(String langPr) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>A</mi>"
                    + "<mfenced><msub><mi>&#x03C9</mi><mi>"
                    + langPr
                    + "</mi></msub></mfenced>"
                    + "<mo>=</mo><mn>0.707</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mn>"+String.valueOf(awArr[0].getA())+"</mn>"
                    + "<mo>=</mo>"
                    + "<mn>"+String.valueOf(Apr)+"</mn>"
                    + "</mrow></math>";
    }
    
    /**@return строку в формате MathML со значением частоты полосы пропускания
     @param langPr перевод подписи [w_]пр на текущий язык
     @param langRad перевод подписи рад/с на текущий язык*/
    public String printInMathMLwPr(String langPr, String langRad) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><msub><mi>&#x03C9</mi><mi>"
                    + langPr
                    + "</mi></msub>"
                    + "<mo>=</mo><mn>"+String.valueOf(wPr)+"</mn>"
                    + "<mtext> "
                    + langRad
                    + "</mtext>"
                    + "</mrow></math>";
    }
    
    /**  @return значение частоты в массиве
         @param x - номер значения в массиве */
    public double getWValue(int x) {
        return awArr[x].getW();
    }

    /** @return fA_w - список значений АЧХ  */
    public double getfA_w(int x) {
        return awArr[x].getA();
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
    
    /** A(w) = k/sqrt((m*w*w+1)*(n*w*w+1)) */
    public static double calc_A(double k, double m, double n, double w) {
        return k/Math.sqrt((m*w*w + 1)*(n*w*w + 1));
    }
    
    /**@return Параметр с нижним индексом, или число в формате a*10^b 
     * @param textSource текст, который необходимо представить
     * в заданном формате (a*10^b)
     * @param replCoeff замещающий текст, если преобразование не удалось
     * @param replCoeffIndex нижний индекс замещающего текста 
        если символы отсутствуют, не отображается */
    public static String printFromText(final String textSource, String replCoeff, String replCoeffIndex) {
        String txt = textSource;
        if (txt.equals("")) {
            if (replCoeffIndex.equals(""))
                txt = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>" + replCoeff + "</mi>";
            else txt = "<msub mathcolor='#"+ AppStyles.wrongRedColor() + "'><mi>" + replCoeff + "</mi><mi>" 
                    + replCoeffIndex + "</mi></msub>";
        }
        else try {
            double e = Double.parseDouble(txt);
            if (e<0.01) {
                DblNum E = new DblNum(e);
                txt = "<mn>" + String.valueOf(E.getNum()) 
                        + "</mn><mo>&#x2219</mo>"
                        + "<msup><mn>10</mn><mn>"
                        + String.valueOf(E.getDegree())
                        + "</mn></msup><mo>&#x2219</mo>";
            }
            else txt = "<mn>" + txt + "</mn>";
        }
        catch (NumberFormatException nfe)
            { txt = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>" + txt + "</mi>"; }
        return txt;
    }
}