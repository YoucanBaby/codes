package algorithm.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 23:11
 * @Description:
 */
public class _0658_findClosestElements {


    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int left = 0;
        int right = nums.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - nums[mid] <= nums[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(nums[i]);
        }
        return res;
    }
}
