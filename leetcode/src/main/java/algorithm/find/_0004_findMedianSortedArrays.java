package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 11:52
 * @Description:
 */
public class _0004_findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int M = nums1.length;
        int N = nums2.length;
        int totalLeft = (M + N + 1) / 2;             // 分割线左边的元素个数
        int left = 0;
        int right = M;

        // 在nums1的区间[0, M]里查找恰当的分割线，使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        while (left < right) {
            int i = (left + right) / 2;             // 分割线在第一个数组右边的第一个元素的下标i
            int j = totalLeft - i;                  // 分割线在第二个数组右边的第一个元素的下标j
            if (nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == M ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == N ? Integer.MAX_VALUE : nums2[j];

        if (((M + N) & 1) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
