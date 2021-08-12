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

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(nums, mid) == k) {
                right = mid - 1;
            } else if (getCount(nums, mid) < k) {
                left = mid + 1;
            } else if (getCount(nums, mid) > k){
                right = mid - 1;
            }
        }
        return left;
    }

    // 计算小于等于distance的数对个数
    private int getCount(int[] nums, int distance) {
        int count = 0;
        int N = nums.length;
        int i = 0;
        for (int j = 0; j < N; j++) {
            while (nums[j] - nums[i] > distance) {
                i++;
            }
            count += j - i;
        }
        return count;
    }
}
