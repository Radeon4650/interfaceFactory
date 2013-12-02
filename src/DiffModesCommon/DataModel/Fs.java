package DiffModesCommon.DataModel;

import DiffModesCommon.AppStyles;
import DiffModesCommon.DblNum;


public class Fs {     
    /** @param k коеффициент числителя */
    private double k; 
    /**@param t1 постоянная времени T1*/
    private double t1;  
    /**@param t2 постоянная времени T2*/
    private double t2; 
    /**@param a коеффициент при s^2*/
    private double a;     
    /**@param b коеффициент при s^1*/
    private double b;     
    /**@param c коеффициент при s^0*/
    private double c; 
    /**@param D дискриминант характеристического уравнения*/
    private double D;
    /**@param s1 первый корень характеристического уравнения*/
    private double s1;  
    /**@param s2 второй корень характеристического уравнения*/
    private double s2; 
    /**@param u_w действительная частотная функция системы*/
    private Uw u_w;
    /**@param v_w мнимая частотная функция системы*/
    private Vw v_w;
    /**@param a_w функция АЧХ*/
    private Aw a_w;
    
    /** Класс описания передаточной функции Ф(s) во всех вариантах ее появления в GUI.
    * При вычислении считаем, что Мн=0.
    * 
    * Конструктор #1:
    * @param init_k коеффициент числителя
    * @param init_a коеффициент при s^2
    * @param init_b коеффициент при s^1
    * @param init_c коеффициент при s^0
    */
    public Fs(double init_k, double init_a, double init_b, double init_c) {
        k = init_k;
        a = init_a;
        b = init_b;
        c = init_c;
        count_D();
        count_s1s2();
        count_t1t2();
        u_w = new Uw(k, t1, t2);
        v_w = new Vw(k, t1, t2);
        a_w = new Aw(k, t1, t2);
    }
    
    /** Класс описания передаточной функции Ф(s) во всех вариантах ее появления в GUI.
    * При вычислении считаем, что Мн=0.
    * Конструктор #2:
    * @param wk1 передаточная функция простейшего структурного блока (#1 на схеме)
    * @param wk2 передаточная функция простейшего структурного блока (#2 на схеме)
    * @param wd3 передаточная функция структурного блока 2го порядка (#3 на схеме)
    * @param wk5 передаточная функция простейшего структурного блока (#5 на схеме)
    * @param wk6 передаточная функция простейшего структурного блока (#6 на схеме)
    */
    public Fs(Wk wk1, Wk wk2, Wd wd3, Wk wk5, Wk wk6) {
        c = wk1.getK()*wk2.getK()*wd3.getK()*wk5.getK()*wk6.getK()+1;
        k = Math.rint(1000*wk1.getK()*wk2.getK()*wd3.getK()*wk5.getK()/c)/1000;
        a = wd3.getT1()*wd3.getT2()/c;
        b = (wd3.getT1()+wd3.getT2())/c;
        c = 1;
        count_D();
        count_s1s2();
        count_t1t2();
        u_w = new Uw(k, t1, t2);
        v_w = new Vw(k, t1, t2);
        a_w = new Aw(k, t1, t2);
    }
    
    /**Рассчитать значение дискриминанта характеристического уравнения 
     * и внести его в поле D*/
    private void count_D () {
        D = b*b - 4*a*c;
    } 
    
    /**Рассчитать значения корней характеристического уравнения и занести их 
     в поля s1 и s2*/
    private void count_s1s2 () {
        if (D>0) {
            s1 = Math.rint(100*(-b-Math.sqrt(D))/(2*a))/100;
            s2 = Math.rint(100*(-b+Math.sqrt(D))/(2*a))/100;
        }
        else if (D==0) {
            s1=s2=-b/2*a;
        }
        else s1=s2=0;
    }

