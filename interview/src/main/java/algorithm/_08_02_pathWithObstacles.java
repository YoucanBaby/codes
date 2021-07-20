package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 19:35
 * @Description:
 */
public class _08_02_pathWithObstacles {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathWithObstacles(int[][] board) {
        dfs(board, 0, 0);
        return res;
    }

    public boolean dfs(int[][] board, int i, int j) {
        int M = board.length;
        int N = board[0].length;

        // 越界，返回；有障碍物，返回false
        if (i >= M || j >= N || board[i][j] == 1) {
            return false;
        }

        res.add(Arrays.asList(i, j));       // 添加节点
        // 移动到右下角，返回true
        if (i == M - 1 && j == N - 1) {
            return true;
        }
        board[i][j] = 1;            // 访问过的坐标进行标记
        // 递归，回溯
        if (dfs(board, i + 1, j) || dfs(board, i, j + 1)) {
            return true;
        }
        res.remove(res.size() - 1);

        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        _08_02_pathWithObstacles solution = new _08_02_pathWithObstacles();

        List<List<Integer>> res = solution.pathWithObstacles(board);
        System.out.println(res);
    }
}
