package data.graph;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 02:21
 * @Description:
 */
public class _0997_findJudge {


    public int findJudge(int N, int[][] trusts) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        for (int[] t : trusts) {
            outDegree[t[0]]++;
            inDegree[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (outDegree[i] == 0 && inDegree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
