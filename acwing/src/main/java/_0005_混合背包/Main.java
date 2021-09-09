package _0005_混合背包;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: _0005_混合背包
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 21:19
 * @Description:
 */
public class Main {

    class Good {
        int kind;
        int v, w;

        public Good(int kind, int v, int w) {
            this.kind = kind;
            this.v = v;
            this.w = w;
        }
    }

    public int hybridBag(int[] s, int[] v, int[] w, int V, int N) {
        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (s[i] <= 0) {            // 01背包和完全背包
                goods.add(new Good(s[i], v[i], w[i]));
            } else {
                int c = s[i];             // 第i件物品的个数
                for (int k = 1; k <= s[i]; k *= 2) {
                    c -= k;
                    goods.add(new Good(s[i], v[i] * k, w[i] * k));
                }
                if (c > 0) {
                    goods.add(new Good(s[i], v[i] * c, w[i] * c));
                }
            }
        }

        int[] dp = new int[N + 1];
        for (Good good : goods) {
            if (good.kind == -1) {      // 01背包
                for (int j = V; j >= good.v; j--) {
                    dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
                }
            } else {                    // 完全背包和多重背包
                for (int j = good.v; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
                }
            }
        }
        return dp[N];
    }
}
