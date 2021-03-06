package DiffModesCommon.DataModel;

import DiffModesCommon.AppStyles;


public class Wd extends Wk {      
    /**@param t1 постоянная времени T1*/
    protected double t1;  
    /**@param t2 постоянная времени T2*/
    protected double t2;   
    
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
    public Wd(double init_k, double init_t1, double init_t2, 
            String init_inpSigName, String init_outSignName, 
            int init_inpSigNum, int init_outSigNum, int init_blockNum) 
    {
        super(init_k, init_inpSigName, init_outSignName, init_inpSigNum, init_outSigNum, init_blockNum);
        t1 = init_t1;
        t2 = init_t2;
    }

    
    /**Конструктор копирования
     * создает класс Wd с полями, имеющими такие же значения,
     * как и поля переданного класса
     * @param inpWd класс Wd для копирования*/
    public Wd(Wd inpWd) 
    {
        super(inpWd.k, inpWd.inpSigName, inpWd.outSigName, inpWd.inpSigNum, 
                inpWd.outSigNum, inpWd.blockNum);
        t1 = inpWd.t1;
        t2 = inpWd.t2;
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
        final String rgColor = AppStyles.rightGreenColor();
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
                    + "<mn mathcolor='#"
                    + rgColor
                    + "' mathsize='1.2em'>"+String.valueOf(k)+"</mn>"
                    + "<mrow>"
                    + "<mfenced><mrow>"
                    + "<mn mathcolor='#"
                    + rgColor
                    + "' mathsize='1.2em'>"+String.valueOf(t1)+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow>"
                    + "<mn mathcolor='#"
                    + rgColor
                    + "' mathsize='1.2em'>"+String.valueOf(t2)+"</mn>"
                    + "<mo>&#x2219</mo>"
                    + "<mi>s</mi>"
                    + "<mo>+</mo>"
                    + "<mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac></mrow>"
                + "</math>";
    }
}
