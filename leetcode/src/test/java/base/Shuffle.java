package base;

import java.util.Random;

/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-09-26 09:59
 * @Description:
 */
class Shuffle {

    int[] nums;
    int[] copy;
    Random random = new Random();

    public Shuffle(int[] nums) {
        this.nums = nums;
        copy = nums.clone();
    }

    public int[] reset() {
        this.nums = copy.clone();
        return nums;
    }

    public int[] shuffle() {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            swap(nums, i, i + random.nextInt(N - i));
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
