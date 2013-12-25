

package TestPack.TestPages.Page6sc;

import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Aw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author radeon
 */
public class Page6interface extends TestPageInterface {
    private double[] w = {0, 5, 10, 20, 50, 60, 70, 80, 90, 100, 200};
    private double [] A;
    protected final GridPane rootLayout;
    protected final TextField aInp;
    protected final TextField wInp;

    public Page6interface(TestSystemGenerator sg, final ResourceBundle lang) {
        fillAw(sg);
        
        Label aLab = new Label(lang.getString("Test.p6.PassbandTitle"));
        Label wLab = new Label(lang.getString("Test.p6.PassbandFrecTitle"));
        aLab.setWrapText(true);
        wLab.setWrapText(true);
        aLab.setStyle(AppStyles.originalFontStyle());
        wLab.setStyle(AppStyles.originalFontStyle());
        
        Label aInpLab = new Label("A(ω пр) =");
        Label wInpLab = new Label("ω пр =");
        aInpLab.setStyle(AppStyles.originalFontStyle());
        wInpLab.setStyle(AppStyles.originalFontStyle());
        
        aInp = new TextField();
        wInp = new TextField();
        aInp.setStyle(AppStyles.originalFontStyle());
        wInp.setStyle(AppStyles.originalFontStyle());
        aInp.setPromptText("A(ω пр)");
        wInp.setPromptText("ω пр");
        
        { String [] data = sg.getPageData(5);
            aInp.setText(data[0]);
            wInp.setText(data[1]);
        }
        
        aInp.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(aInp);
            }
        });
        wInp.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(wInp);
            }
        });
        
        rootLayout = new GridPane();
//        rootLayout.setGridLinesVisible(true);
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setHgap(10);
        rootLayout.setVgap(10);
        
        rootLayout.add(getChart(lang), 0, 0, 1, 5);
        rootLayout.add(aLab, 1, 1, 2, 1);
        rootLayout.add(aInpLab, 1, 2);      rootLayout.add(aInp, 2, 2);
        rootLayout.add(wLab, 1, 3, 2, 1);
        rootLayout.add(wInpLab, 1, 4);      rootLayout.add(wInp, 2, 4);
        
        setRootColConstraints();
        setRootRowConstraints();
    }
    
    private void setRootColConstraints() {
        ColumnConstraints grid_col0 = new ColumnConstraints();
        ColumnConstraints grid_col1 = new ColumnConstraints();
        ColumnConstraints grid_col2 = new ColumnConstraints();
        grid_col0.setPercentWidth(70);
        grid_col1.setPercentWidth(8);
        grid_col2.setPercentWidth(18);
        grid_col1.setHalignment(HPos.RIGHT);
        rootLayout.getColumnConstraints().addAll(grid_col0, grid_col1, grid_col2);
    }
    
    private void setRootRowConstraints() {
        RowConstraints rc0 = new RowConstraints();
        RowConstraints rc1 = new RowConstraints();
        RowConstraints rc2 = new RowConstraints();
        RowConstraints rc3 = new RowConstraints();
        RowConstraints rc4 = new RowConstraints();
        rc0.setPercentHeight(40);
        rc1.setPercentHeight(14);
        rc2.setPercentHeight(14);
        rc3.setPercentHeight(14);
        rc4.setPercentHeight(14);
        rc0.setValignment(VPos.CENTER);
        rc1.setValignment(VPos.BOTTOM);
        rc2.setValignment(VPos.TOP);
        rc3.setValignment(VPos.BOTTOM);
        rc4.setValignment(VPos.TOP);
        rootLayout.getRowConstraints().addAll(rc0, rc1, rc2, rc3, rc4);
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
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl)  {
        if (aInp.getText().equals("")) return false;
        if (wInp.getText().equals("")) return false;
        
        saveData(sg);
        sg.checkPage(5);
        return true;
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.saveStud_p5(aInp.getText(), wInp.getText());
    }
    
    public final LineChart<Number, Number> getChart (final ResourceBundle lang) {
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
        lineChart.setCreateSymbols(false);
        lineChart.setStyle(AppStyles.originalFontStyle());
        return lineChart;
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        
    }
}
