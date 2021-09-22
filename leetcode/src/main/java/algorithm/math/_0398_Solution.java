package algorithm.math;

import java.util.Random;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 18:55
 * @Description:
 */
public class _0398_Solution {


    class Solution {
        int[] nums;
        Random r = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int n = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    n++;
                    if (r.nextInt() % n == 0) res = i;
                }
            }
            return res;
        }
    }
}
