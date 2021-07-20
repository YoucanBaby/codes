package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-20 13:09
 * @Description:
 */
public class _08_09_generateParenthesis {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }

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
