package StartDialogs;

import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class FXOptionPane {

public enum Response { NO, YES, CANCEL };
public enum langResponse { EN, RU, UA};

private static Response buttonSelected = Response.CANCEL;
private static langResponse langSelected = langResponse.RU;

private static ImageView icon = new ImageView();

static class Dialog extends Stage {
    public Dialog( String title, Stage owner, Scene scene, String iconFile ) {
        setTitle( title );
        initStyle( StageStyle.UTILITY );
        initModality( Modality.APPLICATION_MODAL );
        initOwner( owner );
        setResizable( false );
        setScene( scene );
//        icon.setImage( new Image( getClass().getResourceAsStream( iconFile ) ) );
    }
    public void showDialog() {
        sizeToScene();
        centerOnScreen();
        showAndWait();
    }
}

static class startDialog extends Stage {
    public startDialog( String title, Stage owner, Scene scene, String iconFile ) {
        setTitle( title );
        initStyle( StageStyle.UTILITY );
        initModality( Modality.APPLICATION_MODAL);
        initOwner( owner );
        setResizable( false );
        setWidth(300);
        setHeight(200);
        setScene( scene );
    this.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        System.exit(11);
    }
});
//        icon.setImage( new Image( getClass().getResourceAsStream( iconFile ) ) );
    }
    public void showDialog() {
        sizeToScene();
        centerOnScreen();
        showAndWait();
    }
}

static class Message extends Text {
    public Message( String msg ) {
        super( msg );
        setWrappingWidth( 250 );
    }
}

public static Response showConfirmDialog( Stage owner, String message, String title, final ResourceBundle lang) {
    VBox vb = new VBox();
    Scene scene = new Scene( vb );
    final Dialog dial = new Dialog( title, owner, scene, "res/Confirm.png" );
    vb.setPadding( new Insets(10, 10, 10, 10) );
    vb.setSpacing( 10);
    Button yesButton = new Button(lang.getString("MessageBox.Yes"));
    yesButton.setOnAction( new EventHandler<ActionEvent>() {
        @Override public void handle( ActionEvent e ) {
            dial.close();
            buttonSelected = Response.YES;
        }
    } );
    Button noButton = new Button(lang.getString("MessageBox.No"));
    noButton.setOnAction( new EventHandler<ActionEvent>() {
        @Override public void handle( ActionEvent e ) {
            dial.close();
            buttonSelected = Response.NO;
        }
    } );
    BorderPane bp = new BorderPane();
    HBox buttons = new HBox();
    buttons.setAlignment( Pos.CENTER );
    buttons.setSpacing(10);
    buttons.getChildren().addAll( yesButton, noButton );
    bp.setCenter( buttons );
    HBox msg = new HBox();
    msg.setSpacing(5);
    msg.getChildren().addAll( icon, new Message( message ) );
    vb.getChildren().addAll( msg, bp );
    dial.showDialog();
    return buttonSelected;
}

public static void showMessageDialog( Stage owner, String message, String title ) {
    showMessageDialog( owner, new Message( message ), title );
}
public static void showMessageDialog( Stage owner, Node message, String title ) {
    VBox vb = new VBox();
    Scene scene = new Scene( vb );
    final Dialog dial = new Dialog( title, owner, scene, "res/Info.png" );
    vb.setPadding(new Insets(10));
    vb.setSpacing(10);
    Button okButton = new Button( "OK" );
    okButton.setAlignment( Pos.CENTER );
    okButton.setOnAction( new EventHandler<ActionEvent>() {
        @Override public void handle( ActionEvent e ) {
            dial.close();
        }
    } );
    BorderPane bp = new BorderPane();
    bp.setCenter( okButton );
    HBox msg = new HBox();
    msg.setSpacing(5);
    msg.getChildren().addAll( icon, message );
    vb.getChildren().addAll( msg, bp );
    dial.showDialog();
}

public static langResponse showStartDialog( Stage owner, String message, String title ) {
    VBox vb = new VBox();
    Scene scene = new Scene( vb );
    final startDialog dial = new startDialog( title, owner, scene, "res/Confirm.png" );
    vb.setPadding( new Insets(10, 10, 10, 10) );
    vb.setSpacing( 10);
    final Button continueButton = new Button( "Продолжить" );
    ChoiceBox cb=new ChoiceBox(FXCollections.observableArrayList("Русский","Українська","English"));
    cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

        @Override
        public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
switch(ov.getValue().intValue()){
    case 0: langSelected=langResponse.RU;
        continueButton.setText("Продолжить");
        break;
    case 1: langSelected=langResponse.UA;
    continueButton.setText("Продовжити");
        break;
    case 2: langSelected=langResponse.EN;
    continueButton.setText("Continue");
        break;
    default: langSelected=langResponse.RU;
}
        }
    });
    cb.getSelectionModel().select(0);
    continueButton.setOnAction( new EventHandler<ActionEvent>() {
        @Override public void handle( ActionEvent e ) {
            dial.close();
        }
    } );
        
    BorderPane bp = new BorderPane();
    HBox msg = new HBox();
    msg.setSpacing(5);
    msg.getChildren().addAll( icon, new Message( message ) );
    vb.getChildren().addAll( msg, cb, continueButton );
    dial.showDialog();
    return langSelected;
}
}
