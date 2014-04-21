

package DiffModesCommon.DMpackage;

/**
 * Интерфейс всех диагностических моделей в приложении.
 * @author radeon
 */
public abstract class DM {
    
    public boolean precisionCheck(double refValue, double value, 
            double precision, String message)  {
        if (Math.abs(refValue-value) <= precision){
            System.out.println(message);
            return true; }
        return false;
    }
    
    abstract public boolean checkDiagnosis(double[] inputData, double studResult, double resultPrecision);
}
