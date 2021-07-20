package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 11:35
 * @Description:
 */
public class _0022_generateParenthesis {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }

    // 左括号用了几个，右括号用了几个，左右括号一共要用几个
    public void dfs(int left, int right, int n) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            res.add(path.toString());
            return;
        }

        if (left < n) {
            path.append("(");
            dfs(left + 1, right, n);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < n) {
            path.append(")");
            dfs(left, right + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
