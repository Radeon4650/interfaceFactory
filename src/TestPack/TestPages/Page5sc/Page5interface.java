package TestPack.TestPages.Page5sc;

import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Aw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page5interface extends TestPageInterface {
    
    private double [] w = {0, 5, 10, 20, 50, 60, 70, 80, 90, 100, 200};
    private double [] A;
    
    protected final TextField kTf;
    protected final TextField mTf;
    protected final TextField nTf;
    private final WebView AwView;
    private final WebView tableView;
    protected final GridPane rootLayout;

    public Page5interface(TestSystemGenerator sg, final ResourceBundle lang) {
        A = new double[w.length];
        
        Label titleLab = new Label(lang.getString("Test.p5.PageTitle"));
        titleLab.setAlignment(Pos.CENTER);
        titleLab.setStyle(AppStyles.originalFontStyle());
        Label coeffTitle = new Label(lang.getString("Test.p5.InputCoeffTitle"));
        coeffTitle.setStyle(AppStyles.originalFontStyle());
        coeffTitle.setAlignment(Pos.CENTER);
        coeffTitle.setWrapText(true);
        
        Label kLab = new Label("k =");
        Label mLab = new Label("m =");
        Label nLab = new Label("n =");
        kLab.setStyle(AppStyles.originalFontStyle());
        mLab.setStyle(AppStyles.originalFontStyle());
        nLab.setStyle(AppStyles.originalFontStyle());
        
        kTf = new TextField();
        mTf = new TextField();
        nTf = new TextField();
        kTf.setStyle(AppStyles.originalFontStyle());
        mTf.setStyle(AppStyles.originalFontStyle());
        nTf.setStyle(AppStyles.originalFontStyle());
        
        kTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(kTf);
                refreshAwView();
            }
        });
        mTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(mTf);
                refreshAwView();
            }
        });
        nTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(nTf);
                refreshAwView();
            }
        });
        
        kTf.setPromptText("k");
        mTf.setPromptText("m");
        nTf.setPromptText("n");
        
        { String [] data = sg.getPageData(4);
          kTf.setText(data[0]);
          mTf.setText(data[1]);
          nTf.setText(data[2]);
        }
        
        AwView = new WebView();
        refreshAwView();
        AwView.setContextMenuEnabled(false);
        AwView.setMaxHeight(100);
                
        tableView = new WebView();
        tableView.setMaxHeight(150);
        tableView.setContextMenuEnabled(false);
        tableView.getEngine().loadContent("<font color=\"" 
                + AppStyles.infoBlueColor()
                + "\"><p align=\"center\">"
                + "<font face=\"" + AppStyles.readingFont() + "\">"
                + lang.getString("Test.p5.tableHint")
                +"</font></p></font>");
        
        Button calcBtn = new Button(lang.getString("Test.p5.CalcBtn"));
        calcBtn.setStyle(AppStyles.originalFontStyle());
        calcBtn.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                    buildTable(lang);
                }
            
        });
        
        rootLayout = new GridPane();       
        rootLayout.setAlignment(Pos.CENTER);
        setRootRowConstr();
        setRootColConstr();

        
        rootLayout.add(titleLab, 0, 0);
        rootLayout.add(AwView, 0, 1, 1, 5);
        rootLayout.add(coeffTitle, 2, 2);
        rootLayout.add(kLab, 1, 3);         rootLayout.add(kTf, 2, 3);
        rootLayout.add(mLab, 1, 4);         rootLayout.add(mTf, 2, 4);
        rootLayout.add(nLab, 1, 5);         rootLayout.add(nTf, 2, 5);
        rootLayout.add(tableView, 0, 6, 3, 1);
        rootLayout.add(calcBtn, 0, 7, 3, 1);     
        
        
