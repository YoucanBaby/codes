package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-10 13:04
 * @Description:
 */
public class _0733_floodFill {

    int[][] dirs = {
            {-1, 0}, {1, 0},    // 上下
            {0, -1}, {0 , 1}    // 左右
    };
    int[][] image;
    int M;
    int N;
    int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        M = image.length;
        N = image[0].length;
        this.newColor = newColor;

        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        dfs(sr, sc, oldColor);

        return image;
    }

    public void dfs(int i, int j, int oldColor) {
        if (i < 0 || i >= M) {
            return;
        }
        if (j < 0 || j >= N) {
            return;
        }
        if (image[i][j] == oldColor) {
            image[i][j] = newColor;
            for (int k = 0; k < dirs.length; k++) {
                int nextI = i + dirs[k][0];
                int nextJ = j + dirs[k][1];
                dfs(nextI, nextJ, newColor);
            }
        }
    }
}
