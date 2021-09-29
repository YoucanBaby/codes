package algorithm.find;

import java.text.DecimalFormat;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 15:55
 * @Description:
 */
public class _0069_mySqrt {

    // 数学：珍馐计算器算法
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int res = (int) Math.exp(0.5 * Math.log(x));
        return ((long) (res + 1) * (res + 1)) <= x ? res + 1 : res;
    }

    public static void main(String[] args) {
        _0069_mySqrt solution = new _0069_mySqrt();
        System.out.println(solution.mySqrt(9));
        System.out.println(solution.sqrt(10));
    }

    public double sqrt(int C) {
        if (C == 0 || C == 1) return C;

        double x0 = C;
        while (true) {
            double x1 = 0.5 * (x0 + C / x0);
            if (Math.abs(x1 - x0) < 1e-9) break;
            x0 = x1;
        }
        return x0;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int res = -1;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
