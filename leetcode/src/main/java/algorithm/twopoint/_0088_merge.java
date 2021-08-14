package algorithm.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 15:28
 * @Description:
 */
public class _0088_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            int num = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            nums1[index] = num;
            index--;
        }
        while (p2 >= 0) {
            nums1[index] = nums2[p2];
            index--;
            p2--;
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while (p2 >= 0) {
            nums1[index--] = nums2[p2--];
        }
    }
}
