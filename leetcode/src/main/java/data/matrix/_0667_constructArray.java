package data.matrix;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 02:35
 * @Description:
 */
public class _0667_constructArray {

    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        _0667_constructArray solution = new _0667_constructArray();

        int[] arr = solution.constructArray(n, k);
        System.out.println(Arrays.toString(arr));
    }

    public int[] constructArray(int n, int k) {

        int[] ret = new int[n];

        // 1.构建等差数列
        for (int i = 0; i < n - k - 1; i++) {
            ret[i] = i + 1;
        }

        // 2.构建交错数列
        int flag = 0;       // 控制交错的变量
        int left = n - k;
        int right = n;

        for (int i = n - k - 1; i < n; i++) {
            if (flag % 2 == 0) {
                ret[i] = left;
                left++;
            } else {
                ret[i] = right;
                right--;
            }
            flag++;
        }
        return ret;
    }
}
