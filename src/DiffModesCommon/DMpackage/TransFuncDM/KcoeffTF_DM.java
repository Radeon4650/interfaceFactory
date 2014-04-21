/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage.TransFuncDM;

import DiffModesCommon.DMpackage.DM;

/**
 * Коэффициент k передаточной функции системы
 * @author radeon
 */
public class KcoeffTF_DM extends DM{
    String [] message = new String [] {
        "Потерян знаменатель",
        "Потерян числитель",
        "Пропущен операнд k1 в числителе",
        "Пропущен операнд k2 в числителе",
        "Пропущен операнд k3 в числителе",
        "Пропущен операнд k5 в числителе",
        "Пропущен операнд k1 в знаменателе",
        "Пропущен операнд k2 в знаменателе",
        "Пропущен операнд k3 в знаменателе",
        "Пропущен операнд k5 в знаменателе",
        "Пропущен операнд k6 в знаменателе",
        "Пропущен операнд 1 в знаменателе",
        "Пропущен операнд k1 в числителе и знаменателе",
        "Пропущен операнд k2 в числителе и знаменателе",
        "Пропущен операнд k3 в числителе и знаменателе",
        "Пропущен операнд k5 в числителе и знаменателе",
        "Лишний операнд k6 в числителе"
    };

    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления коэффициента k передаточной функции системы)
     * @param inputData k1; k2; k3; k5; k6 
     * @param studResult значение k, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double k1, k2, k3, k5, k6;
            k1 = inputData[0];
            k2 = inputData[1];
            k3 = inputData[2];
            k5 = inputData[3];
            k6 = inputData[4];
            
        double[] k_val = new double[message.length];    
        
        // ~ Без знаменателя
        k_val[0] = k1*k2*k3*k5;
        // ~ Без числителя
        k_val[1] = 1/(k1*k2*k3*k5*k6+1);
        
        // Пропуск операндов: числитель
        k_val[2] = (k2*k3*k5)*k_val[1];                     // ~ k1
        k_val[3] = (k1*k3*k5)*k_val[1];                     // ~ k2
        k_val[4] = (k1*k2*k5)*k_val[1];                     // ~ k3
        k_val[5] = (k1*k2*k3)*k_val[1];                     // ~ k5

        // Пропуск операндов: знаменатель
        k_val[6] = k_val[0]/(k2*k3*k5*k6+1);                // ~ k1
        k_val[7] = k_val[0]/(k1*k3*k5*k6+1);                // ~ k2
        k_val[8] = k_val[0]/(k1*k2*k5*k6+1);                // ~ k3
        k_val[9] = k_val[0]/(k1*k2*k3*k6+1);                // ~ k5
        k_val[10] = k_val[0]/(k1*k2*k3*k5+1);               // ~ k6
        k_val[11] = k_val[0]/(k1*k2*k3*k5*k6);              // ~ 1
        
        // Пропуск операндов: числитель и знаменатель одновременно
        k_val[12] = (k2*k3*k5)/(k2*k3*k5*k6+1);          // ~ k1
        k_val[13] = (k1*k3*k5)/(k1*k3*k5*k6+1);          // ~ k2
        k_val[14] = (k1*k2*k5)/(k1*k2*k5*k6+1);          // ~ k3
        k_val[15] = (k1*k2*k3)/(k1*k2*k3*k6+1);          // ~ k5
        
        // Лишний операнд в числителе
        k_val[16] = k_val[0]*k6*k_val[1];                       // ~ k6
        
        for (int i = 0; i < message.length; i++) {
            if (super.precisionCheck(k_val[i], studResult, resultPrecision, message[i]))
                return true;     
        }
        
        System.out.println("DM is not activated");
        return false;
    }
    
}
