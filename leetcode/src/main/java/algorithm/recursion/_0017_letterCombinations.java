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

    Map<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        // 处理特殊情况
        if (digits.equals("")) {
            return new ArrayList<>();
        }

        // 初始化哈希表
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(digits);
        return res;
    }

    public void dfs(String digits) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        char key = digits.charAt(path.length());
        String value = map.get(key);

        for (char c : value.toCharArray()) {
            path.append(c);
            dfs(digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
