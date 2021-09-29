package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-12 16:19
 * @Description:
 */
public class _0367_isPerfectSquare {

    public boolean isPerfectSquare(int x) {
        if (x == 0 || x == 1) return true;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid == x) return true;
            else if ((long) mid * mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
