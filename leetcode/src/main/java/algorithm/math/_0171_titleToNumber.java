package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-30 00:10
 * @Description:
 */
public class _0171_titleToNumber {

    public int titleToNumber(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            int temp = c - 'A' + 1;
            res = res * 26 + temp;
        }
        return res;
    }
}
