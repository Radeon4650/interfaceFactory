/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage;

/**
 *
 * @author radeon
 */
public class A_Wpb_DM extends DM{
    String [] message = new String [] {
        "Пропущен коэффициент 0.707",
        "Пропущено значение А(0)"
    };
    
    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления полосы пропускания системы)
     * @param inputData A(0)
     * @param studResult значение A_Wpb, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double A0 = inputData[0];
            
        double[] a_val = new double[message.length];           
        // ~ Пропущен коэффициент 0.707
        a_val[0] = A0;
        // ~ Пропущен А0
        a_val[1] = 0.707;
        
        for (int i = 0; i < message.length; i++) {
            if (super.precisionCheck(a_val[i], studResult, resultPrecision, message[i]))
                return true;     
        }
        
        System.out.println("DM is not activated");
        return false;
    }
}
