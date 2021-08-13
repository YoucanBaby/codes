package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 05:38
 * @Description:
 */
public class _0719_smallestDistancePair {

    public static void main(String[] args) {
        _0719_smallestDistancePair solution = new _0719_smallestDistancePair();

        int[] nums = {1,2,2,4,6,0};
        int k = 1;
        System.out.println(solution.smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int K) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(nums, K, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 小于等于mid的数对个数是否有K个（超过K也算）
    private boolean possible(int[] nums, int K, int mid) {
        int count = 0;
        int N = nums.length;
        int i = 0;
        for (int j = 0; j < N; j++) {
            while (nums[j] - nums[i] > mid) {
                i++;
            }
            count += j - i;
        }
        return count >= K;
    }
}
