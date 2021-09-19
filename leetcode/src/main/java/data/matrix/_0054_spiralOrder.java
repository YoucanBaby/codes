package data.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-17 22:10
 * @Description:
 */
public class _0054_spiralOrder {


    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        int u = 0;
        int d = mat.length - 1;
        int l = 0;
        int r = mat[0].length - 1;
        while (true) {
            for (int j = l; j <= r; j++) res.add(mat[u][j]);
            if (u++ >= d) break;
            for (int i = u; i <= d; i++) res.add(mat[i][r]);
            if (r-- <= l) break;
            for (int j = r; j >= l; j--) res.add(mat[d][j]);
            if (d-- <= u) break;
            for (int i = d; i >= u; i--) res.add(mat[i][l]);
            if (l++ >= r) break;
        }
        return res;
    }
}
