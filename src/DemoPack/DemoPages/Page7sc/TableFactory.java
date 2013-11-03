// Класс, создающий и возвращающий таблицу

package DemoPack.DemoPages.Page7sc;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Radeon
 */
public class TableFactory {
     public static TableView createTable (ObservableList<ApfcValues> ti) {
        TableView apfcTable = new TableView();
        TableColumn w1 = new TableColumn("w, рад/с");
        TableColumn U1 = new TableColumn("U(w)");
        TableColumn V1 = new TableColumn("V(w)");
        TableColumn w2 = new TableColumn("w, рад/с");
        TableColumn U2 = new TableColumn("U(w)");
        TableColumn V2 = new TableColumn("V(w)");
            w1.setEditable(false);
            w2.setEditable(false);
            U1.setEditable(true);
            U2.setEditable(true);
            V1.setEditable(true);
            V2.setEditable(true);
            
            w1.setMinWidth(50);
            U1.setMinWidth(50);
            V1.setMinWidth(50);
            w2.setMinWidth(50);
            U2.setMinWidth(50);
            V2.setMinWidth(50);
            
            U1.setCellFactory(TextFieldTableCell.forTableColumn());
            U1.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ApfcValues, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ApfcValues, String> t) {
                        ((ApfcValues) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setU1(t.getNewValue());
                }
                });
            U2.setCellFactory(TextFieldTableCell.forTableColumn());
            U2.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ApfcValues, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ApfcValues, String> t) {
                        ((ApfcValues) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setU2(t.getNewValue());
                }
                });
            V1.setCellFactory(TextFieldTableCell.forTableColumn());
            V1.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ApfcValues, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ApfcValues, String> t) {
                        ((ApfcValues) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setV1(t.getNewValue());
                }
                });
            V2.setCellFactory(TextFieldTableCell.forTableColumn());
            V2.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ApfcValues, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ApfcValues, String> t) {
                        ((ApfcValues) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setV2(t.getNewValue());
                }
                });
       
            
        w1.setCellValueFactory(new PropertyValueFactory<ApfcValues, String>("w1"));
        U1.setCellValueFactory(new PropertyValueFactory<ApfcValues, String>("U1"));
        V1.setCellValueFactory(new PropertyValueFactory<ApfcValues, String>("V1"));
        w2.setCellValueFactory(new PropertyValueFactory<ApfcValues, String>("w2"));
        U2.setCellValueFactory(new PropertyValueFactory<ApfcValues, String>("U2"));
        V2.setCellValueFactory(new PropertyValueFactory<ApfcValues, String>("V2"));
            
            apfcTable.getColumns().addAll(w1, U1, V1, w2, U2, V2);
            apfcTable.setItems(ti);
            apfcTable.setEditable(true);
            apfcTable.setPrefSize(300, 292);
            apfcTable.setMaxSize(315, 292);
            
            
        return apfcTable;
    }
}
