package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-17 09:13
 * @Description:
 */
public class _0131_partition {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 如果不是回文串，跳过这个串
            if (!isPalindrome(s, start, i)) {
                continue;
            }

            String str = s.substring(start, i + 1);
            path.add(str);
            dfs(s, i + 1);      // 递归
            path.remove(path.size() - 1);   // 回溯
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        int left = start;
        int right = end;
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
