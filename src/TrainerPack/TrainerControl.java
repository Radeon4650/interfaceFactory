/*
* Класс контроля за прохождением обучения с помощью тренера
* Следит за использованными подсказками
* Предназначен для взаимодействия с диагностическими моделями 
* и байесовскими сетями в приложении
 */

package TrainerPack;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author radeon
 */
public class TrainerControl {
    private final Map <String, Integer> usedHints; //какие подсказки были использованы во время обучения и сколько раз

    public TrainerControl() {
        usedHints = new HashMap();
        
        usedHints.put("formula_Fs", 0);
        usedHints.put("formula_sqEquation", 0);
        usedHints.put("formula_T1_T2", 0);
        usedHints.put("formula_Fs_t1t2", 0);
        usedHints.put("replacementSjw", 0);
        usedHints.put("abridgedMulFormula", 0);
        usedHints.put("formula_Aw", 0);
        usedHints.put("formula_passband", 0);
        usedHints.put("watchedDemo 1", 0);
        usedHints.put("watchedDemo 2", 0);
        usedHints.put("watchedDemo 3", 0);
        usedHints.put("watchedDemo 4", 0);
        usedHints.put("watchedDemo 5", 0);
        usedHints.put("watchedDemo 6", 0);
        usedHints.put("watchedDemo 7", 0);
        usedHints.put("watchedDemo 8", 0);
        
    }
    /** @return какие подсказки были использованы во время обучения и сколько раз */
    private Map <String, Integer> getUsedHints() {
        return usedHints;
    }
    
    public void useHint(String hintKey) {
        this.usedHints.put(hintKey, this.usedHints.get(hintKey)+1);
        changeDiagnosis(hintKey);
    }
    
    public void watchDemo(String pageNum) {
        this.usedHints.put("watchedDemo " + pageNum, this.usedHints.get("watchedDemo " + pageNum)+1);
        changeDiagnosis("watchedDemo " + pageNum);
    }
    
    private void changeDiagnosis(String hintKey) {
         /**тут сделать связь с баесовской сетью*/
    }
}
