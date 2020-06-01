import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Backtrack {

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,5};
        List<List<Integer>> ans = new Solution ().combinationSum2 (arr, 5);
        System.out.println (ans);
    }

    static class Solution {
        List<List<Integer>> ans = new LinkedList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            if(candidates == null || candidates.length == 0){
                return ans;
            }
            Arrays.sort(candidates);
//            boolean[] used = new boolean[candidates.length];
            backtrack(0, candidates.length, new ArrayDeque<Integer>(), 0, target, candidates/*, used*/);
            return ans;
        }
        private void backtrack(int start, int n, ArrayDeque<Integer> curr, int sum, int target, int[] arr/*, boolean[] used*/){
            // 递归内部，第一条要检查是否满足条件非常重要
            if(sum == target){
                ans.add(new LinkedList(curr));
                return;
            }

            // 因为用了for循环，会检查start越界情况，所以这里可以省略
//            if(start >= n){
//                return;
//            }

            // 因为在for循环中进行了 arr[i] > target - sum 剪枝，所以这里也可以省略
//            if(sum > target){
//                return;
//            }

            for(int i = start; i < n; i ++){
                if(arr[i] > target - sum){
                    break;
                }
                // 这里的条件可以改为：i > start,
                // 这样可以有效的避免同级相同元素，
                // 并且不会遗漏不同级的相同元素，
                // see：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
//                if(i > 0 && arr[i] == arr[i-1] && used[i-1] == false){
//                    continue;
//                }
                // 同时省略used空间
                if(i > start && arr[i] == arr[i-1]){
                    continue;
                }
                curr.addLast(arr[i]);
//                used[i] = true;
                backtrack(i+1, n, curr, sum+arr[i], target, arr/*, used*/);
//                used[i] = false;
                curr.removeLast();
            }
        }
    }
}
