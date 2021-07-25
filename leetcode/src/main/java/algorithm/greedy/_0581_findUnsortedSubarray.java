package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 09:02
 * @Description:
 */
public class _0581_findUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        int max = nums[0];
        int min =  nums[N - 1];
        int left = 0;
        int right = -1;

        // 从左向右扫描，找右边界
        for (int i = 0; i < N; i++) {
            if (nums[i] < max) {
                right = i;
            }
            max = Math.max(max, nums[i]);
        }
        // 从右向左扫描，找左边界
        for (int i = N - 1; i >= 0; i--) {
            if (min < nums[i]) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return right - left + 1;
    }
}
