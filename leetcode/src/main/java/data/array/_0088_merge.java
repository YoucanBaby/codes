package data.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 15:28
 * @Description:
 */
public class _0088_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            int num = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
            list.add(num);
        }
        while (p1 < m) {
            list.add(nums1[p1]);
            p1++;
        }
        while (p2 < n) {
            list.add(nums2[p2]);
            p2++;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = list.get(i);
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
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
}
