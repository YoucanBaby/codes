package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-08-02 07:43
 * @Description:
 */
public class _0392_isSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }
}
