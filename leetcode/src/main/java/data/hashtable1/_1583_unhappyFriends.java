package data.hashtable1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 05:18
 * @Description:
 */
public class _1583_unhappyFriends {


    public int unhappyFriends(int N, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();        // 保存配对情况
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }

        Map<Integer, Integer>[] rank = new HashMap[N];
        for (int i = 0; i < N; i++) {
            rank[i] = new HashMap<>();
            for (int j = 0; j < N - 1; j++) {
                rank[i].put(preferences[i][j], j);          // <值，下标>
            }
        }

        int notHappy = 0;
        for (int x = 0; x < N; x++) {
            int y = map.get(x);
            for (int u : preferences[x]) {
                if (u == y) {                           // 对每一个比y更亲近的
                    break;
                }
                int v = map.get(u);
                if (rank[u].get(x) < rank[u].get(v)) {  // 如果"u对x"比"u对v"还熟悉的话
                    notHappy += 1;                      // x可就不开心了,哼!
                    break;
                }
            }
        }
        return notHappy;
    }
}
