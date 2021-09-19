package odd._258;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._258
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 10:38
 * @Description:
 */
public class _5868_interchangeableRectangles {


    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();         // <宽高比，数量>
        for (int[] r : rectangles) {
            double key = (double) r[0] / (double) r[1];
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        long res = 0;
        for (Map.Entry<Double, Long> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res += getCount(entry.getValue());
            }
        }
        return res;
    }

    private long getCount(long val) {
        long count = 0;
        while (val-- > 0) {
            count += val;
        }
        return count;
    }
}
