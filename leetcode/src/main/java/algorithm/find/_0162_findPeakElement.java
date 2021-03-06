package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 21:14
 * @Description:
 */
public class _0162_findPeakElement {


    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]){
                right = mid;
            }
        }
        return left;
    }
}
