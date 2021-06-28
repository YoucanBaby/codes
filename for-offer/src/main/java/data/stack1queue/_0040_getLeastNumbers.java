package data.stack1queue;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack1queue
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 06:33
 * @Description:
 */
public class _0040_getLeastNumbers {

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        int k = 4;
        _0040_getLeastNumbers solution = new _0040_getLeastNumbers();

        System.out.println(solution.getLeastNumbers(arr, k));
        System.out.println(solution.getLeastNumbers2(arr, k));
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        return new int[0];
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ret = new int[k];

        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
