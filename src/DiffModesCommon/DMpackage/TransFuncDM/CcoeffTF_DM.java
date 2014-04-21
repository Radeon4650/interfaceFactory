/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DiffModesCommon.DMpackage.TransFuncDM;

import DiffModesCommon.DMpackage.DM;

/**
 *
 * @author radeon
 */
public class CcoeffTF_DM extends DM{
    @Override
    public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision) {
        if (inputData==null) return false;
        double k1, k2, k3, k5, k6;
            k1 = inputData[0];
            k2 = inputData[1];
            k3 = inputData[2];
            k5 = inputData[3];
            k6 = inputData[4];
        double c = k1*k2*k3*k5*k6+1;
        String message = "Коэффициент с не приведен к 1.";
        
            if (super.precisionCheck(c, studResult, resultPrecision, message))
                return true;     
        
        System.out.println("DM is not activated");
        return false;
    }
    
}
