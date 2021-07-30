package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-30 01:14
 * @Description:
 */
public class _0044_findNthDigit {


    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (sb.length() - 1 < n) {
            sb.append(String.valueOf(i));
            i++;
        }

        return sb.charAt(n) - '0';
    }
}