//        rootLayout.setGridLinesVisible(true);
    }
    
    private void setRootRowConstr() {
        RowConstraints rc0 = new RowConstraints();
        RowConstraints rc1 = new RowConstraints();
        RowConstraints rc2 = new RowConstraints();
        RowConstraints rc3 = new RowConstraints();
        RowConstraints rc4 = new RowConstraints();
        RowConstraints rc5 = new RowConstraints();
        RowConstraints rc6 = new RowConstraints();
        RowConstraints rc7 = new RowConstraints();
        rc0.setPercentHeight(10);
        rc1.setPercentHeight(20);
        rc2.setPercentHeight(10);
        rc3.setPercentHeight(5);
        rc4.setPercentHeight(5);
        rc5.setPercentHeight(5);
        rc6.setPercentHeight(35);
        rc7.setPercentHeight(10);
        rc1.setValignment(VPos.CENTER);
        rc6.setValignment(VPos.CENTER);
        rootLayout.getRowConstraints().addAll(rc0, rc1, rc2, rc3, rc4, rc5, rc6, rc7);
    }
    
    private void setRootColConstr() {
        ColumnConstraints grid_col0 = new ColumnConstraints();
        ColumnConstraints grid_col1 = new ColumnConstraints();
        ColumnConstraints grid_col2 = new ColumnConstraints();
        grid_col0.setPercentWidth(70);
        grid_col1.setPercentWidth(8);
        grid_col2.setPercentWidth(18);
        grid_col0.setHalignment(HPos.CENTER);
        grid_col1.setHalignment(HPos.RIGHT);
        grid_col2.setHalignment(HPos.CENTER);
        rootLayout.getColumnConstraints().addAll(grid_col0, grid_col1, grid_col2);
    }
    
    /** @return интерфейс 5й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    private void buildTable(final ResourceBundle lang) {
        try {
            double k, m, n;
            k = Double.parseDouble(kTf.getText());
            m = Double.parseDouble(mTf.getText());
            n = Double.parseDouble(nTf.getText());
            
            String content = "<font face=\"" + AppStyles.originalFont()
                    + "\"><p align=\"center\">" 
                    + lang.getString("Test.p5.TableTitle")
                    + "</p><p align=\"center\">" 
                    + "<table width=\"90%\"><tr><td>ω, рад/с</td>";
                    
            for (int i = 0; i < w.length; i++) {
                A[i] = Math.rint(Aw.calc_A(k, m, n, w[i])*10000)/10000;         
            }
            for (int i = 0; i < w.length; i++) {
                content += "<td" + ((i%2)==1? ">":" bgcolor=\""+ AppStyles.demoTableLinesColor() +"\">") + String.valueOf(w[i]) + "</td>";       
            }
            content += "</tr><tr><td>A(ω)</td>";
            for (int i = 0; i < A.length; i++) {
                content += "<td" + ((i%2)==1? ">":" bgcolor=\""+ AppStyles.demoTableLinesColor() +"\">") + String.valueOf(A[i]) + "</td>";
            }
            content += "</tr></table></p></font>";
            
            tableView.getEngine().loadContent(content);
        }
        catch (NumberFormatException nfe) {
            tableView.getEngine().loadContent("<p align=\"center\">"
                + "<b><font color=\"" + AppStyles.wrongRedColor() + "\" "
                + "face=\"" + AppStyles.readingFont() + "\">"
                + lang.getString("Test.p5.TableCalcError")
                +"</font></b></p>");
        }
    }
    
    private void refreshAwView() {
        String k, m, n;
        k = kTf.getText();
        if (k.equals("")) k = "<mi mathcolor='#"
                + AppStyles.wrongRedColor() + "'>k</mi>";
        else k = "<mi>" + k + "</mi>";
        m = Aw.printFromText(mTf.getText(), "m", "");
        n = Aw.printFromText(nTf.getText(), "n", "");
        
        String context = "<p align=\"center\">"
                + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                + "<mrow><mi>A</mi><mfenced><mi>ω</mi></mfenced><mo>=</mo>"
                + "<mfrac>" + k
                + "<msqrt><mrow><mfenced><mrow>" + m
                + "<msup><mi>ω</mi><mn>2</mn></msup>"
                + "<mo>+</mo><mn>1</mn>"
                + "</mrow></mfenced><mfenced><mrow>" + n
                + "<msup><mi>ω</mi><mn>2</mn></msup>"
                + "<mo>+</mo><mn>1</mn>"
                + "</mrow></mfenced></mrow></msqrt>"
                + "</mfrac>"
                + "</mrow></math>.</p>";
        AwView.getEngine().loadContent(context);
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl)  {
        try {
            saveData(sg);
            sg.checkPage(4);
            
            Double.parseDouble(kTf.getText());
            Double.parseDouble(mTf.getText());
            Double.parseDouble(nTf.getText());
            
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.saveStud_p4(kTf.getText(), mTf.getText(), nTf.getText());
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        
    }
}
