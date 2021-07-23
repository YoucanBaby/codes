package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 01:17
 * @Description:
 */
public class _0678_checkValidString {

    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                max--;
            } else if (c == '*') {
                if (min > 0) {
                    min--;
                }
                max++;
            }

            if (max < 0) {
                return false;
            }
        }

        return min == 0;
    }
}
