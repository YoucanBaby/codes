package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 20:50
 * @Description:
 */
public class _1122_relativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        _1122_relativeSortArray solution = new _1122_relativeSortArray();

        int[] res = solution.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }



    public int[] relativeSortArray(int[] nums1, int[] nums2) {
        int max = Arrays.stream(nums1).max().getAsInt();
        int[] freq = new int[max + 1];
        for (int num : nums1) {
            freq[num]++;
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            while (freq[nums2[i]] > 0) {
                res[index++] = nums2[i];
                freq[nums2[i]]--;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                res[index++] = i;
                freq[i]--;
            }
        }
        return res;
    }
}
