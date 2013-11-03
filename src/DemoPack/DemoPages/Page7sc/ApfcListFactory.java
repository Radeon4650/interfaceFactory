//Класс, возвращающий список из 11 строк таблицы АФЧХ. 
// Необходим для вычисления U(w) и V(w) на пределах w=0..2000

package DemoPack.DemoPages.Page7sc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Radeon
 */
public class ApfcListFactory {
    public static ObservableList<ApfcValues> createApcfValues(){
        ObservableList<ApfcValues> data = FXCollections.observableArrayList();
        data.add(new ApfcValues("0", "0.875", "0", "1000", "-0.089", "-0.031"));
        data.add(new ApfcValues("50", "0.483", "-0.52", "1100", "-0.08", "-0.026"));
        data.add(new ApfcValues("100", "0.122", "-0.5", "1200", "-0.072", "-0.021"));
        data.add(new ApfcValues("200", "-0.097", "-0.31", "1300", "-0.065", "-0.017"));
        data.add(new ApfcValues("300", "-0.142", "-0.21", "1400", "-0.059", "-0.015"));
        data.add(new ApfcValues("400", "-0.15", "-0.146", "1500", "-0.053", "-0.012"));
        data.add(new ApfcValues("500", "-0.144", "-0.108", "1600", "-0.048", "-0.011"));
        data.add(new ApfcValues("600", "-0.134", "-0.081", "1700", "-0.044", "-0.01"));
        data.add(new ApfcValues("700", "-0.123", "-0.063", "1800", "-0.04", "-0.008"));
        data.add(new ApfcValues("800", "-0.111", "-0.05", "1900", "-0.037", "-0.007"));
        data.add(new ApfcValues("900", "-0.1", "-0.039", "2000", "-0.034", "-0.006"));
        return data;
    }
}
