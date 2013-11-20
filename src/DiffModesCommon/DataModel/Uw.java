package DiffModesCommon.DataModel;

import DiffModesCommon.DblNum;




public class Uw extends Aw {
    /**@param h параметр числителя при w^2*/    
    private double h;    //

    
    /** Класс описания действительной частотной функции:
    * U(w) = k*(1-h*w^2)/(n*w^2+1)*(m*w^2+1)
    * @param init_kA коеффициент числителя Ф(s)
    * @param T1 постоянная времени T1 Ф(s)
    * @param T2 постоянная времени T2 Ф(s)
    */
    public Uw (double init_kA, double T1, double T2) {
        super(init_kA, T1, T2);
        h=T1*T2;
    }
    
    /**@return параметр числителя при w^2*/
    public double getH() {
        return h;
    }
    
    /**@return значение действительной частотной функции для конкретного значения w.
     @param w - частота, для которой вычисляется значение АЧХ.*/
    public final double calc_U (double w) {
        return k*(1-h*w*w)/calcDenum(w);
    }
    
    /**
     * @return строку в формате MathML для представления действительной 
     * частотной функции в виде формулы: 
     * U(w) = k*(1-h*w^2)/(n*w^2+1)*(m*w^2+1)
     */
    @Override
    public String printInMathML() {
        DblNum M = new DblNum(m);
        DblNum N = new DblNum(n);
        DblNum H = new DblNum(h);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mi>U</mi>"
                    + "<mfenced><mi>&#x03C9</mi></mfenced>"
                    + "<mo>=</mo>"
                    + "<mfrac><mrow>"
                    + "<mn>"+String.valueOf(k)+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mfenced><mrow><mn>1</mn>"
                    + "<mo>-</mo>"
                    + "<mn>"+String.valueOf(H.getNum())+"</mn>" 
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(H.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>&#x03C9</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "</mrow></mfenced></mrow>"
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
}