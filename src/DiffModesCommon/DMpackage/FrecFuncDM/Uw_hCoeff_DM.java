/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage.FrecFuncDM;

import DiffModesCommon.DMpackage.DM;

/**
 *
 * @author radeon
 */
public class Uw_hCoeff_DM extends DM{
    String [] message = new String [] {
        "Пропущен коэффициент T1",
        "Пропущен коэффициент T2",
        "Множители возведены в квадрат"
    };
    
    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления коеффициента h)
     * @param inputData T1, T2
     * @param studResult значение h, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double T1 = inputData[0];
        double T2 = inputData[1];
        
            
        double[] h_val = new double[message.length];           
        // ~ Пропущен T1
        h_val[0] = T2;
        // ~ Пропущен T2
        h_val[1] = T1;
        // ~ Множители возведены в квадрат
        h_val[2] = T1*T1*T2*T2;
        
        for (int i = 0; i < message.length; i++) {
            if (super.precisionCheck(h_val[i], studResult, resultPrecision, message[i]))
                return true;     
        }
        
        System.out.println("DM is not activated");
        return false;
    }
    
}
