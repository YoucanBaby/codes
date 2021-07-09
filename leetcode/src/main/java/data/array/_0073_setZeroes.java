package data.array;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 11:50
 * @Description:
 */
public class _0073_setZeroes {

    public void setZeroes(int[][] nums) {
        int M = nums.length;
        int N = nums[0].length;

        // 第0行是否有0
        boolean flagRow0 = false;
        for (int j = 0; j < N; j++) {
            if (nums[0][j] == 0) {
                flagRow0 = true;
            }
        }

        // 第0列是否有0
        boolean flagCol0 = false;
        for (int i = 0; i < M; i++) {
            if (nums[i][0] == 0) {
                flagCol0 = true;
            }
        }

        // 把第0行和第0列对应的位置赋0
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (nums[i][j] == 0) {
                    nums[0][j] = 0;
                    nums[i][0] = 0;
                }
            }
        }

        // 把矩阵的这一行这一列位置赋为0
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (nums[0][j] == 0 || nums[i][0] == 0) {
                    nums[i][j] = 0;
                }
            }
        }

        // 第0行如果原本有0就把第0行都赋值为0
        if (flagRow0) {
            for (int j = 0; j < N; j++) {
                nums[0][j] = 0;
            }
        }

        // 第0列如果原本有0就把第0列都赋值为0
        if (flagCol0) {
            for (int i = 0; i < M; i++) {
                nums[i][0] = 0;
            }
        }
    }
}
