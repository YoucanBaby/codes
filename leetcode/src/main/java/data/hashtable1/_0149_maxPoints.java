package data.hashtable1;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-24 10:40
 * @Description:
 */
public class _0149_maxPoints {

    public static void main(String[] args) {
        int[][] points = {
                {1,1},
                {3,2},
                {5,3},
                {4,1},
                {2,3},
                {1,4}
        };
        _0149_maxPoints solution = new _0149_maxPoints();

        System.out.println(solution.maxPoints(points));
    }

    public int maxPoints(int[][] p) {
        if (p.length == 1) return 1;
        int N = p.length;

        int res = 0;
        for (int i = 0; i < N - 1; i++) {
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < N; j++) {
                int dx = p[i][0] - p[j][0];
                int dy = p[i][1] - p[j][1];
                int n = gcd(dx, dy);

                String key = dx / n + "/" + dy / n;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + 1);       // 要把自己算进去
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