    /**Рассчитать значения постоянных времени и занести их в поля Т1 и Т2*/
    private void count_t1t2 () {
        if (s1!=0) t1 = Math.abs(Math.rint(10000/s1)/10000); else t1 =0;
        if (s2!=0) t2 = Math.abs(Math.rint(10000/s2)/10000); else t2 =0;
    }
    
    /**@return коеффициент при s^2*/
    public double getA() {
        return a;
    }

    /**@return коеффициент при s^1*/
    public double getB() {
        return b;
    }

    /**@return коеффициент при s^0*/
    public double getC() {
        return c;
    }

     /**
     * @return строку в формате MathML для описания передаточной функции 
     * в формате Ф(s) = k/(T1s+1)(T2s+1)     */
    public String printInMathMLWith_t1t2_s () {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mi>G</mi><mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac>"
                    + "<mn>"+String.valueOf(getK())+"</mn>"
                    + "<mrow>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(getT1())+"</mn>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(getT2())+"</mn>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>";
    }

     /**
     * @return строку в формате MathML для описания передаточной функции 
     * в формате Ф(jw) = k/(T1jw+1)(T2jw+1)     */
    public String printInMathMLWith_t1t2_jw () {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>j&#x03C9</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>j&#x03C9</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mi>G</mi><mfenced><mi>j&#x03C9</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac>"
                    + "<mn>"+String.valueOf(getK())+"</mn>"
                    + "<mrow>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(getT1())+"</mn>"
                    + "<mi>j&#x03C9</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(getT2())+"</mn>"
                    + "<mi>j&#x03C9</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>";
    }

     /**
     * @return строку в формате MathML для описания передаточной функции, умноженной
     * на комплексно-сопряженное выражение в формате 
     * Ф(jw) = (k/(T1jw+1)(T2jw+1))*((-T1jw+1)(-T2jw+1)/(-T1jw+1)(-T2jw+1))
     */
    public String printInMathMLwithComplConExpr() {
        String webContent = this.printInMathMLWith_t1t2_jw();
        webContent=webContent.substring(0, webContent.lastIndexOf("</mrow></math>"));
        webContent+="<mo>&#x2219</mo><mfrac><mrow>"
                    + "<mfenced><mrow><mn>"+String.valueOf(-t1)+"</mn>"
                    + "<mi>j&#x03C9</mi>"
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow><mn>"+String.valueOf(-t2)+"</mn>"
                    + "<mi>j&#x03C9</mi>"
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow><mrow>"
                    + "<mfenced><mrow><mn>"+String.valueOf(-t1)+"</mn>"
                    + "<mi>j&#x03C9</mi>"
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow><mn>"+String.valueOf(-t2)+"</mn>"
                    + "<mi>j&#x03C9</mi>"
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac></mrow></math>";
        return webContent;
    }

