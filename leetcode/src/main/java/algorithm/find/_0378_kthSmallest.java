package algorithm.find;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 13:19
 * @Description:
 */
public class _0378_kthSmallest {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int k = 16;
        _0378_kthSmallest solution = new _0378_kthSmallest();

        System.out.println(solution.kthSmallest(matrix, k));
    }


    public int kthSmallest(int[][] mat, int k) {
        int N = mat.length;
        int left = mat[0][0];                   // 左上角的值，矩阵的最小值，是值不是下标！！！
        int right = mat[N - 1][N - 1];          // 右下角的值，矩阵的最大值

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(mid, mat, N) == k) {
                right = mid - 1;
            } else if (getCount(mid, mat, N) > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 获得矩阵中大于等于mid的个数
    private int getCount(int mid, int[][] mat, int N) {
        int count = 0;
        int i = N - 1;
        int j = 0;
        while (i >= 0 && j < N) {
            if (mat[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}