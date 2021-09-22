package data.hashtable1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 17:05
 * @Description:
 */
public class _0041_firstMissingPositive {



    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            while (nums[i] >= 1 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return N + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
