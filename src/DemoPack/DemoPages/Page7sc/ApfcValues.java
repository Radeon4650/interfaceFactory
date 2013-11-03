//Класс, содержащий 1 строку из таблицы АФЧХ

package DemoPack.DemoPages.Page7sc;

/**
 *
 * @author Radeon
 */
public class ApfcValues {
        private String w1;
        private String U1;
        private String V1;
        private String w2;
        private String U2;
        private String V2;
        
        public ApfcValues(String w1_value, String U1_value, String V1_value, String w2_value, String U2_value, String V2_value) {
            this.w1 = w1_value;
            this.U1 = U1_value;
            this.V1 = V1_value;
            this.w2 = w2_value;
            this.U2 = U2_value;
            this.V2 = V2_value;
        }

        public String getW1() {
            return w1;
        }

        public void setW1(String w1) {
            this.w1 = w1;
        }

        public String getU1() {
            return U1;
        }

        public void setU1(String U1) {
            this.U1 = U1;
        }

        public String getV1() {
            return V1;
        }

        public void setV1(String V1) {
            this.V1 = V1;
        }

        public String getW2() {
            return w2;
        }

        public void setW2(String w2) {
            this.w2 = w2;
        }

        public String getU2() {
            return U2;
        }

        public void setU2(String U2) {
            this.U2 = U2;
        }

        public String getV2() {
            return V2;
        }

        public void setV2(String V2) {
            this.V2 = V2;
        }
}
