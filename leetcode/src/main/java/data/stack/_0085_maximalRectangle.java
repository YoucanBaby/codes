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
        char[][] mat = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
//        char[][] mat = {{'1'}};
        _0085_maximalRectangle solution = new _0085_maximalRectangle();

        System.out.println(solution.maximalRectangle(mat));
        }


    public int maximalRectangle(char[][] m) {
        if (m.length == 0 || m[0].length == 0) {
            return 0;
        }

        int M = m.length;
        int N = m[0].length;
        int[][] mat = new int[M][N + 2];
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < M; i++) {
                if (m[i][j] == '0') {
                    mat[i][j + 1] = 0;
                    count = 0;
                } else if (m[i][j] == '1') {
                    count++;
                    mat[i][j + 1] = count;
                }
            }
        }
        N += 2;

        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }

        int res = 0;
        for (int i = 0; i < M; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                while (!stack.isEmpty() && mat[i][j] < mat[i][stack.peek()]) {
                    int h = mat[i][stack.pop()];
                    int w = j - stack.peek() - 1;
                    res = Math.max(res, h * w);
                }
                stack.push(j);
            }
        }
        return res;
    }
}
