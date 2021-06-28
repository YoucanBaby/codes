package algorithm.sort;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-20 13:46
 * @Description:
 */
public class _0021_exchange {

    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }

        return nums;
    }
}
