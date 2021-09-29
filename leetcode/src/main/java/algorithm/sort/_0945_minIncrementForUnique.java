package algorithm.sort;

import java.util.Arrays;

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
        int max = Arrays.stream(nums).max().getAsInt();
        for (int num : nums) {
            freq[num]++;
        }

        int count = 0;
        for (int i = 0; i < max; i++) {
            if (freq[i] > 1) {
                count += freq[i] - 1;
                freq[i + 1] += freq[i] - 1;
            }
        }

        if (freq[max] > 1) {
            int n = freq[max] - 1;
            count += (n + 1) * n / 2;
        }
        return count;
    }
}
