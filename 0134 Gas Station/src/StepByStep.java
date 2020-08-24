public class StepByStep {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for (int i = 0; i < gas.length; i++) {
                if (gas[i] < cost[i]) {
                    continue;
                }
                if (valid (gas, cost, i)) {
                    return i;
                }
            }

            return -1;
        }

        private boolean valid(int[] gas, int[] cost, int idx) {
            int net = 0;
            for (int i = idx; i < gas.length; i++) {
                net += gas[i] - cost[i];
                if (net < 0) {
                    return false;
                }
            }

            for (int i = 0; i < idx; i++) {
                net += gas[i] - cost[i];
                if (net < 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
