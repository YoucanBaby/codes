package odd._258;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._258
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 11:11
 * @Description:
 */
public class _5869_maxProduct {

    public static void main(String[] args) {
        _5869_maxProduct solution = new _5869_maxProduct();
        String ss = "leetcodecom";
        System.out.println(solution.maxProduct(ss));
    }

    int res = 0;

    public int maxProduct(String ss) {
        char[] s = ss.toCharArray();
        dfs(s, 0, "", "");
        return res;
    }

    private void dfs(char[] s, int index, String s1, String s2) {
        if (isValid(s1) && isValid(s2)) {
            res = Math.max(res, s1.length() * s2.length());
        }
        if (index == s.length) {
            return;
        }
        dfs(s, index + 1, s1 + s[index], s2);
        dfs(s, index + 1, s1, s2 + s[index]);
        dfs(s, index + 1, s1, s2);
    }

    private boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
