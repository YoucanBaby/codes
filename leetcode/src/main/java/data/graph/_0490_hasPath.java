package data.graph;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-28 03:18
 * @Description:
 */
public class _0490_hasPath {

    public static void main(String[] args) {
        _0490_hasPath solution = new _0490_hasPath();
        int[][] mat = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] target = {4,4};

        System.out.println(solution.hasPath(mat, start, target));
    }

    int[][] dirs = {
            {-1, 0}, {1, 0},
            {0, -1}, {0 , 1}
    };

    int[][] mat;
    int M;
    int N;

    public boolean hasPath(int[][] mat, int[] start, int[] target) {
        this.mat = mat;
        M = mat.length;
        N = mat[0].length;

        return dfs(start[0], start[1], target);
    }

    private boolean dfs(int x, int y, int[] target) {
        if (x == target[0] && y == target[1]) {
            return true;
        }

        mat[x][y] = -1;
        for (int[] dir : dirs) {
            int nextX = x;
            int nextY = y;

            while (inArea(nextX + dir[0], nextY + dir[1]) && mat[nextX + dir[0]][nextY + dir[1]] != 1) {
                nextX += dir[0];
                nextY += dir[1];
            }
            if (mat[nextX][nextY] != -1) {              // 没有访问过当前节点
                if (dfs(nextX, nextY, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
