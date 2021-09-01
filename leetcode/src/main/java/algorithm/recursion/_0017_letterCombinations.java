package algorithm.recursion;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-16 19:59
 * @Description:
 */
public class _0017_letterCombinations {



    class Solution {
        Map<Character, String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        public List<String> letterCombinations(String s) {
            if (s.equals("")) {
                return new ArrayList<>();
            }

            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");

            dfs(s);
            return res;
        }

        private void dfs(String s) {
            if (path.length() == s.length()) {
                res.add(path.toString());
                return;
            }

            char key = s.charAt(path.length());
            String value = map.get(key);
            for (char c : value.toCharArray()) {
                path.append(c);
                dfs(s);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
