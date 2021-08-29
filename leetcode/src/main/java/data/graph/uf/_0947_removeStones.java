package data.graph.uf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-30 00:15
 * @Description:
 */
public class _0947_removeStones {


    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(20010);
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(uf.find(stone[0]));
            set.add(uf.find(stone[1] + 10000));
        }
        return stones.length - set.size();
    }
}
