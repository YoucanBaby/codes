package algorithm.greedy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-10-01 00:08
 * @Description:
 */
public class _1436_destCity {


    // 思路：终点的出度为0
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
