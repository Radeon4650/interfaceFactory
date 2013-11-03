// Хранение данных, необходимых для решения задач

package interfacefactory;


/**
     * Простейший структурный блок (на схеме W1, W2, W5, W6)
     * @param init_k коеффициент числителя
     * @param init_inpSigName название входящего в блок сигнала
     * @param init_outSignName название выходящего из блока сигнала
     * @param init_inpSigNum номер входящего в блок сигнала (если равен нулю - не выводится в MathML)
     * @param init_outSigNum номер выходящего из блока сигнала (если равен нулю - не выводится в MathML)
     * @param init_blockNum номер блока на схеме
     */
class Wk {              //
    /** @param k коеффициент числителя */
    protected double k;  
    /** @param inpSigName название входящего в блок сигнала*/ 
    protected String inpSigName;    
    /** @param outSigName название выходящего из блока сигнала*/     
    protected String outSigName;   
    /** @param inpSigNum номер входящего в блок сигнала (если равен нулю - не выводится в MathML)*/       
    protected int inpSigNum;    
    /** @param outSigNum номер выходящего из блока сигнала (если равен нулю - не выводится в MathML)*/ 
    protected int outSigNum; 
    /** @param blockNum номер блока на схеме*/
    protected int blockNum;             
    
    
    public Wk(double init_k, String init_inpSigName, String init_outSignName, 
            int init_inpSigNum, int init_outSigNum, int init_blockNum) {
        k = init_k;
        inpSigName = init_inpSigName;
        inpSigNum = init_inpSigNum;
        outSigName = init_outSignName;
        outSigNum = init_outSigNum;
        blockNum = init_blockNum;
    }
    
    /** @return коеффициент передачи блока*/
    public double getK() {
        return k;
    }
    
     /**
     * @return строку в формате MathML для описания простейшего блока
     * на структурной схеме
     */
    public String printInMathML () {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<msub>"
                    + "<mi>W</mi>"
                    + "<mn>"+String.valueOf(blockNum)+"</mn>"
                    + "</msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo>"
                    + "<mfrac>"
                    + "<mrow>"
                    + "<msub>"
                    + "<mi>"+outSigName+"</mi>"
                    + "<mn>"+(outSigNum==0?"":String.valueOf(outSigNum))+"</mn>"
                    + "</msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow>"
                    + "<mrow>"
                    + "<msub>"
                    + "<mi>"+inpSigName+"</mi>"
                    + "<mn>"+(inpSigNum==0?"":String.valueOf(inpSigNum))+"</mn>"
                    + "</msub>"    
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow>"
                    + "</mfrac>"
                    + "<mo>=</mo>"
                    + "<mn>"+String.valueOf(k)+"</mn>"
                    + "</mrow>"
                + "</math>";
    }

}






/** Структурный блок 2го порядка (с двумя постоянными времени).
 * На схеме - W3, W4 - передаточные функции для двигателя.
 * @param init_k коеффициент числителя
 * @param init_t1 постоянная времени T1
 * @param init_t2 постоянная времени T2
 * @param init_inpSigName название входящего в блок сигнала
 * @param init_outSignName название выходящего из блока сигнала
 * @param init_inpSigNum номер входящего в блок сигнала (если равен нулю - не выводится в MathML)
 * @param init_outSigNum номер выходящего из блока сигнала (если равен нулю - не выводится в MathML)
 * @param init_blockNum номер блока на схеме
 */
class Wd extends Wk {      
    /**@param t1 постоянная времени T1*/
    protected double t1;  
    /**@param t2 постоянная времени T2*/
    protected double t2;   
    
    public Wd(double init_k, double init_t1, double init_t2, 
            String init_inpSigName, String init_outSignName, 
            int init_inpSigNum, int init_outSigNum, int init_blockNum) 
    {
        super(init_k, init_inpSigName, init_outSignName, init_inpSigNum, init_outSigNum, init_blockNum);
        t1 = init_t1;
        t2 = init_t2;
    }

    /**@return постояную времени T1*/
    public double getT1() {
        return t1;
    }

    /**@return постояную времени T2*/
    public double getT2() {
        return t2;
    }

    /**
     * @return строку в формате MathML для описания структурного блока
     * 2го порядка на структурной схеме
     */
    @Override
    public String printInMathML () {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<msub>"
                    + "<mi>W</mi>"
                    + "<mn>"+String.valueOf(blockNum)+"</mn>"
                    + "</msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo>"
                    + "<mfrac>"
                    + "<mrow>"
                    + "<msub>"
                    + "<mi>"+outSigName+"</mi>"
                    + "<mn>"+(outSigNum==0?"":String.valueOf(outSigNum))+"</mn>"
                    + "</msub>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow>"
                    + "<mrow>"
                    + "<msub>"
                    + "<mi>"+inpSigName+"</mi>"
                    + "<mn>"+(inpSigNum==0?"":String.valueOf(inpSigNum))+"</mn>"
                    + "</msub>"    
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "</mrow>"
                    + "</mfrac>"
                    + "<mo>=</mo>"
                    + "<mfrac>"
                    + "<mn>"+String.valueOf(k)+"</mn>"
                    + "<mrow>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(t1)+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<mn>"+String.valueOf(t2)+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>";
    }
}






















