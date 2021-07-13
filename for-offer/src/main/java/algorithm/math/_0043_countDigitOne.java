package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 20:24
 * @Description:
 */
public class _0043_countDigitOne {

    public static void main(String[] args) {
        _0043_countDigitOne solution = new _0043_countDigitOne();

        System.out.println(solution.countDigitOne(32104));
    }

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
            } else {
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
