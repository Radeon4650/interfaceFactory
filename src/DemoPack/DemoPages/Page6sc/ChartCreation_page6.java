
package DemoPack.DemoPages.Page6sc;

import interfacefactory.DataModel.Aw;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author radeon
 */
public class ChartCreation_page6 {
    /**@return график А(w)*/
    public static LineChart<Number, Number> getChart (Aw a_w) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("ω");
        yAxis.setLabel("A");
        final LineChart<Number, Number> lineChart = 
                new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Строим график АЧХ:");
        XYChart.Series series = new XYChart.Series();
        double w = a_w.getWValue(0);
        double a = a_w.getfA_w(0);
        series.getData().add(new XYChart.Data(w, a));
        while ((w+=10)<=a_w.getWValue(a_w.getfA_w_count()-1)) {
            a = a_w.calc_A(w);            
            series.getData().add(new XYChart.Data(w, a)); 
        }
        lineChart.setLegendVisible(false);
        lineChart.getData().add(series);
        lineChart.setPrefSize(1000, 1000);
        lineChart.setCreateSymbols(false);
        return lineChart;
    }
}