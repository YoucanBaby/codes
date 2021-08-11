package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-11 09:46
 * @Description:
 */
public class _0922_sortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int p0 = 0;     // 偶坐标
        int p1 = 1;     // 奇坐标
        int N = nums.length;
        while (p0 < N && p1 < N) {

            while (p0 < N && (nums[p0] & 1) == 0) {
                p0 += 2;
            }
            while (p1 < N && (nums[p1] & 1) == 1) {
                p1 += 2;
            }
            if (p0 < N && p1 < N) {
                swap(nums, p0, p1);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
