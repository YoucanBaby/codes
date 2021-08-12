package algorithm.sort;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 10:11
 * @Description:
 */
public class _0945_minIncrementForUnique {

    public int minIncrementForUnique(int[] nums) {
        int[] freq = new int[200000];
        int max = 0;
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, num);
        }

        int res = 0;
        for (int i = 0; i < max; i++) {
            if (freq[i] > 1) {
                res += freq[i] - 1;
                freq[i + 1] += freq[i] - 1;
            }
        }

        if (freq[max] > 1) {
            int n = freq[max] - 1;
            res += (n + 1) * n / 2;
        }
        return res;
    }
}
