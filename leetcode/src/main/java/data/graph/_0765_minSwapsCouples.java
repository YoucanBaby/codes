package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 05:50
 * @Description:
 */
public class _0765_minSwapsCouples {

    // 1.贪心
    public int minSwapsCouples(int[] row) {
        int N = row.length;
        int count = 0;
        for (int i = 0; i < N; i += 2) {
            if (row[i] == (row[i + 1] ^ 1)) {
                continue;
            }
            for (int j = i + 1; j < N; j++) {
                if (row[i] == (row[j] ^ 1)) {
                    int temp = row[i + 1];
                    row[i + 1] = row[j];
                    row[j] = temp;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
