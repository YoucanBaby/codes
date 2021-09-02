package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 17:14
 * @Description:
 */
public class _0980_uniquePathsIII {

    public static void main(String[] args) {
        int[][] mat = {
                {1,0,0,0}, {0,0,0,0}, {0,0,2,-1}
        };
        _0980_uniquePathsIII solution = new _0980_uniquePathsIII();

        System.out.println(solution.uniquePathsIII(mat));
    }


    int[][] dirs = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
    };
    int res = 0;

    public int uniquePathsIII(int[][] mat) {
        int startX = 0;
        int startY = 0;
        int stepNum = 1;        // 需要走的步数
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (mat[i][j] == 0) {
                    stepNum++;
                }
            }
        }

        dfs(mat, startX, startY, stepNum);
        return res;
    }

    private void dfs(int[][] mat, int x, int y, int stepNum) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) {
            return;
        }
        if (mat[x][y] == -1) {
            return;
        }
        if (mat[x][y] == 2) {   // 到终点了
            if (stepNum == 0) {
                res++;
            }
            return;
        }

        mat[x][y] = -1;
        for (int[] dir : dirs) {
           dfs(mat, x + dir[0], y + dir[1], stepNum - 1);
        }
        mat[x][y] = 0;
    }
}
