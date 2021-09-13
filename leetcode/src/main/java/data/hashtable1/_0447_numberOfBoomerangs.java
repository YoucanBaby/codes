package data.hashtable1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-13 08:02
 * @Description:
 */
public class _0447_numberOfBoomerangs {


    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distAndFreq = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dist = dx * dx + dy * dy;
                distAndFreq.put(dist, distAndFreq.getOrDefault(dist, 0) + 1);
            }
            for (int val : distAndFreq.values()) {
                if (val > 1) {
                    res += val * (val - 1);
                }
            }
        }
        return res;
    }
}
