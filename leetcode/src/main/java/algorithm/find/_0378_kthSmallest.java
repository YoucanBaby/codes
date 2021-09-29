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
        int left = (int) -1e9;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(mat, mid) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 获得矩阵中大于等于mid的个数
    private int getCount(int[][] mat, int mid) {
        int count = 0;
        int N = mat.length;
        int x = N - 1, y = 0;
        while (x >= 0 && y < N) {
            if (mat[x][y] <= mid) {
                count += x + 1;
                y++;
            } else {
                x--;
            }
        }
        return count;
    }
}