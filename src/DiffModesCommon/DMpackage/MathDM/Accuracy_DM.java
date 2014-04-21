/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage.MathDM;

import DiffModesCommon.DMpackage.DM;

/**
 *
 * @author radeon
 */
public class Accuracy_DM extends DM{

    /**@return  true, если диагностическая модель сработала 
     * (диагностирована ошибка точности вычислений)
     * @param inputData значение, вычисленное автоматически;
     * @param studResult значение, введенное пользователем
     * @param resultPrecision точность сравнения*/
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData == null) return false;
        // |A_ref - A_st| ~ 0
        return Math.abs(inputData[0]-studResult)>resultPrecision;
    }
    
}
