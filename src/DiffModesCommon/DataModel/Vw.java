package DiffModesCommon.DataModel;

import DiffModesCommon.DblNum;




public class Vw extends Aw {
    /**@param e параметр числителя при w*/    
    private double e;  
    
    /** Класс описания мнимой частотной функции:
    * V(w) = -e*w/(n*w^2+1)*(m*w^2+1)
    * @param init_kA коеффициент числителя Ф(s)
    * @param T1 постоянная времени T1 Ф(s)
    * @param T2 постоянная времени T2 Ф(s)
    */
    public Vw (double init_kA, double T1, double T2) {
        super(init_kA, T1, T2);
        e = (T1+T2)*init_kA;
    }

    /**@return параметр числителя при w*/
    public double getE() {
        return e;
    }

    /**@return значение мнимой частотной функции для конкретного значения w.
     @param w - частота, для которой вычисляется значение АЧХ.*/
    public final double calc_V(double w) {
        return -e*w/calcDenum(w);
    }

    /**
     * @return строку в формате MathML для представления мнимой 
     * частотной функции в виде формулы: 
     * V(w) = -e*w/(n*w^2+1)*(m*w^2+1)
     */    
    @Override
    public String printInMathML() {
        DblNum M = new DblNum(m);
        DblNum N = new DblNum(n);
        DblNum E = new DblNum(e);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mi>V</mi>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    + "<mo>=-</mo>"
                    + "<mfrac><mrow>"
                    + "<mn>"+String.valueOf(E.getNum())+"</mn>" 
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(E.getDegree())+"</mn>"
                    + "</msup>"
                    + "<mi>&#x03C9</mi>"
                    + "</mrow>"
                    + "<mrow><mfenced><mrow>"
                    + "<mn>"+String.valueOf(M.getNum())+"</mn>" 
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
                    + "<mn>"+String.valueOf(N.getNum())+"</mn>"  
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
                    + "</mrow></mfenced></mrow>"
                    + "</mfrac>"
                + "</math>";
    }
    
    /**@return строку в МathMl по заданным коэффициентам e, mV, nV. */
    static public String printVw(String e, String mV, String nV) {
        String eTxt, mVTxt, nVTxt;
        
        eTxt =  printFromText(e, "e", "");
        mVTxt = printFromText(mV, "m", "V");
        nVTxt = printFromText(nV, "n", "V");
  
        String math = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>V</mi><mfenced><mi>ω</mi></mfenced>"
                    + "<mo>=-</mo><mfrac>"
                    + "<mrow>" + eTxt
                    + "<mi>ω</mi></mrow>"
                    + "<mrow><mfenced><mrow>"
                    + mVTxt + "<msup><mi>ω</mi><mn>2</mn></msup>"
                    + "<mo>+</mo><mn>1</mn></mrow></mfenced><mfenced><mrow>"
                    + nVTxt + "<msup><mi>ω</mi><mn>2</mn></msup>"
                    + "<mo>+</mo><mn>1</mn></mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>";
        return math;
    }
    
    /**@return строковое представление значения V(w)
     * Вычисляется по формуле V(w) = -e*w/((m*w^2+1)*(n*w^2+1)) */
    static public double calcV(String eInp, String mInp, String nInp, double w) {
        try {
            double e, m, n, value;
            e = Double.parseDouble(eInp);
            m = Double.parseDouble(mInp);
            n = Double.parseDouble(nInp);
            value = - (e*w)/((m*w*w + 1)*(n*w*w + 1));
            
            return Math.rint(10000*value)/10000;
        }
        catch (NumberFormatException nfe) {
            return -100;
        }
    }
}