    /**@return строку в формате MathML для описания передаточной функции 
     в формате Ф(jw)= U(w)-jV(w) */
    public String printInMathMLwithUwVw () {
        String u = u_w.printInMathML();
        String v = v_w.printInMathML();
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi><mfenced><mrow><mi>j</mi>"
                    + "<mi>&#x03C9</mi></mrow></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mrow><mi>j</mi><mi>&#x03C9</mi></mrow>"
                    + "</mfenced></mrow><mrow>"
                    + "<mi>G</mi><mfenced><mrow><mi>j</mi>"
                    + "<mi>&#x03C9</mi></mrow></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + u.substring(u.indexOf("=</mo>")+6, u.indexOf("</math>"))
                    + "</mrow></math>"
                    + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mo>-</mo><mi>j</mi>"
                    + v.substring(v.indexOf("=-</mo>")+7, v.indexOf("</math>"))
                + "</mrow></math>";
    }
    
    
     /**
     * @return строку в формате MathML для описания передаточной функции 
     * в формате Ф(s) = k/(a*s^2+b*s+c)   */
    public String printInMathMLWith_abc_s () {
        DblNum A = new DblNum(a);
        DblNum B = new DblNum(b);
        String c_str;
        if (c<0) {                    
                    DblNum C = new DblNum(c);
                    c_str= "<mn>"+String.valueOf(C.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(C.getDegree())+"</mn>"
                    + "</msup>";}
        else c_str = "<mn>"+String.valueOf(Math.round(c))+"</mn>";
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mi>G</mi><mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac>"
                    + "<mn>"+String.valueOf(getK())+"</mn>"
                    + "<mrow>"
                    + "<mn>"+String.valueOf(A.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(A.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>s</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + "<mn>"+String.valueOf(B.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(B.getDegree())+"</mn>"
                    + "</msup>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + c_str
                    + "</mrow></mfrac></mrow>"
                + "</math>";
    }

     /** @param k_inp - введенный пользователем коеффициент k
     * @param a_inp - введенный пользователем коеффициент a
     * @param b_inp - введенный пользователем коеффициент b
     * @param c_inp - введенный пользователем коеффициент c
     * @return строку в формате MathML для описания передаточной функции 
     * в формате Ф(s) = k/(a*s^2+b*s+c)   */
    public static String printInMathMLWith_abc_s (String k_inp, String a_inp, String b_inp, String c_inp) {
        String a_out, b_out, c_out, k_out;
        String wrongColor = AppStyles.wrongRedColor();
//------------------------------------------------------------------------------
        try {
            if (Double.parseDouble(c_inp)<0) {                    
                DblNum C = new DblNum(Double.parseDouble(c_inp));
                c_out= "<mn>"+String.valueOf(C.getNum())+"</mn>"
                + "<mo>&#x2219</mo>"
                + "<msup>"
                + "<mn>10</mn>"
                + "<mn>"+String.valueOf(C.getDegree())+"</mn>"
                + "</msup>";}
            else c_out = "<mn>"+String.valueOf(Math.round(Double.parseDouble(c_inp)))+"</mn>";
        }
        catch (NumberFormatException ex) {
            c_out = "<mi mathcolor='#"+ wrongColor + "'>" + c_inp + "</mi>";
        }
//------------------------------------------------------------------------------        
        try {
            if (Double.parseDouble(a_inp)<0.1) {
                DblNum A = new DblNum(Double.parseDouble(a_inp));
                a_out = "<mn>"+String.valueOf(A.getNum())+"</mn>"
                        + "<mo>&#x2219</mo>"
                        + "<msup>"
                        + "<mn>10</mn>"
                        + "<mn>"+String.valueOf(A.getDegree())+"</mn>"
                        + "</msup>";}
            else a_out = "<mn>" + String.valueOf(Double.parseDouble(a_inp)) + "</mn>";
        }
        catch (NumberFormatException ex) {
            a_out = "<mi mathcolor='"+ wrongColor + "'>" + a_inp + "</mi>";
        }
//------------------------------------------------------------------------------        
        try {
            if (Double.parseDouble(b_inp)<0.1) {
            DblNum B = new DblNum(Double.parseDouble(b_inp));
            b_out = "<mn>"+String.valueOf(B.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(B.getDegree())+"</mn>"
                    + "</msup>";}
            else b_out = "<mn>" + String.valueOf(Double.parseDouble(b_inp)) + "</mn>";
        }
        catch (NumberFormatException ex) {
            b_out = "<mi mathcolor='"+ wrongColor + "'>" + b_inp + "</mi>";
        }
//------------------------------------------------------------------------------        
        try {
            k_out="<mn>"+String.valueOf(Double.parseDouble(k_inp))+"</mn>";
        }
        catch (NumberFormatException ex) {
            k_out = "<mi mathcolor='"+ wrongColor + "'>" + k_inp + "</mi>";
        }
//------------------------------------------------------------------------------            
            
        return "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow><mrow>"
                    + "<mi>G</mi><mfenced><mi>s</mi></mfenced>"
                    + "</mrow></mfrac><mo>=</mo>"
                    + "<mfrac>"
                    + k_out
                    + "<mrow>"
                    + a_out
                    + "<msup>"
                    + "<mi>s</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + b_out
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + c_out
                    + "</mrow></mfrac></mrow>"
                + "</math>";
    }
    
    
    
    
     /**
     * @return строку в формате MathML для записи характеристического уравнения 
     * a*s^2+b*s+c=0   */
    public String printChEquationInMathML () {
        DblNum A = new DblNum(a);
        DblNum B = new DblNum(b);
        String c_str;
        if (c<0) {                    
                    DblNum C = new DblNum(c);
                    c_str= "<mn>"+String.valueOf(C.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(C.getDegree())+"</mn>"
                    + "</msup>";}
        else c_str = "<mn>"+String.valueOf(Math.round(c))+"</mn>";
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mn>"+String.valueOf(A.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(A.getDegree())+"</mn>"
                    + "</msup>"
                    + "<msup>"
                    + "<mi>s</mi>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>+</mo>"
                    + "<mn>"+String.valueOf(B.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(B.getDegree())+"</mn>"
                    + "</msup>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + c_str
                    + "<mo>=</mo>"
                    + "<mn>0</mn>"
                    + "</mrow>"
                + "</math>";
    }

  
    
    /**@return строку в формате MathML для записи дискриминанта 
     * D = b^2 - 4*a*c = ... */
    public String printDInMathML () {
        DblNum A = new DblNum(a);
        DblNum B = new DblNum(b);
        DblNum DD = new DblNum(D);
        String c_str;
        if (c<-1) {                    
             DblNum C = new DblNum(c);
             c_str= "<mn>"+String.valueOf(Math.abs(C.getNum()))+"</mn>"
             + "<mo>&#x2219</mo>"
             + "<msup>"
             + "<mn>10</mn>"
             + "<mn>"+String.valueOf(C.getDegree())+"</mn>"
             + "</msup>";}
        else c_str = "<mn>"+String.valueOf(Math.abs(Math.round(c)))+"</mn>";
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>D</mi>"
                    + "<mo>=</mo>"
                    + "<msup>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(B.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(B.getDegree())+"</mn>"
                    + "</msup>"
                    + "</mrow></mfenced>"
                    + "<mn>2</mn>"
                    + "</msup>"
                    + "<mo>"+(a*c>=0?"-":"+")+"</mo>"
                    + "<mn>4</mn><mo>&#x2219</mo>"
                    + "<mn>"+String.valueOf(Math.abs(A.getNum()))+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(A.getDegree())+"</mn>"
                    + "</msup>"
                    + "<mo>&#x2219</mo>"
                    + c_str
                    + "<mo>=</mo><mrow mathsize='1.2em'>"
                    + "<mn>"+String.valueOf(DD.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(DD.getDegree())+"</mn>"
                    + "</msup>"
                    + "</mrow></mrow>"
                + "</math>";
    }
 
    /**@return строку вычисления Т1 в формате MathML в виде:
       T1 = 1/s1 = valueOf(t1); */
    public String printT1inMathML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<msub><mi>T</mi>"
                    + "<mn>1</mn></msub>"
                    + "<mo>=</mo>"
                    + "<mfrac><mn>1</mn>"
                    + (s1>0? "": "<mfenced separators=\"\" open=\"|\" close=\"|\">") 
                    + "<mn>"+String.valueOf(s1)+"</mn>"
                    + (s1>0? "": "</mfenced>")
                    + "</mfrac><mo>=</mo>"
                    + "<mn mathsize='1.2em'>"+String.valueOf(t1)+"</mn>"
                    + "</mrow>"
                + "</math>";
    }
    
    /**@return строку вычисления Т2 в формате MathML в виде:
       T2 = 1/s2 = valueOf(t2); */
    public String printT2inMathML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<msub><mi>T</mi>"
                    + "<mn>2</mn></msub>"
                    + "<mo>=</mo>"
                    + "<mfrac><mn>1</mn>"
                    + (s2>0? "": "<mfenced separators=\"\" open=\"|\" close=\"|\">") 
                    + "<mn>"+String.valueOf(s2)+"</mn>"
                    + (s2>0? "": "</mfenced>")
                    + "</mfrac><mo>=</mo>"
                    + "<mn mathsize='1.2em'>"+String.valueOf(t2)+"</mn>"
                    + "</mrow>"
                + "</math>";
    }
    
     /**@return строку вычисления s1 в формате MathML в виде:
       s1 = (-b-sqrt(D))/2*a = valueOf(s1); */
    public String printS1inMathML() {
        DblNum A = new DblNum(a);
        DblNum B = new DblNum(b);
        DblNum DD = new DblNum(D);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<msub><mi>s</mi><mn>1</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<mn>"+String.valueOf(-B.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(B.getDegree())+"</mn></msup>"
                    + "<mo>-</mo><msqrt><mrow>"
                    + "<mn>"+String.valueOf(DD.getNum())+"</mn>"
                    + "<mo>&#x2219</mo><msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(DD.getDegree())+ "</mn></msup>"
                    + "</mrow></msqrt></mrow><mrow>"
                    + (a<0? "<mo>-</mo>":"")
                    + "<mn>2</mn><mo>&#x2219</mo>"
                    + "<mn>"+String.valueOf(Math.abs(A.getNum()))+"</mn>"
                    + "<mo>&#x2219</mo><msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(A.getDegree())+"</mn>"
                    + "</msup></mrow></mfrac><mo>=</mo>"
                    + "<mn mathsize='1.2em'>"+String.valueOf(s1)+"</mn>"
                    + "</mrow>"
                + "</math>";
    }
    
    /**@return строку вычисления s2 в формате MathML в виде:
       s2 = (-b+sqrt(D))/2*a = valueOf(s2); */
    public String printS2inMathML() {
        DblNum A = new DblNum(a);
        DblNum B = new DblNum(b);
        DblNum DD = new DblNum(D);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<msub><mi>s</mi><mn>2</mn></msub>"
                    + "<mo>=</mo><mfrac><mrow>"
                    + "<mn>"+String.valueOf(-B.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(B.getDegree())+"</mn></msup>"
                    + "<mo>+</mo><msqrt><mrow>"
                    + "<mn>"+String.valueOf(DD.getNum())+"</mn>"
                    + "<mo>&#x2219</mo><msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(DD.getDegree())+ "</mn></msup>"
                    + "</mrow></msqrt></mrow><mrow>"
                    + (a<0? "<mo>-</mo>":"")
                    + "<mn>2</mn><mo>&#x2219</mo>"
                    + "<mn>"+String.valueOf(Math.abs(A.getNum()))+"</mn>"
                    + "<mo>&#x2219</mo><msup><mn>10</mn>"
                    + "<mn>"+String.valueOf(A.getDegree())+"</mn>"
                    + "</msup></mrow></mfrac><mo>=</mo>"
                    + "<mn mathsize='1.2em'>"+String.valueOf(s2)+"</mn>"
                    + "</mrow>"
                + "</math>";
    }
    
    
    /**@return коеффициент числителя   */
    public double getK() {
        return k;
    }

    /** @return t1 - постоянная времени T1 */
    public double getT1() {
        return t1;
    }

    /** @return t2 - постоянная времени T2    */
    public double getT2() {
        return t2;
    }

    /** @return D - дискриминант характеристического уравнения */
    public double getD() {
        return D;
    }

    /** @return первый корень характеристического уравнения */
    public double getS1() {
        return s1;
    }

    /** @return второй корень характеристического уравнения  */
    public double getS2() {
        return s2;
    }

    /** @return  действительную частотную функцию системы    */
    public Uw getU_w() {
        return u_w;
    }

    /** @return мнимую частотную функцию системы    */
    public Vw getV_w() {
        return v_w;
    }

    /** @return функцию АЧХ    */
    public Aw getA_w() {
        return a_w;
    }
}
