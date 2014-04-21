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
public class Rounding_DM extends DM {

    /**@return  true, если диагностическая модель сработала 
     * (диагностирована ошибка округления)
     * @param inputData значение, вычисленное автоматически: 0.0076
     * @param studResult значение, введенное пользователем: 0.0075
     * @param resultPrecision точность округления: 0.0001 (4й знак после запятой)*/
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData == null) return false;
        return false;
        /*double degree = 1;
        double buffer = Math.abs(studResult);
        while (buffer-Math.rint(buffer)>0) {
            degree/=10.0;
            buffer*=10.0;
        }
        return Math.abs(Math.rint(inputData[0]/degree)*degree-studResult)==0.1;*/
    }
    
}
