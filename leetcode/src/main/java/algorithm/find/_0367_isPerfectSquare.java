package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 16:19
 * @Description:
 */
public class _0367_isPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 0;
        int right = num - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else if ((long) mid * mid > num) {
                right = mid - 1;
            }
        }
        return false;
    }
}
