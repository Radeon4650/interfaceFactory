/*
 * Структура для хранения баесовских сетей для каждого компонента знаний и умений
 */

package BayesianNetwork;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author radeon
 */
public class BayesianNetworkComponents {
    private Map<String, Bayes_Page> components;
    
    public BayesianNetworkComponents() {
        components = new HashMap();
        
        components.put("TransferFunction", new Bayes_Page("TF"));       
        components.put("SquareEquation", new Bayes_Page("SE"));
        components.put("FrequencyCharacteristic", new Bayes_Page("FC"));
        components.put("U(w)", new Bayes_Page("Uw"));
        components.put("V(w)", new Bayes_Page("Vw"));
        components.put("A(w)", new Bayes_Page("Aw"));
        components.put("A(w_pb)", new Bayes_Page("Aw_pb"));
        
        for(String key : components.keySet()) 
            components.get(key).setInputVirtualEvidence(new double[]{0.5,0.5});
    }
    
    /**
     * @param componentName - строковое название КЗУ
     * @param answerRight - правильный ли дан ответ на данном шаге
     * @param diagnosisApproved - сработала ли диагностическая модель
     */
    public void changeNetworkElement(String componentName, boolean answerRight, boolean diagnosisApproved) {
         Bayes_Page current = this.components.get(componentName);
         if (current.getLastParamNetwork().getInputNodeValue()[0]!=0.5)
            current.createSubnetwork();
         current.setModelEvidence(diagnosisApproved);
         current.setRefindingEvidance(answerRight);
    }
    
    private double[] bayesianDependency (String componentName) {
        return this.components.get(componentName).getNetworkChart();
    }
    
    /**
     * @return график изменений уровня владения компонентами знаний и умений 
     * студента
     */
    public LineChart<Number, Number> getLearningChart(final ResourceBundle lang) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis(0, 1, 0.1);
        xAxis.setTickUnit(1.0);
        xAxis.setLabel(lang.getString("ResPage.learningSteps"));             
        yAxis.setLabel(lang.getString("ResPage.knowledgeLevel"));                    
        final LineChart<Number, Number> lineChart = 
                new LineChart<>(xAxis, yAxis);
        
        for(String key : components.keySet()) {
            XYChart.Series series = new XYChart.Series();
            double[] seriesData = components.get(key).getNetworkChart();
            for (int i = 0; i < seriesData.length; i++) 
                series.getData().add(new XYChart.Data(i+1, seriesData[i]));         
            series.setName(lang.getString("ResPage."+key));
            lineChart.getData().add(series);
        }
        
        lineChart.setLegendVisible(true);
        lineChart.setPrefHeight(600);
//        lineChart.setCreateSymbols(false);
        return lineChart;
    }
}
