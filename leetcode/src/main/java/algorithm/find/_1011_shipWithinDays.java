package algorithm.find;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 07:29
 * @Description:
 */
public class _1011_shipWithinDays {


    public int shipWithinDays(int[] nums, int d) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(nums, mid) <= d) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getCount(int[] nums, int mid) {
        int count = 1;
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
