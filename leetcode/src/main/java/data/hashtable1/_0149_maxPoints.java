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

    public int maxPoints(int[][] points) {
        int N = points.length;
        if (N <= 2) {
            return N;
        }

        int ret = 0;
        for (int i = 0; i < N - 1; i++) {
            Map<String, Integer> map = new HashMap<>();

            int max = 0;
            for (int j = i + 1; j < N; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                // 最大公约数
                int n = gcd(dx, dy);

                // 以化简后的形式a/b保存键
                String key = (dx / n) + "/" + (dy / n);
                map.put(key, map.getOrDefault(key, 0) + 1);

                // 计算由i发出的直线的数量
                max = Math.max(max, map.get(key));
            }
            // max+1是要把i也算进去
            ret = Math.max(ret, max + 1);
        }
        return ret;
    }

    // 用辗转相除法求最大公约数gcd：Greatest Common Divisor
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
