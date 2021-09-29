package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 22:33
 * @Description:
 */
public class _0410_splitArray {


    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(nums, mid) <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getCount(int[] nums, int mid) {
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                count++;
            }
        }
        return count;
    }
}
