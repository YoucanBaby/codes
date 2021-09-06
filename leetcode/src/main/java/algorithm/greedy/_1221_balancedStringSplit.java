package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-09-07 00:34
 * @Description:
 */
public class _1221_balancedStringSplit {


    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }
}
