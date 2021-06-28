package data.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
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
        System.out.println(solution.kthSmallest1(matrix, k));
        System.out.println(solution.kthSmallest2(matrix, k));
        System.out.println(solution.kthSmallest3(matrix, k));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] mat = new int[M * N];
        int index = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[index++] = matrix[i][j];
            }
        }
        Arrays.sort(mat);
        return mat[k - 1];
    }

    public int kthSmallest1(int[][] matrix, int k) {
        // 优先队列 用于存储 稀疏数组
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // N * N
        int N = matrix.length;

        // 添加第一列
        for (int i = 0; i < N; i++) {
            int[] next = new int[]{matrix[i][0], i, 0};
            pq.add(next);
        }

        int index = 0;
        // 循环矩阵
        while (index < N * N) {
            if (index == k - 1) {
                return pq.poll()[0];    // 找到，就返回
            } else {
                int[] now = pq.poll();  // 队头元素出队列
                if (now[2] != N - 1) {  // 添加刚刚出队列的队头元素的右边元素，最右边一列没有右边元素了，就不用添加。
                    int[] next = new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1};
                    pq.add(next);
                }
                index++;
            }
        }
        return -1;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int N = matrix.length;              // N
        int left = matrix[0][0];            // 左上角的值
        int right = matrix[N - 1][N - 1];   // 右下角的值
        // 有序矩阵的二分查找
        while(left < right) {
            int mid = (left + right) / 2;
            // k是否比mid小
            if (less(k, mid, matrix, N)) {
                right = mid;        // 在左上方
            } else {
                left = mid + 1;     // 在右下方
            }
        }
        return left;
    }

    private boolean less(int target, int mid, int[][] matrix, int N) {
        // 从左下角开始
        int i = N - 1;
        int j = 0;
        // 统计当前所在列的不大于 mid 的数的数量
        int num = 0;

        while(i >= 0 && j <= N -1) {
            if (matrix[i][j] <= mid) {
                num += (i + 1);
                j++;
            } else {
                i--;
            }
        }
        return target <= num;
    }

    public int kthSmallest3(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[M - 1][N - 1];

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            // 计算数组中比mid小的值
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    }
                }
            }
            if (count < k) {
                low = mid + 1;      // 在右边
            } else {
                high = mid - 1;     // 在左边
            }
        }
        return low;
    }
}