package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 16:00
 * @Description:
 */
public class _16_19_pondSizes {

    public static void main(String[] args) {
        int[][] mat = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        _16_19_pondSizes solution = new _16_19_pondSizes();

        System.out.println(Arrays.toString(solution.pondSizes(mat)));
    }

    int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public int[] pondSizes(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                if (mat[x][y] == 0) {
                    int area = dfs(mat, x, y);
                    if (area != 0) {
                        res.add(area);
                    }
                }
            }
        }

        Collections.sort(res);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private int dfs(int[][] mat, int x, int y) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) {
            return 0;
        }
        if (mat[x][y] != 0) {
            return 0;
        }

        mat[x][y] = 1;
        int area = 1;
        for (int[] dir : dirs) {
            area += dfs(mat, x + dir[0], y + dir[1]);
        }
        return area;
    }
}
