package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-22 10:29
 * @Description:
 */
public class _1502_canMakeArithmeticProgression {

    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
