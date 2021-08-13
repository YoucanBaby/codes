package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 18:56
 * @Description:
 */
public class _0153_findMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == nums[right]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[left];
    }
}
