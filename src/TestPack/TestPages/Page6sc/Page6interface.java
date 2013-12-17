

package TestPack.TestPages.Page6sc;

import DiffModesCommon.DataModel.Aw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author radeon
 */
public class Page6interface extends TestPageInterface {
    private double[] w = {0, 5, 10, 20, 50, 60, 70, 80, 90, 100, 200};
    private double [] A;
    private final GridPane rootLayout;
    private final TextField aInp;
    private final TextField wInp;

    public Page6interface(TestSystemGenerator sg, final ResourceBundle lang) {
        fillAw(sg);
        
        Label aLab = new Label(lang.getString("Test.p6.PassbandTitle"));
        Label wLab = new Label(lang.getString("Test.p6.PassbandFrecTitle"));
        aLab.setWrapText(true);
        wLab.setWrapText(true);
        
        Label aInpLab = new Label("A(ω пр) =");
        Label wInpLab = new Label("ω пр =");
        
        aInp = new TextField();
        wInp = new TextField();
        
        aInp.setPromptText("A(ω пр)");
        wInp.setPromptText("ω пр");
        
        { String [] data = sg.getPageData(5);
            aInp.setText(data[0]);
            wInp.setText(data[1]);
        }
        
        rootLayout = new GridPane();
        rootLayout.add(getChart(lang), 0, 0, 1, 3);
        rootLayout.add(aLab, 1, 0, 2, 1);
        rootLayout.add(aInpLab, 1, 1);      rootLayout.add(aInp, 2, 1);
        rootLayout.add(wLab, 1, 2, 2, 1);
        rootLayout.add(wInpLab, 1, 3);      rootLayout.add(wInp, 2, 3);
        
    }
    
    private void fillAw(TestSystemGenerator sg){
        String[] data = sg.getPageData(4);
        double k, m, n;
        k = Double.parseDouble(data[0]);
        m = Double.parseDouble(data[1]);
        n = Double.parseDouble(data[2]);
        
        A = new double[w.length];
        for (int i = 0; i < w.length; i++) {
            A[i] = Aw.calc_A(k, m, n, w[i]);            
        }
    }
    
    /** @return интерфейс 6й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg)  {
        try {
            saveData(sg);
            sg.checkPage(5);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.saveStud_p5(aInp.getText(), wInp.getText());
    }
    
    public LineChart<Number, Number> getChart (final ResourceBundle lang) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("ω");
        yAxis.setLabel("A");
        final LineChart<Number, Number> lineChart = 
                new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(lang.getString("Test.p6.ChartTitle"));
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < w.length; i++) {
            double w_curr = w[i];
            double a_curr = A[i];
            series.getData().add(new XYChart.Data(w_curr, a_curr));   
        }
        lineChart.setLegendVisible(false);
        lineChart.getData().add(series);
        lineChart.setPrefSize(1000, 1000);
        lineChart.setCreateSymbols(false);
        return lineChart;
    }
}
