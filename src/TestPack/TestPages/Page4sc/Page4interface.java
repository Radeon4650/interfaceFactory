package TestPack.TestPages.Page4sc;

import DemoPack.DemoSystemGenerator;
import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Uw;
import DiffModesCommon.DataModel.Vw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import TrainerPack.TrainerControl;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
public class Page4interface extends TestPageInterface {
    private final String k, t1, t2;
    
    protected final TextField x1tf, x2tf, x3tf, x4tf;
    protected final TextField kTf, hTf, eTf, mUTf, nUTf, mVTf, nVTf;
    private final WebView fsView, UwView, VwView;
    
    protected final GridPane rootLayout;

    public Page4interface(final TestSystemGenerator sg, final ResourceBundle lang) {
        { String [] data = sg.getPageData(2);
          k = data[0];
          t1 = data[1];
          t2 = data[2]; }
        
        Label complExprLab = new Label(lang.getString("Test.p4.ComplExpr"));
        Label complCoefLab = new Label(lang.getString("Test.p4.ComplExprCoeff"));
        complCoefLab.setWrapText(true);
        complExprLab.setWrapText(true);
        complCoefLab.setAlignment(Pos.CENTER);
        complExprLab.setAlignment(Pos.CENTER);
        complCoefLab.setStyle(AppStyles.originalFontStyle());
        complExprLab.setStyle(AppStyles.originalFontStyle());
        
        Label x1Lab = new Label("x1 =");
        Label x2Lab = new Label("x2 =");
        Label x3Lab = new Label("x3 =");
        Label x4Lab = new Label("x4 =");
        x1Lab.setStyle(AppStyles.originalFontStyle());
        x2Lab.setStyle(AppStyles.originalFontStyle());
        x3Lab.setStyle(AppStyles.originalFontStyle());
        x4Lab.setStyle(AppStyles.originalFontStyle());
        
        x1tf = new TextField();
        x2tf = new TextField();
        x3tf = new TextField();
        x4tf = new TextField();
        
        x1tf.setStyle(AppStyles.originalFontStyle());
        x2tf.setStyle(AppStyles.originalFontStyle());
        x3tf.setStyle(AppStyles.originalFontStyle());
        x4tf.setStyle(AppStyles.originalFontStyle());
        
        x1tf.setPromptText("x1");
        x2tf.setPromptText("x2");
        x3tf.setPromptText("x3");
        x4tf.setPromptText("x4");
        
        x1tf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(x1tf);
                refreshFsView(lang);
            }
        });
        x2tf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(x2tf);
                refreshFsView(lang);
            }
        });
        x3tf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(x3tf);
                refreshFsView(lang);
            }
        });
        x4tf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(x4tf);
                refreshFsView(lang);
            }
        });
        
        Label frecFunLab = new Label(lang.getString("Test.p4.FrecFunc"));
        Label realFrecFunLab = new Label(lang.getString("Test.p4.RealFrecFuncCoeff"));
        Label imgFrecFunLab = new Label(lang.getString("Test.p4.ImgFrecFuncCoeff"));
        realFrecFunLab.setWrapText(true);
        imgFrecFunLab.setWrapText(true);
        frecFunLab.setStyle(AppStyles.originalFontStyle());
        realFrecFunLab.setStyle(AppStyles.originalFontStyle());
        imgFrecFunLab.setStyle(AppStyles.originalFontStyle());
        
        Label kLab = new Label("k =");
        Label hLab = new Label("h =");
        Label eLab = new Label("e =");
        Label mULab = new Label("mU =");
        Label nULab = new Label("nU =");
        Label mVLab = new Label("mV =");
        Label nVLab = new Label("nV =");
        
        kLab.setStyle(AppStyles.originalFontStyle());
        hLab.setStyle(AppStyles.originalFontStyle());
        eLab.setStyle(AppStyles.originalFontStyle());
        mULab.setStyle(AppStyles.originalFontStyle());
        nULab.setStyle(AppStyles.originalFontStyle());
        mVLab.setStyle(AppStyles.originalFontStyle());
        nVLab.setStyle(AppStyles.originalFontStyle());
        
        kTf = new TextField();
        hTf = new TextField();
        eTf = new TextField();
        mUTf = new TextField();
        nUTf = new TextField();
        mVTf = new TextField();
        nVTf = new TextField();
        
        kTf.setStyle(AppStyles.originalFontStyle());
        hTf.setStyle(AppStyles.originalFontStyle());
        eTf.setStyle(AppStyles.originalFontStyle());
        mUTf.setStyle(AppStyles.originalFontStyle());
        nUTf.setStyle(AppStyles.originalFontStyle());
        mVTf.setStyle(AppStyles.originalFontStyle());
        nVTf.setStyle(AppStyles.originalFontStyle());
        
        kTf.setPromptText("k");
        hTf.setPromptText("h");
        mUTf.setPromptText("mU");
        nUTf.setPromptText("nU");
        eTf.setPromptText("e");
        mVTf.setPromptText("mV");
        nVTf.setPromptText("nV");
        
        kTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(kTf);
                refreshUwView(sg, lang);
            }
        });
        hTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(hTf);
                refreshUwView(sg, lang);
            }
        });
        mUTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(mUTf);
                refreshUwView(sg, lang);
            }
        });
        nUTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(nUTf);
                refreshUwView(sg, lang);
            }
        });
        eTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(eTf);
                refreshVwView(sg, lang);
            }
        });
        mVTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(mVTf);
                refreshVwView(sg, lang);
            }
        });
        nVTf.addEventFilter(KeyEvent.KEY_TYPED,new EventHandler<KeyEvent> () {
            @Override
            public void handle(KeyEvent t) {
                AppStyles.styleSetter(nVTf);
                refreshVwView(sg, lang);
            }
        });
        
        {   String [] data = sg.getPageData(3);
          //k, mU, nU, mV, nV, h, e, x1, x2, x3, x4
            kTf.setText(data[0]);
            mUTf.setText(data[1]);
            nUTf.setText(data[2]);
            mVTf.setText(data[3]);
            nVTf.setText(data[4]);
            hTf.setText(data[5]);
            eTf.setText(data[6]);
            x1tf.setText(data[7]);
            x2tf.setText(data[8]);
            x3tf.setText(data[9]);
            x4tf.setText(data[10]);
        }
        
        fsView = new WebView();
        UwView = new WebView();
        VwView = new WebView();
        
        fsView.setContextMenuEnabled(false);
        UwView.setContextMenuEnabled(false);
        VwView.setContextMenuEnabled(false);
        
        fsView.setMaxHeight(100);
        UwView.setMaxHeight(100);
        VwView.setMaxHeight(100);
        
        refreshFsView(lang);
        refreshUwView(sg, lang);
        refreshVwView(sg, lang);
        
        rootLayout = new GridPane();
        rootLayout.setAlignment(Pos.CENTER);
        setRootColConstr();
        setRootRowConstr();
        
        rootLayout.add(complExprLab, 0, 0);
        rootLayout.add(fsView, 0, 1, 1, 4);
        rootLayout.add(complCoefLab, 1, 0, 2, 1);
        rootLayout.add(x1Lab, 1, 1);        rootLayout.add(x1tf, 2, 1);
        rootLayout.add(x2Lab, 1, 2);        rootLayout.add(x2tf, 2, 2);
        rootLayout.add(x3Lab, 1, 3);        rootLayout.add(x3tf, 2, 3);
        rootLayout.add(x4Lab, 1, 4);        rootLayout.add(x4tf, 2, 4);
        rootLayout.add(frecFunLab, 0, 5);
        rootLayout.add(UwView, 0, 6, 1, 3);
        rootLayout.add(realFrecFunLab, 1, 7, 2, 1);
        rootLayout.add(kLab, 1, 8);         rootLayout.add(kTf, 2, 8);
        rootLayout.add(hLab, 1, 9);         rootLayout.add(hTf, 2, 9);
        rootLayout.add(mULab, 1, 10);       rootLayout.add(mUTf, 2, 10);
        rootLayout.add(nULab, 1, 11);       rootLayout.add(nUTf, 2, 11);
        rootLayout.add(VwView, 0, 8, 1, 7);
        rootLayout.add(imgFrecFunLab, 1, 12, 2, 1);
        rootLayout.add(eLab, 1, 13);        rootLayout.add(eTf, 2, 13);
        rootLayout.add(mVLab, 1, 14);       rootLayout.add(mVTf, 2, 14);
        rootLayout.add(nVLab, 1, 15);       rootLayout.add(nVTf, 2, 15);
        
