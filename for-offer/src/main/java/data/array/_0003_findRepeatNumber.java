package data.array;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: com.yifang
 * @Author: xuyifang
 * @CreateTime: 2021-06-10 20:00
 * @Description:
 */
public class _0003_findRepeatNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 1, 3};
        _0003_findRepeatNumber solution = new _0003_findRepeatNumber();
        System.out.println(solution.findRepeatNumber(arr));
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
