package TestPack.TestPages.Page4sc;

import DiffModesCommon.AppStyles;
import DiffModesCommon.DataModel.Uw;
import DiffModesCommon.DataModel.Vw;
import TestPack.TestPages.TestPageInterface;
import TestPack.TestSystemGenerator;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;

/**
 *
 * @author radeon
 */
public class Page4interface extends TestPageInterface {
    private final String k, t1, t2;
    
    private final TextField x1tf, x2tf, x3tf, x4tf;
    private final TextField kTf, hTf, eTf, mUTf, nUTf, mVTf, nVTf;
    private final WebView fsView, UwView, VwView;
    
    private final GridPane rootLayout;

    public Page4interface(final TestSystemGenerator sg, final ResourceBundle lang) {
        { String [] data = sg.getPageData(2);
          k = data[0];
          t1 = data[1];
          t2 = data[2]; }
        
        Label complExprLab = new Label(lang.getString("Test.p4.ComplExpr"));
        Label complCoefLab = new Label(lang.getString("Test.p4.ComplExprCoeff"));
        complCoefLab.setWrapText(true);
        complCoefLab.setAlignment(Pos.CENTER);
        complExprLab.setAlignment(Pos.CENTER);
        
        Label x1Lab = new Label("x1 =");
        Label x2Lab = new Label("x2 =");
        Label x3Lab = new Label("x3 =");
        Label x4Lab = new Label("x4 =");
        
        x1tf = new TextField();
        x2tf = new TextField();
        x3tf = new TextField();
        x4tf = new TextField();
        
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
        
        Label kLab = new Label("k =");
        Label hLab = new Label("h =");
        Label eLab = new Label("e =");
        Label mULab = new Label("mU =");
        Label nULab = new Label("nU =");
        Label mVLab = new Label("mV =");
        Label nVLab = new Label("nV =");
        
        kTf = new TextField();
        hTf = new TextField();
        eTf = new TextField();
        mUTf = new TextField();
        nUTf = new TextField();
        mVTf = new TextField();
        nVTf = new TextField();
        
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
        
        refreshFsView(lang);
        refreshUwView(sg, lang);
        refreshVwView(sg, lang);
        
        rootLayout = new GridPane();
        rootLayout.add(complExprLab, 0, 0, 3, 1);
        rootLayout.add(fsView, 0, 1, 1, 5);
        rootLayout.add(complCoefLab, 1, 1, 2, 1);
        rootLayout.add(x1Lab, 1, 2);        rootLayout.add(x1tf, 2, 2);
        rootLayout.add(x2Lab, 1, 3);        rootLayout.add(x2tf, 2, 3);
        rootLayout.add(x3Lab, 1, 4);        rootLayout.add(x3tf, 2, 4);
        rootLayout.add(x4Lab, 1, 5);        rootLayout.add(x4tf, 2, 5);
        rootLayout.add(frecFunLab, 0, 6, 3, 1);
        rootLayout.add(UwView, 0, 7, 1, 5);
        rootLayout.add(realFrecFunLab, 1, 7, 2, 1);
        rootLayout.add(kLab, 1, 8);         rootLayout.add(kTf, 2, 8);
        rootLayout.add(hLab, 1, 9);         rootLayout.add(hTf, 2, 9);
        rootLayout.add(mULab, 1, 10);       rootLayout.add(mUTf, 2, 10);
        rootLayout.add(nULab, 1, 11);       rootLayout.add(nUTf, 2, 11);
        rootLayout.add(VwView, 0, 12, 1, 4);
        rootLayout.add(imgFrecFunLab, 1, 12, 2, 1);
        rootLayout.add(eLab, 1, 13);        rootLayout.add(eTf, 2, 13);
        rootLayout.add(mVLab, 1, 14);       rootLayout.add(mVTf, 2, 14);
        rootLayout.add(nVLab, 1, 15);       rootLayout.add(nVTf, 2, 15);
        
//        rootLayout.setGridLinesVisible(true);
        
    }
    
    private String printFjw() {
        String x1Txt, x2Txt, x3Txt, x4Txt;
        x1Txt = x1tf.getText();
        if (x1Txt.equals("")) x1Txt = "<msub mathcolor='#"
                + AppStyles.wrongRedColor() + "'><mi>x</mi><mn>1</mn></msub>";
        else x1Txt = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>" + x1Txt + "</mi>";
        x2Txt = x2tf.getText();
        if (x2Txt.equals("")) x2Txt = "<msub mathcolor='#"
                + AppStyles.wrongRedColor() + "'><mi>x</mi><mn>2</mn></msub>";
        else x2Txt = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>" + x2Txt + "</mi>";
        x3Txt = x3tf.getText();
        if (x3Txt.equals("")) x3Txt = "<msub mathcolor='#"
                + AppStyles.wrongRedColor() + "'><mi>x</mi><mn>3</mn></msub>";
        else x3Txt = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>" + x3Txt + "</mi>";
        x4Txt = x4tf.getText();
        if (x4Txt.equals("")) x4Txt = "<msub mathcolor='#"
                + AppStyles.wrongRedColor() + "'><mi>x</mi><mn>4</mn></msub>";
        else x4Txt = "<mi mathcolor='#"+ AppStyles.wrongRedColor() + "'>" + x4Txt + "</mi>";
        
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
    public boolean dataCheck(TestSystemGenerator sg)  {
        try {
            saveData(sg);
            sg.checkPage(3);
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
}
