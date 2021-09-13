package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 06:46
 * @Description:
 */
public class _0119_getRow {


    public List<Integer> getRow(int n) {
        Integer[] row = new Integer[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    row[0] = 1;
                    continue;
                }
                if (j == i) {
                    row[i] = 1;
                    continue;
                }
                row[j] = row[j - 1] + row[j];
            }
        }
        return Arrays.asList(row);
    }
}
