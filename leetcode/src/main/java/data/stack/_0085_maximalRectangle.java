package data.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-16 21:22
 * @Description:
 */
public class _0085_maximalRectangle {

    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };
        char[][] matrix = {{'1'}};
        _0085_maximalRectangle solution = new _0085_maximalRectangle();

        System.out.println(solution.maximalRectangle(matrix));
        System.out.println(solution.maximalRectangle1(matrix));
        }

    public int maximalRectangle1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return 0;

        int M = matrix.length;
        int N = matrix[0].length;

        int[][] nums = new int[M][N + 2];
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < M; i++) {
                if (matrix[i][j] == '0') {
                    nums[i][j + 1] = 0;
                    count = 0;
                } else if (matrix[i][j] == '1') {
                    count++;
                    nums[i][j + 1] = count;
                }
            }
        }

        N += 2;
        int area = 0;
        for (int i = 0; i < M; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addFirst(0);
            for (int j = 1; j < N; j++) {
                while (nums[i][j] < nums[i][stack.getFirst()]) {
                    int height = nums[i][stack.removeFirst()];
                    int width = j - stack.getFirst() - 1;
                    area = Math.max(area, height * width);
                }
                stack.addFirst(j);
            }
        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] left = new int[M][N];

        for (int i = 0; i < M; i++) {
            int count = 0;        // 统计左边为0个数
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = count + 1;
                    count++;
                } else if (matrix[i][j] == '0') {
                    left[i][j] = 0;
                    count = 0;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (left[i][j] == 0) {
                    continue;
                } else {
                    int width = left[i][j];
                    int area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        width = Math.min(width, left[k][j]);
                        area = Math.max(area, width * (i - k + 1));
                    }
                    ret = Math.max(ret, area);
                }
            }
        }
        return ret;
    }
}
