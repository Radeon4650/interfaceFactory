/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage.SqEqDM;

import DiffModesCommon.DMpackage.DM;

/**
 *
 * @author radeon
 */
public class SqEqRoots_DM extends DM {
    static String [] message = new String [] {
        "Пропуск операнда: sqrt(D)",
        "Пропуск операнда: b",
        "Пропуск операнда: b",
        "Пропуск операнда: a",
        "Пропуск операнда: a",
        "Пропуск операнда: 2",
        "Пропуск операнда: 2",
        "Неверный знак",
        "Неверный знак",
        "Ошибка в формуле вычисления s: пропущен квадратный корень",
        "Ошибка в формуле вычисления s: пропущен квадратный корень",
        "Ошибка в формуле вычисления s: неверный знаменатель",
        "Ошибка в формуле вычисления s: неверный знаменатель",
        "Ошибка в формуле вычисления s: перепутаны местами a и b",
        "Ошибка в формуле вычисления s: перепутаны местами a и b",
        "Ошибка в формуле вычисления s: пропущен квадратный корень; потерян знаменатель",
        "Ошибка в формуле вычисления s: пропущен квадратный корень; потерян знаменатель",
        "Ошибка в формуле вычисления s: потерян знаменатель",
        "Ошибка в формуле вычисления s: потерян знаменатель"};
    
    
    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления корня характеристического уравнения)
     * @param inputData a; b; c; D
     * @param studResult значение корня, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double a, b, c, D;
        a=inputData[0];
        b=inputData[1];
        c=inputData[2];
        D=inputData[3];

        double [] s = new double [message.length];
        
//-------------------Пропуск операнда-----------------------------------------//        
    
        // ~ sqrt(D)
        s[0] = -b/(2*a);
        // ~ b
        s[1] = Math.sqrt(D)/(2*a);
        s[2] = - Math.sqrt(D)/(2*a);
        // ~ a
        s[3] = (-b+Math.sqrt(D))/2;
        s[4] = (-b-Math.sqrt(D))/2;
        // ~ 2
        s[5] = (-b+Math.sqrt(D))/a;
        s[6] = (-b-Math.sqrt(D))/a;
        
//-----------------Неверный знак при вычислениях------------------------------//        
        
        s[7] = (b+Math.sqrt(D))/(2*a);   
        s[8] = (b-Math.sqrt(D))/(2*a);
        
//-------------------------Ошибка в формуле-----------------------------------//
        
        // ~ (-b+D)/2a
        s[9] = (-b+D)/(2*a);  
        s[10] = (-b-D)/(2*a);       
        // ~ (-b+sqrt(D))/2c
        s[11] = (-b-Math.sqrt(D))/(2*c);
        s[12] = (-b+Math.sqrt(D))/(2*c);
        // ~ (-a+sqrt(D))/2b
        s[13] = (-a-Math.sqrt(D))/(2*b);
        s[14] = (-a+Math.sqrt(D))/(2*b);
        // ~ (-b+D)
        s[15] = -b+D;
        s[16] = -b-D;
        // ~ (-b+sqrt(D))
        s[17] = -b+Math.sqrt(D);
        s[18] = -b-Math.sqrt(D);
        
        
        for (int i = 0; i < message.length; i++) {
            if (super.precisionCheck(s[i], studResult, resultPrecision, message[i]))
                return true;     
        }
        
        System.out.println("DM is not activated");
        return false;
    }
    
}
