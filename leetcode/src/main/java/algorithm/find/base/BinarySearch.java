package algorithm.find.base;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 17:40
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] nums = {1,2,8,17,56,101,156,254};
        int target = 156;

        System.out.println(solution.binarySearch(nums, target));
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // mid向下取整，是左边数组的最后一位
            int mid =  (left + right) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
