
package BayesianNetwork;

import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTMLDocument;


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
     * Установка значения для последнего звена модели (Model)
     * true -- диагностическая модель включена;
     * false -- диагностическая модель выключена;
     * @param Model - правильность ответа
     */
    public void setModelEvidence(boolean Model){
        if(Model)
              getLastParamNetwork().setNodeEvidence("Model", "on");
        else getLastParamNetwork().setNodeEvidence("Model", "off");
    }
    
     /**
     * Установка значения для последнего звена ответа (Refinding)
     * true -- Верно;
     * false -- Не правильный ответ;
     * @param ref - правильность ответа
     */
    public void setRefindingEvidance(boolean ref){
        if(ref)
              getLastParamNetwork().setNodeEvidence("Refining", "Answer");
        else getLastParamNetwork().setNodeEvidence("Refining", "noAnswer");
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
    
        /**
     * 
     * @return указатель на стек сетей
     */
    public Stack<BayesianNetwork> getNetworks(){
        return networks;
}
    
    public double[] getNetworkChart() {   
        double[] chartValues = new double[networks.size()+1];
        int i = 0;
        chartValues[i] = networks.firstElement().getInputNodeValue()[0];  
        Iterator<BayesianNetwork> it=networks.iterator();
        for (int j = 0; j < chartValues.length-1; j++) {
            chartValues[j+1] = networks.elementAt(j).getOutputNodeValue()[0];
        }
        return chartValues;
    }
}