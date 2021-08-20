package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 18:19
 * @Description:
 */
public class _01_05_oneEditAway {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (first == null || second == null || Math.abs(len1 - len2) > 1) {
            return false;
        }
        if (len1 < len2) {
            return oneEditAway(second, first);      // 保证第一个字符串比第二个字符串长
        }

        // 遍历第二个字符串
        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) == second.charAt(i)) {
                continue;
            } else {
                if (len1 == len2) {
                    return first.substring(i + 1).equals(second.substring(i + 1));
                } else {
                    return first.substring(i + 1).equals(second.substring(i));
                }
            }
        }
        return true;
    }
}
