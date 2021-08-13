package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 06:28
 * @Description:
 */
public class _0233_countDigitOne {


    public int countDigitOne(int n) {
        int digit = 1;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int res = 0;
        while (n / digit != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else if (cur > 1) {
                res += high * digit + digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
