package algorithm.recursion;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-01 17:49
 * @Description:
 */
public class _0351_numberOfPatterns {


    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];     // skip数组记录跳跃的点数，比如说从1到3，就跳跃2
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        skip[7][9] = skip[9][7] = 8;

        int res = 0;
        boolean[] visited = new boolean[10];
        for(int i = m; i <= n; i++){
            res += dfs(visited, skip, 1, i - 1) * 4;   // 1,3,7,9对称
            res += dfs(visited, skip, 2, i - 1) * 4;   // 2,4,6,8对称
            res += dfs(visited, skip, 5, i - 1);       // 5独立
        }
        return res;
    }

    public int dfs(boolean[] visited, int[][] skip, int cur, int remainKeyCount){
        if(remainKeyCount == 0){
            return 1;
        }

        int res = 0;
        visited[cur] = true;
        for(int next = 1; next <= 9; next++){
            int crossThroughNumber = skip[cur][next];
            if(!visited[next] && (crossThroughNumber == 0 || visited[crossThroughNumber])){
                res += dfs(visited, skip, next, remainKeyCount - 1);
            }
        }
        visited[cur] = false;
        return res;
    }
}
