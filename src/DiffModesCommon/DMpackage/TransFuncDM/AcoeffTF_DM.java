/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage.TransFuncDM;

import DiffModesCommon.DMpackage.DM;

/**
 * Коэффициент a передаточной функции системы
 * @author radeon
 */
public class AcoeffTF_DM extends DM{
    static String [] message = new String [] {
        "Потерян знаменатель",
        "Потерян числитель",
        "Пропущен операнд T13 в числителе",
        "Пропущен операнд T23 в числителе",
        "Пропущен операнд k1 в знаменателе",
        "Пропущен операнд k2 в знаменателе",
        "Пропущен операнд k3 в знаменателе",
        "Пропущен операнд k5 в знаменателе",
        "Пропущен операнд k6 в знаменателе",
        "Пропущен операнд 1 в знаменателе"
    };

    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления коэффициента a передаточной функции системы)
     * @param inputData T13; T23; k1; k2; k3; k5; k6 
     * @param studResult значение a, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double T13, T23, k1, k2, k3, k5, k6;
            T13 = inputData[0];
            T23 = inputData[1];
            k1 = inputData[2];
            k2 = inputData[3];
            k3 = inputData[4];
            k5 = inputData[5];
            k6 = inputData[6];
            
        double[] a_val = new double[message.length];    
        
        // ~ Без знаменателя
        a_val[0] = T13*T23;
        // ~ Без числителя
        a_val[1] = 1/(k1*k2*k3*k5*k6+1);
        
        // Пропуск операндов: числитель
        a_val[2] = T23*a_val[1];                            // ~ T13
        a_val[3] = T13*a_val[1];                            // ~ T23

        // Пропуск операндов: знаменатель
        a_val[4] = a_val[0]/(k2*k3*k5*k6+1);                // ~ k1
        a_val[5] = a_val[0]/(k1*k3*k5*k6+1);                // ~ k2
        a_val[6] = a_val[0]/(k1*k2*k5*k6+1);                // ~ k3
        a_val[7] = a_val[0]/(k1*k2*k3*k6+1);                // ~ k5
        a_val[8] = a_val[0]/(k1*k2*k3*k5+1);                // ~ k6
        a_val[9] = a_val[0]/(k1*k2*k3*k5*k6);               // ~ 1
        
        for (int i = 0; i < message.length; i++) {
            if (super.precisionCheck(a_val[i], studResult, resultPrecision, message[i]))
                return true;     
        }
        
        System.out.println("DM is not activated");
        return false;
    }
    
}
