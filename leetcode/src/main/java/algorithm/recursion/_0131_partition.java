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


    class Solution {
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
                String str = s.substring(start, i + 1);
                if (isPalindrome(str)) {
                    path.add(str);
                    dfs(s, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
