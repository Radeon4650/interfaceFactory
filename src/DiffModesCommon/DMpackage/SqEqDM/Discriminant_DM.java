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
public class Discriminant_DM extends DM {

    /**
     * @return true, если диагностическая модель сработала (диагностирована
     * ошибка вычисления дискриминанта)
     * @param inputData a; b; c
     * @param studResult значение D, введенное пользователем
     * @param resultPrecision точность вычисления
     */
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData == null) return false;
        double a, b, c, D;
        a = inputData[0];
        b = inputData[1];
        c = inputData[2];

    // Пропуск операнда
    // D = b-4ac
        D = b - 4 * a * c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: b");
            return true; }

    // D = b*b-ac
        D = b * b - a * c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: 4");
            return true; }

    // D = b*b-4a
        D = b*b - 4 * a;
        if ((Math.abs(D - studResult) < resultPrecision)&(c!=1)) {
            System.out.println("Пропуск операнда: c");
            return true; }

    // D = b*b-4c
        D = b*b - 4 * c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: a");
            return true; }

    // Пропуск операнда lvl2
    // D=b
        D = b;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: lvl2.1");
            return true; }
        
    // D=b*b
        D = b*b;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: lvl2.2");
            return true; }
        
    // D=-4ac
        D = -4*a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: lvl2.3");
            return true; }
        
    // D=-ac
        D = -a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: lvl2.4");
            return true; }
        
    // D=4ac
        D = 4*a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: lvl2.5");
            return true; }
        
    // D=ac
        D = a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Пропуск операнда: lvl2.6");
            return true; }
        
    // Ошибка в знаке вычисления
    // D=b*b+4ac
        D = b*b+4*a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Ошибка знака вычисления: b*b+4ac");
            return true; }
        
    // D=-b*b+4ac
        D = -b*b+4*a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Ошибка знака вычисления: -b*b+4ac");
            return true; }
        
    // D=-b*b-4ac
        D = -b*b-4*a*c;
        if (Math.abs(D - studResult) < resultPrecision) {
            System.out.println("Ошибка знака вычисления: -b*b-4ac");
            return true; }
        
        return false;
    }

}