/** Класс описания передаточной функции Ф(s) во всех вариантах ее появления в GUI.
 * При вычислении считаем, что Мн=0.
 * 
 * Конструктор #1:
 * @param init_k коеффициент числителя
 * @param init_a коеффициент при s^2
 * @param init_b коеффициент при s^1
 * @param init_c коеффициент при s^0
 * 
 * Конструктор #2:
 * @param wk1 передаточная функция простейшего структурного блока (#1 на схеме)
 * @param wk2 передаточная функция простейшего структурного блока (#2 на схеме)
 * @param wd3 передаточная функция структурного блока 2го порядка (#3 на схеме)
 * @param wk5 передаточная функция простейшего структурного блока (#5 на схеме)
 * @param wk6 передаточная функция простейшего структурного блока (#6 на схеме)
 */
class Fs {     
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
    }
    
    public Fs(Wk wk1, Wk wk2, Wd wd3, Wk wk5, Wk wk6) {
        c = wk1.getK()*wk2.getK()*wd3.getK()*wk5.getK()*wk6.getK()+1;
        k = wk1.getK()*wk2.getK()*wd3.getK()*wk5.getK()/c;
        a = wd3.getT1()*wd3.getT2()/c;
        b = (wd3.getT1()+wd3.getT2())/c;
        c = 1;
        count_D();
        count_s1s2();
        count_t1t2();
        u_w = new Uw(k, t1, t2);
        v_w = new Vw(k, t1, t2);
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
            s1 = (-b-Math.sqrt(D))/2*a;
            s2 = (-b+Math.sqrt(D))/2*a;
        }
        else if (D==0) {
            s1=s2=-b/2*a;
        }
        else s1=s2=0;
    }

    /**Рассчитать значения постоянных времени и занести их в поля Т1 и Т2*/
    private void count_t1t2 () {
        if (s1!=0) t1 = 1/s1; else t1 =0;
        if (s2!=0) t2 = 1/s2; else t2 =0;
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
     * в формате Ф(s) = k/(T1s+1)(T2s+1)
     */
    public String printInMathMLWith_t1t2_s () {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>s</mi></mfenced>"
                    + "<mo>=</mo>"
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
     * в формате Ф(jw) = k/(T1jw+1)(T2jw+1)
     */
    public String printInMathMLWith_t1t2_jw () {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow>"
                    + "<mi>&#x03A6</mi>"
                    + "<mfenced><mi>j&#x03C9</mi></mfenced>"
                    + "<mo>=</mo>"
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
                    + "<mo>-</mo><mi>j</mi>"
                    + v.substring(v.indexOf("=-</mo>")+7, v.indexOf("</math>"))
                + "</mrow></math>";
    }
    
    
     /**
     * @return строку в формате MathML для описания передаточной функции 
     * в формате Ф(s) = k/(a*s^2+b*s+c)
     */
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
                    + "<mo>=</mo>"
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

     /**
     * @return строку в формате MathML для записи характеристического уравнения 
     * a*s^2+b*s+c=0
     */
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
                    + "<mo>=</mo>"
                    + "<mn>"+String.valueOf(DD.getNum())+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<msup>"
                    + "<mn>10</mn>"
                    + "<mn>"+String.valueOf(DD.getDegree())+"</mn>"
                    + "</msup>"
                    + "</mrow>"
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
                    + "<mn>"+String.valueOf(t1)+"</mn>"
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
                    + "<mn>"+String.valueOf(t2)+"</mn>"
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
                    + "<mn>"+String.valueOf(s1)+"</mn>"
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
                    + "<mn>"+String.valueOf(s2)+"</mn>"
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
}














/** Класс описания функции АЧХ
 * @param init_kA коеффициент числителя Ф(s)
 * @param T1 постоянная времени T1 Ф(s)
 * @param T2 постоянная времени T2 Ф(s)
 */
class Aw {   //A(w)
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
    /**@param fA_w значения для построения графика АЧХ*/
    private double fA_w [] = new double[fA_w_count];
    /**@param Apr значение полосы пропускания*/
    private double Apr;
    /**@param wPr частота полосы пропускания*/
    private double wPr;
    
    public Aw (double init_kA, double T1, double T2)
    {
        wValue = new double[]{0, 5, 10, 20, 50, 60, 70, 80, 90, 100, 200};
        k = init_kA;
        m = T1*T1;
        n = T2*T2;
        for (int i = 0; i < fA_w_count; i++) {
            fA_w[i] = calc_A(wValue[i]);
        }
        Apr = 0.707*fA_w[0];
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
    public double [] getfA_w() {
        return fA_w;
    }

    /** @return значение полосы пропускания   */
    public double getApr() {
        return Apr;
    }

    /** @return частоту полосы пропускания  */
    public double getwPr() {
        return wPr;
    }
}



/** Класс описания действительной частотной функции:
 * U(w) = k*(1-h*w^2)/(n*w^2+1)*(m*w^2+1)
 * @param init_kA коеффициент числителя Ф(s)
 * @param T1 постоянная времени T1 Ф(s)
 * @param T2 постоянная времени T2 Ф(s)
 */
class Uw extends Aw {
    /**@param h параметр числителя при w^2*/    
    private double h;    //

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
                    + "<mi>U/mi>"
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




/** Класс описания мнимой частотной функции:
 * V(w) = -e*w/(n*w^2+1)*(m*w^2+1)
 * @param init_kA коеффициент числителя Ф(s)
 * @param T1 постоянная времени T1 Ф(s)
 * @param T2 постоянная времени T2 Ф(s)
 */
class Vw extends Aw {
    /**@param e параметр числителя при w*/    
    private double e;  
    
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
}