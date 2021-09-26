package algorithm.math;

import java.util.Random;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-24 16:45
 * @Description:
 */
public class _0384_Solution {



    class Solution {
        int[] nums;
        int[] copy;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
            copy = nums.clone();
        }

        public int[] reset() {
            this.nums = copy.clone();
            return nums;
        }

        public int[] shuffle() {
            int N = nums.length;
            for (int i = 0; i < N; i++) {
                swap(nums, i, i + random.nextInt(N - i));
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
