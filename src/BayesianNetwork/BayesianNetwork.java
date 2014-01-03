package BayesianNetwork;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import smile.Network;
import smile.SMILEException;

/**
 *
 * @author andrey shelest
 */
public class BayesianNetwork {

    protected Network net;
    private final int id;
    private final String paramName;
    private double[] aCalculate_parameter=new double[]{0.5, 0.5};
    private double[] aRefining=new double[]{0.01, 0.97, 0.01, 0.01, 0.4, 0.5, 0.99, 0.01};
    private double[] aOutput= new double[]{1, 0, 0.4, 0.6, 1, 0, 0.7, 0.3, 1, 0, 0.2, 0.8, 1, 0, 0.3, 0.7}; 
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String OS_arch = System.getProperty("os.arch");
    
    /**
     * Предварительно необходимо подключить библтотеку jSmile, функцией check_OS().
     * Создание сети без узлов.
     * @param paramName - имя параметра для проверки, напримет "ti"
     * @param id - номер подсети, глубина.
     * @throws Exception
     */
    public BayesianNetwork(String paramName, int id) throws Exception {

        //Инициализация массивов вероятностей состояний узлов
        this.id=id;
        this.paramName=paramName;
        try {
//            check_OS();
            net = new Network();
            createNetwork();
        } catch (SMILEException ex) {
            Logger.getLogger(BayesianNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Выводит в консоль состояние узла сети.
     * @param nodeName - имя узла.
     */
    public void print_node_status(String nodeName) {

        System.out.println(nodeName);
        double[] mass = net.getNodeValue(nodeName);
        for (int i = 0; i < mass.length; i++) {
            System.out.print("\t" + net.getOutcomeId(nodeName, i) + ": " + (int) (mass[i] * 100) + "%\n");
        }

    }

    /**
     * Выводит на консоль текущее состояние сети.
     */
    public void print_network_status() {
        String[] mass = net.getAllNodeIds();
        for (String mas : mass) {
            if (mas.indexOf(paramName) >= 0) {
                print_node_status(mas);
            }
        }
    }

    /**
     * создание сети из трёх узлов
     * Calculate---------------->Output
     *          \               /
     *           \Refining----/
     */
    public void createNetwork() {
        //создание и заполнение подсети

        final String Calculate = "Calculate_" + paramName + "_" + id;
        final String Refining = "Refining_" + paramName + "_" + id;
        final String Output = "Output_" + paramName + "_" + id;

        net.addNode(Network.NodeType.Cpt, Calculate);
        net.setOutcomeId(Calculate, 0, "right");
        net.setOutcomeId(Calculate, 1, "mistake");
//Узел отвечающий за уточнение вычисления проверяемого параметра
        net.addNode(Network.NodeType.Cpt, Refining);
        net.setOutcomeId(Refining, 0, "Answer_Hint");
        net.setOutcomeId(Refining, 1, "Answer_noHint");
        net.addOutcome(Refining, "noAnswer_Hint");
        net.addOutcome(Refining, "noAnswer_noHint");
        

//Узел содержит результат выполнения подсети
        net.addNode(Network.NodeType.Cpt, Output);
        net.setOutcomeId(Output, 0, "passed");
        net.setOutcomeId(Output, 1, "not_pass");

        //добавление связи от  "Calculate" -> "Refining" -> "Output":
        net.addArc(Calculate, Refining);
        net.addArc(Refining, Output);
        net.addArc(Calculate, Output);
        // Заполнение условного распределения для узла "Calculate_".
        // вероятности:
        // P("Calculate" = right) = 0.5       >>
        // P("Calculate" = mistake) = 0.5     >> та табличка которая в Genie
        net.setNodeDefinition(Calculate, aCalculate_parameter); //заполняем табличку

        // Учитывая связи узла "Refining".  
        // Вероятности его состояния:
        // P("Refining" = Answer_Hint | "Calculate" = right) = 0.01
        // P("Refining" = Answer_noHint | "Calculate" = right) = 0.97
        // P("Refining" = noAnswer_Hint | "Calculate" = right) = 0.01
        // P("Refining" = noAnswer_noHint | "Calculate" = right) = 0.01
        // P("Refining" = Answer_Hint | "Calculate" = mistake) = 0.4
        // P("Refining" = Answer_noHint | "Calculate" = mistake) = 0.5
        // P("Refining" = noAnswer_Hint | "Calculate" = mistake) = 0.99
        // P("Refining" = noAnswer_noHint | "Calculate" = mistake) = 0.01
        net.setNodeDefinition(Refining, aRefining);

    }

    /**
     *
     * @param nodeClassName - Calculate/Refining/Output.
     * @param evid - состояние, для установки в узел.
     */
    public void setNodeEvidence(String nodeClassName, String evid) {

        net.setEvidence(nodeClassName + "_" + paramName + "_" + id, evid);
        net.updateBeliefs();

    }
        
    public void setVirtualNodeEvidence(String nodeClassName, double[] evid) {

        net.setVirtualEvidence(nodeClassName + "_" + paramName + "_" + id, evid);
        net.updateBeliefs();

    }

    /**
     * Возвращает значения состояний узла Output
     * @return {passed, not_pass}
     */
    public double[] getOutputNodeValue() {
        double ret[]={getNodeValue("Output_" + paramName + "_" + id, "passed"),getNodeValue("Output_" + paramName + "_" + id, "not_pass")};
        return ret;
    }

    public double getNodeValue(String nodeName, String outcomeName) {
        // Getting the index of the "nodeName" outcome:
        int outcomeIndex;
        String[] aOutcomeIds = net.getOutcomeIds(nodeName);
        for (outcomeIndex = 0; outcomeIndex < aOutcomeIds.length; outcomeIndex++) {
            if (outcomeName.equals(aOutcomeIds[outcomeIndex])) {
                break;
            }
        }

        // Getting the value of the probability:
        double aValues[] = net.getNodeValue(nodeName);
        return aValues[outcomeIndex];
    }

    public static void setLibraryPath(String path) throws Exception {
        System.setProperty("java.library.path", path);
        System.out.println("java.library.path set to <<" + System.getProperty("java.library.path") + ">>");
        //set sys_paths to null
        final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);
        sysPathsField.set(null, null);
    }

    public static void check_OS() throws Exception {

        if (isWindows()) {
            System.out.println("This is Windows " + OS_arch);
            if (OS_arch.indexOf("64") >= 0) {
                setLibraryPath("lib/jsmile_win64");
            } else {
                setLibraryPath("lib/jsmile_win32");
            }
        } else if (isMac()) {
            System.out.println("This is Mac OS " + OS_arch);
            setLibraryPath("lib/jsmile_macosx_x64");
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux " + OS_arch);
            if (OS_arch.indexOf("64") >= 0) {
                setLibraryPath("lib/jsmile_linux64");
            } else {
                setLibraryPath("lib/jsmile_linux32");
            }
        } else if (isSolaris()) {
            System.out.println("This is Solaris " + OS_arch);
        } else {
            System.out.println("Your OS is not support!! " + OS_arch);
        }
    }

    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

    public static boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }

    /**
     * @param aCalculate_t
     * @param aCalculate_parameter the aCalculate_parameter to set
     */
    public void setaCalculate(double[] aCalculate_t) {
        this.aCalculate_parameter = aCalculate_t;
    }

    /**
     * @param aRefining the aRefining to set
     */
    public void setaRefining(double[] aRefining) {
        this.aRefining = aRefining;
    }

    /**
     * @param aOutput the aOutput to set
     */
    public void setaOutput(double[] aOutput) {
        this.aOutput = aOutput;
    }

}
