package algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 00:28
 * @Description:
 */
public class _0166_fractionToDecimal {

    public static void main(String[] args) {
        _0166_fractionToDecimal solution = new _0166_fractionToDecimal();

        System.out.println(solution.fractionToDecimal(7, 43));
    }

    // n/d, n是分子, d是分母; a/b, a是分子, b是分母，c是余数
    public String fractionToDecimal(int n, int d) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if (n > 0 ^ d > 0) sb.append("-");

        long a = Math.abs(Long.valueOf(n));
        long b = Math.abs(Long.valueOf(d));
        sb.append(a / b);

        long c = a % b;
        if (c == 0) return sb.toString();
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (c != 0) {
            if (map.containsKey(c)) {
                sb.insert(map.get(c), "(");
                sb.append(")");
                break;
            }
            map.put(c, sb.length());
            c *= 10;
            sb.append(c / b);
            c %= b;
        }
        return sb.toString();
    }
}
