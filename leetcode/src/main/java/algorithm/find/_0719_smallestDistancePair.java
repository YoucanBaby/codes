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
        int right = (int) 1e7;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(nums, mid) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getCount(int[] nums, int mid) {
        int count = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (nums[j] - nums[i] > mid) i++;
            count += j - i;
        }
        return count;
    }


}
