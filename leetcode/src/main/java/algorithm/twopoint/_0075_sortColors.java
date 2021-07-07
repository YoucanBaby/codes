package algorithm.twopoint;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-06-22 09:58
 * @Description:
 */
public class _0075_sortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        _0075_sortColors solution = new _0075_sortColors();
        solution.sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;

        for (int i = 0; i <= p2; i++) {
            while (i <=p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
