

package TestPack.TestPages.Page8sc;

import DiffModesCommon.DataModel.Uw;
import DiffModesCommon.DataModel.Vw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

/**
 *
 * @author radeon
 */
public class Page8interface extends TestPageInterface {
    private double[] u_arr, v_arr;
    
    private final VBox rootLayout;

    public Page8interface(TestSystemGenerator sg, ResourceBundle lang) {
        rootLayout = new VBox();
        rootLayout.getChildren().add(getChart(sg, lang));
    }
    
    /** @return интерфейс 9й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    private boolean loadArrayDataSuccess(TestSystemGenerator sg) {
        u_arr = new double[TestSystemGenerator.getAfLen()];
        v_arr = new double[TestSystemGenerator.getAfLen()];
        try
        { String[] data = sg.getPageData(6);
          int cnt = TestSystemGenerator.getAfLen();
            for (int i = 0; i < cnt; i++) {
                u_arr[i] = Double.parseDouble(data[i]);
                v_arr[i] = Double.parseDouble(data[i+cnt]);
            } 
            return true;
        }
        catch (NumberFormatException nfe) { return false; }
    }
    
    /**@return график АФЧХ  */
    private LineChart<Number, Number> getChart (TestSystemGenerator sg, ResourceBundle lang) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("U");
        yAxis.setLabel("jV");
        final LineChart<Number, Number> lineChart = 
                new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(lang.getString("Test.p8.ChartTitle"));
        lineChart.setLegendVisible(false);
        lineChart.setPrefWidth(1000);
        lineChart.setCreateSymbols(false);
        
        if (loadArrayDataSuccess(sg))
        {   String k, mU, nU, mV, nV, h, e;
            String [] data = sg.getPageData(3);
              //k, mU, nU, mV, nV, h, e, ...
            k = data[0];       mU = data[1];      nU = data[2];
            mV = data[3];      nV = data[4];      h = data[5];
            e = data[6]; 
            XYChart.Series series = new XYChart.Series();
            for (int i = 0, j=1; i < 400; i+=j, j+=1) 
                series.getData().add(new XYChart.Data(Uw.calcU(k, h, mU, nU, i), 
                        Vw.calcV(e, mV, nV, i)));
            for (int i = 5; i < TestSystemGenerator.getAfLen(); i++) 
                series.getData().add(new XYChart.Data(u_arr[i], v_arr[i]));
            lineChart.getData().add(series);
        }
        
        return lineChart;
}
    
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg)  {
        return true;
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        //не требуется
    }
}
