package DemoPack.DemoPages.Page8sc;

import DemoPack.DemoSystemGenerator;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author radeon
 */
public class ChartCreation_page8 {
    
    /**@return график АФЧХ
     */
    public static LineChart<Number, Number> getChart (DemoSystemGenerator sg, String title) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("U");
        yAxis.setLabel("jV");
        final LineChart<Number, Number> lineChart = 
                new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(title);
        XYChart.Series series = new XYChart.Series();
        for (int i = 0, j=1; i < 400; i+=j, j+=1) 
            series.getData().add(new XYChart.Data(sg.getFs().getU_w().calc_U(i), sg.getFs().getV_w().calc_V(i)));
        for (int i = 5; i < sg.getAfLen(); i++) 
            series.getData().add(new XYChart.Data(sg.getU(i), sg.getV(i)));
        
        lineChart.setLegendVisible(false);
        lineChart.getData().add(series);
        lineChart.setPrefWidth(1000);
        lineChart.setCreateSymbols(false);
        return lineChart;
}
}
