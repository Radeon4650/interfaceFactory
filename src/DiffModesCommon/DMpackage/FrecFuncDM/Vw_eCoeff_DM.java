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
public class Vw_eCoeff_DM extends DM{
    String [] message = new String [] {
        "Пропущен коэффициент T1",
        "Пропущен коэффициент T2",
        "Пропущен коэффициент k",
        "Пропущен коэффициент T1",
        "Пропущен коэффициент T2",
        "Множители возведены в квадрат"
    };
    
    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления коеффициента e)
     * @param inputData T1, T2, k
     * @param studResult значение e, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double T1 = inputData[0];
        double T2 = inputData[1];
        double k = inputData[2];
        
            
        double[] h_val = new double[message.length];           
        // ~ Пропущен T1
        h_val[0] = T2*k;
        // ~ Пропущен T2
        h_val[1] = T1*k;
        // ~ Пропущен k
        h_val[2] = T1+T2;
        // ~ Пропущен T1
        h_val[3] = (T2+1)*k;
        // ~ Пропущен T2
        h_val[4] = (T1+1)*k;
        // ~ Множители возведены в квадрат
        h_val[5] = (T1*T1+T2*T2)*k;
        
        for (int i = 0; i < message.length; i++) {
            if (super.precisionCheck(h_val[i], studResult, resultPrecision, message[i]))
                return true;     
        }
        
        System.out.println("DM is not activated");
        return false;
    }
    
}
