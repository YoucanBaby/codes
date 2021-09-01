package algorithm.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 04:56
 * @Description:
 */
public class _0301_removeInvalidParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()())()";
        System.out.println(solution.removeInvalidParentheses(s));
    }

    static class Solution {
        List<String> res = new ArrayList<>();

        public List<String> removeInvalidParentheses(String s) {
            int left = 0;
            int right = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    left++;
                } else if (c == ')') {
                    if (left == 0) {
                        right++;
                    } else {
                        left--;
                    }
                }
            }

            dfs(s, 0, left, right);
            return res;
        }

        public void dfs(String s, int start, int left, int right) {
            if (left == 0 && right == 0) {
                if (isValid(s)) {
                    res.add(s);
                }
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (i - 1 >= start && s.charAt(i) == s.charAt(i - 1)) {     // 去重
                    continue;
                }

                if (left > 0 && s.charAt(i) == '(') {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right);
                }
                if (right > 0 && s.charAt(i) == ')') {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1);
                }
            }
        }

        private boolean isValid(String s) {
            int left = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    left++;
                } else if (c == ')') {
                    if (left == 0) {
                        return false;
                    } else {
                        left--;
                    }
                }
            }
            return left == 0;
        }
    }
}
