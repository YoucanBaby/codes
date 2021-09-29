package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 18:56
 * @Description:
 */
public class _0153_findMin {

    public static void main(String[] args) {
        _0153_findMin solution = new _0153_findMin();


        int[] nums = {3,4,5,1,2};
        System.out.println(solution.findMin(nums));
        System.out.println(solution.findMin1(nums));

        int[] nums2 = {8,4,6,7};
        System.out.println(solution.findMin1(nums2));
    }

    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else if (nums[left] > nums[mid]) {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
