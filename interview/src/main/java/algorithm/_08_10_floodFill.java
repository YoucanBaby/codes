package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 02:40
 * @Description:
 */
public class _08_10_floodFill {

    int[][] image;
    int M;
    int N;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.M = image.length;
        this.N = image[0].length;

        // 特殊情况判断
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        dfs(sr, sc, oldColor, newColor);

        return image;
    }

    public void dfs(int i, int j, int oldColor, int newColor) {
        // 越界返回
        if (i < 0 || i >= M) {
            return;
        }
        if (j < 0 || j >= N) {
            return;
        }
        // 递归上下左右
        if (image[i][j] == oldColor) {
            image[i][j] = newColor;
            dfs(i - 1, j, oldColor, newColor);
            dfs(i + 1, j, oldColor, newColor);
            dfs(i, j - 1, oldColor, newColor);
            dfs(i, j + 1, oldColor, newColor);
        }
    }
}