//        rootLayout.setGridLinesVisible(true);
        
    }
    
    private void setRootColConstr() {
        ColumnConstraints grid_col0 = new ColumnConstraints();
        ColumnConstraints grid_col1 = new ColumnConstraints();
        ColumnConstraints grid_col2 = new ColumnConstraints();
        grid_col0.setPercentWidth(70);
        grid_col1.setPercentWidth(8);
        grid_col2.setPercentWidth(20);
        grid_col0.setHalignment(HPos.CENTER);
        grid_col1.setHalignment(HPos.RIGHT);
        rootLayout.getColumnConstraints().addAll(grid_col0, grid_col1, grid_col2);
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
        RowConstraints rc8 = new RowConstraints();
        RowConstraints rc9 = new RowConstraints();
        RowConstraints rc10 = new RowConstraints();
        RowConstraints rc11 = new RowConstraints();
        RowConstraints rc12 = new RowConstraints();
        RowConstraints rc13 = new RowConstraints();
        RowConstraints rc14 = new RowConstraints();
        RowConstraints rc15 = new RowConstraints();
        
        rc0.setPercentHeight(9);
        rc1.setPercentHeight(4);
        rc2.setPercentHeight(4);
        rc3.setPercentHeight(4);
        rc4.setPercentHeight(4);
        rc5.setPercentHeight(8);
        rc6.setPercentHeight(23);
        rc7.setPercentHeight(8);
        rc8.setPercentHeight(4);
        rc9.setPercentHeight(4);
        rc10.setPercentHeight(4);
        rc11.setPercentHeight(4);
        rc12.setPercentHeight(8);
        rc13.setPercentHeight(4);
        rc14.setPercentHeight(4);
        rc15.setPercentHeight(4);
        
        rootLayout.getRowConstraints().addAll(rc0, rc1, rc2, rc3, rc4, rc5, rc6,
                rc7, rc8, rc9, rc10, rc11, rc12, rc13, rc14, rc15);
    }
    
    /**Для функции printFjw() */
    private String printXn(final String xn, int index) {
        boolean xIsNumber;
        String result;
        try {
            Double.parseDouble(xn);
            xIsNumber = true;
        }
        catch (NumberFormatException nfe) {
            xIsNumber = false;
        }
        result = xn;
        
        if (result.equals("")) result = "<msub mathcolor='#"
                + AppStyles.wrongRedColor() + "'><mi>x</mi><mn>"
                + String.valueOf(index)
                + "</mn></msub>";
        else result = (xIsNumber ? "<mi>" :"<mi mathcolor='#"
                + AppStyles.wrongRedColor() + "'>") + xn + "</mi>";
        return result;
    }
    
    private String printFjw() {
        String x1Txt, x2Txt, x3Txt, x4Txt;
        x1Txt = printXn(x1tf.getText(), 1);
        x2Txt = printXn(x2tf.getText(), 2);
        x3Txt = printXn(x3tf.getText(), 3);
        x4Txt = printXn(x4tf.getText(), 4);
        
        String math = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" 
                    + "<mrow><mi>Ф</mi><mfenced><mi>jω</mi></mfenced>"
                    + "<mo>=</mo><mfrac><mrow><msub><mi>Y</mi><mn>5</mn></msub>"
                    + "<mfenced><mi>jω</mi></mfenced></mrow><mrow>"
                    + "<mi>G</mi><mfenced><mi>jω</mi></mfenced></mrow></mfrac>"
                    + "<mo>=</mo><mfrac><mi mathcolor='#"+ AppStyles.rightGreenColor()
                    + "'>" + k + "</mi><mrow>"
                    + "<mfenced><mrow><mi mathcolor='#"+ AppStyles.rightGreenColor()
                    + "'>" + t1 
                    + "</mi><mo>&#x2219</mo><mi>jω</mi>"
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "<mfenced><mrow><mi mathcolor='#"+ AppStyles.rightGreenColor()
                    + "'>" + t2 
                    + "</mi><mo>&#x2219</mo><mi>jω</mi>"
                    + "<mo>+</mo><mn>1</mn>"
                    + "</mrow></mfenced>"
                    + "</mrow></mfrac><mo>&#x2219</mo>"
                    + "<mfrac><mrow><mfenced><mrow>" + x1Txt
                    + "<mo>&#x2219</mo><mi>jω</mi><mo>+</mo>"
                    + "<mn>1</mn></mrow></mfenced><mfenced><mrow>" + x2Txt
                    + "<mo>&#x2219</mo><mi>jω</mi><mo>+</mo>"
                    + "<mn>1</mn></mrow></mfenced></mrow>"
                    + "<mrow><mfenced><mrow>" + x3Txt
                    + "<mo>&#x2219</mo><mi>jω</mi><mo>+</mo>"
                    + "<mn>1</mn></mrow></mfenced><mfenced><mrow>" + x4Txt
                    + "<mo>&#x2219</mo><mi>jω</mi><mo>+</mo>"
                    + "<mn>1</mn></mrow></mfenced></mrow>"
                    + "</mfrac></mrow>"
                + "</math>";
        return math;
    }
    
    
    private void refreshFsView(final ResourceBundle lang) {
        String content = "<p align=\"center\">"
                + printFjw()
                + ";</p>";
        fsView.getEngine().loadContent(content);
    } 
    
    private void refreshUwView(final TestSystemGenerator sg, final ResourceBundle lang) {
        String content = "<p align=\"center\">"
                + Uw.printUw(kTf.getText(), hTf.getText(), mUTf.getText(), nUTf.getText())
                + ";</p>";
        UwView.getEngine().loadContent(content);
    }
    
    private void refreshVwView(final TestSystemGenerator sg, final ResourceBundle lang) {
        String content = "<p align=\"center\">"
                + Vw.printVw(eTf.getText(), mVTf.getText(), nVTf.getText())
                + ".</p>";
        VwView.getEngine().loadContent(content);
    }
    
    /** @return интерфейс 4й страницы режима Тест  */
    @Override
    public Node getRootLayout() {
        return rootLayout;
    }
    
    @Override
    public boolean dataCheck(TestSystemGenerator sg, final TrainerControl ctrl)  {
        try {
            saveData(sg);
            sg.checkPage(3);
            
            Double.parseDouble(kTf.getText());
            Double.parseDouble(mUTf.getText());
            Double.parseDouble(nUTf.getText());
            Double.parseDouble(mVTf.getText());
            Double.parseDouble(nVTf.getText());
            Double.parseDouble(hTf.getText());
            Double.parseDouble(eTf.getText());
            
            NumberFormatException nfe = new NumberFormatException();
            if (x1tf.getText().equals("")) throw nfe;
            if (x2tf.getText().equals("")) throw nfe;
            if (x3tf.getText().equals("")) throw nfe;
            if (x4tf.getText().equals("")) throw nfe;
            
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    @Override
    public void saveData(TestSystemGenerator sg) {
        sg.saveStud_p3(kTf.getText(), mUTf.getText(), nUTf.getText(), 
                mVTf.getText(), nVTf.getText(), hTf.getText(), 
                eTf.getText(), x1tf.getText(), x2tf.getText(), 
                x3tf.getText(), x4tf.getText());
    }
    
    @Override
    public void watchDemo(final DemoSystemGenerator dsg, final ResourceBundle lang, final TrainerControl ctrl) {
        
    }
}
