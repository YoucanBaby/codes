package algorithm.find;

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

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        int right = x - 1;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                res = mid;
                left = mid  + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
