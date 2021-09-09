package _0004_多重背包;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: _0004_多重背包
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 13:17
 * @Description:
 */
public class Main {

    public int multipleBag(int[] s, int[] v, int[] w, int V, int N) {
        int[] dp = new int[V + 1];

        for (int i = 0; i < N; i++) {       // 枚举物品
            for (int j = w[i]; j <= V; j++) {   // 枚举容量
                for (int k = 1; k <= s[i]; k++) {   // 枚举物品个数
                    if (j - k * v[i] < 0) {             // 拿不起k个物品，就退出
                        break;
                    }
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }


    class Good {
        int v;
        int w;

        public Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int multipleBag1(int[] s, int[] v, int[] w, int V, int N) {
        // 二进制压缩
        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int c = s[i];             // 第i件物品的个数
            for (int k = 1; k <= s[i]; k *= 2) {
                c -= k;
                goods.add(new Good(v[i] * k, w[i] * k));
            }
            if (c > 0) {
                goods.add(new Good(v[i] * c, w[i] * c));
            }
        }

        // 转化为01背包
        int[] dp = new int[V + 1];
        for (Good good : goods) {
            for (int j = V; j >= good.v; j--) {
                dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
            }
        }
        return dp[V];
    }
}
