package algorithm;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-08-11 14:07
 * @Description:
 */
public class _16_06_smallestDifference {


    public int smallestDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        long res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            res = Math.min(res, Math.abs((long) nums1[i] - (long) nums2[j]));
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return (int) res;
    }
}
