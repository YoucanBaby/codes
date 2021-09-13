package algorithm.sort;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 05:04
 * @Description:
 */
public class _0324_wiggleSort {


    public void wiggleSort(int[] nums) {
        int[] freq = new int[5001];
        for (int num : nums) {
            freq[num]++;
        }

        int N = nums.length;
        int small = 0;          // 小数字的边界
        int big = 0;            // 大数字的边界
        if ((N & 1) == 1) {     // 总长度为奇数时：“小 大 小 大 小”
            small = N - 1;
            big = N - 2;
        } else {                // 总长度为偶数时：“小 大 小 大”
            small = N - 2;
            big = N - 1;
        }

        // 从后向前遍历桶，先放大数字，再放小数字
        int index = 5000;
        for (int i = 1; i <= big; i += 2) {
            while (freq[index] == 0) {
                index--;
            }
            nums[i] = index;
            freq[index]--;
        }
        for (int i = 0; i <= small; i += 2) {
            while (freq[index] == 0) {
                index--;
            }
            nums[i] = index;
            freq[index]--;
        }
    }


}
