
package BayesianNetwork;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ashelest
 */
public class Bayes_Page{
private final Stack<BayesianNetwork> networks;
private final String param_Name;
private int deepIndex;

    /**
     *
     * @param param_Name
     */
    public Bayes_Page(String param_Name) {
        this.deepIndex = 0;
        networks=new Stack<>();
        this.param_Name=param_Name;
   try {
        BayesianNetwork my_network = new BayesianNetwork(param_Name,deepIndex);
        networks.add(my_network);
    } catch (Exception ex) {
        Logger.getLogger(Bayes_Page.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     *
     * @param evid - значение вероятностей стартового узла
     * Calculate -->{0..1,0..1}
     */
    public void setInputVirtualEvidence(double[] evid){
    this.getLastParamNetwork().setVirtualNodeEvidence("Calculate", evid);
    }
    
    /**
     *
     * @param check - значение вероятностей стартового узла
     * Calculate --> true: "right"
     *               false: "mistake"
     */
    public void setInputEvidence(boolean check){
        if(check)
    this.getLastParamNetwork().setNodeEvidence("Calculate", "right");
        else
    this.getLastParamNetwork().setNodeEvidence("Calculate", "mistake");
    }
    
    /**
     * Установка значения для звена модели (Refinding)
     * true -- true Answer_Hint;
     * true -- false Answer_noHint;
     * false -- true noAnswer_Hint;
     * false -- false noAnswer_noHint;
     * @param Answer - правильность ответа
     * @param Hint - использование подсказки
     */
    public void setModelEvidence(boolean Answer,boolean Hint){
        if(Answer && Hint)
              getLastParamNetwork().setNodeEvidence("Refining", "Answer_Hint");
        if(Answer && !Hint)
              getLastParamNetwork().setNodeEvidence("Refining", "Answer_noHint");
        if(!Answer && Hint)
              getLastParamNetwork().setNodeEvidence("Refining", "noAnswer_Hint");
        if(!Answer && !Hint)
              getLastParamNetwork().setNodeEvidence("Refining", "noAnswer_noHint");

    }
    public void createSubnetwork(){
    try {
        BayesianNetwork newNetwork=new BayesianNetwork(param_Name, ++deepIndex);
        newNetwork.setVirtualNodeEvidence("Calculate",
                getLastParamNetwork().getOutputNodeValue());
        networks.add(newNetwork);
    } catch (Exception ex) {
        Logger.getLogger(Bayes_Page.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    /**
     * 
     * @return указатель на последнюю интелектуальную подсеть
     */
    public BayesianNetwork getLastParamNetwork(){
 return networks.peek();
}
}