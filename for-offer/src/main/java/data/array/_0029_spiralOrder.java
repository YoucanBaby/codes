package data.array;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: com.yifang
 * @Author: xuyifang
 * @CreateTime: 2021-06-10 22:08
 * @Description:
 */
public class _0029_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {  {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12}};
        _0029_spiralOrder solution = new _0029_spiralOrder();
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int c1 = 0;
        int c2 = cols - 1;
        int r1 = 0;
        int r2 = rows - 1;

        int[] ret = new int[rows * cols];
        int index = 0;      // 记录ret的下标

        while(r1 <= r2 && c1 <= c2) {
            // 上
            for (int i = c1; i <= c2; i++)
                ret[index++] = matrix[r1][i];
            // 右
            for (int i = r1 + 1; i <= r2; i++)
                ret[index++] = matrix[i][c2];
            // 下
            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)
                    ret[index++] = matrix[r2][i];
            // 左
            if (c1 != c2)
                for (int i = r2 - 1; i >= r1 + 1; i--)
                    ret[index++] = matrix[i][c1];
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ret;
    }
}
