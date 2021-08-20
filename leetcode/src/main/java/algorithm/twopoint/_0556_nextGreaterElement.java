package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-19 11:11
 * @Description:
 */
public class _0556_nextGreaterElement {


    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int N = nums.length;

        int left = N - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left >= 0) {
            int right = N - 1;
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }
            swap(nums, left, right);
            reverse(nums, left + 1, N - 1);
            try {
                return Integer.valueOf(new String(nums));
            } catch (Exception e) {
                return -1;
            }
        } else {
            return -1;
        }
    }

    private void reverse(char[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
