package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 09:13
 * @Description:
 */
public class _0400_findNthDigit {


    public int findNthDigit(int n) {
        n -= 1;
        for (int digit = 1; digit <= 10; digit++) {
            long firstNum = (long) Math.pow(10, digit - 1);
            if (n < 9 * firstNum * digit) {
                return String.valueOf((firstNum + n / digit)).charAt(n % digit) - '0';
            }
            n -= 9 * firstNum * digit;
        }
        return 0;
    }
}
