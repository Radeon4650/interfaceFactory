package DiffModesCommon.DataModel;

import DiffModesCommon.AppStyles;

public class Wk {              
    /**@param k коеффициент числителя */
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
    
    /**
     * Простейший структурный блок (на схеме W1, W2, W5, W6)
     * @param init_k коеффициент числителя
     * @param init_inpSigName название входящего в блок сигнала
     * @param init_outSignName название выходящего из блока сигнала
     * @param init_inpSigNum номер входящего в блок сигнала (если равен нулю - не выводится в MathML)
     * @param init_outSigNum номер выходящего из блока сигнала (если равен нулю - не выводится в MathML)
     * @param init_blockNum номер блока на схеме
     */
    public Wk(double init_k, String init_inpSigName, String init_outSignName, 
            int init_inpSigNum, int init_outSigNum, int init_blockNum) {
        k = init_k;
        inpSigName = init_inpSigName;
        inpSigNum = init_inpSigNum;
        outSigName = init_outSignName;
        outSigNum = init_outSigNum;
        blockNum = init_blockNum;
    }
    
    /**Конструктор копирования
     * создает класс Wk с полями, имеющими такие же значения,
     * как и поля переданного класса
     * @param inpWk класс Wk для копирования*/
    public Wk(Wk inpWk) {
        k = inpWk.k;
        inpSigName = inpWk.inpSigName;
        inpSigNum = inpWk.inpSigNum;
        outSigName = inpWk.outSigName;
        outSigNum = inpWk.outSigNum;
        blockNum = inpWk.blockNum;
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
                    + "<mn mathcolor='#"
                    + AppStyles.rightGreenColor()
                    + "' mathsize='1.2em'>"+String.valueOf(k)+"</mn>"
                    + "</mrow>"
                + "</math>";
    }

}








