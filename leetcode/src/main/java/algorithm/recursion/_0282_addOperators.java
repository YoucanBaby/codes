package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 17:55
 * @Description:
 */
public class _0282_addOperators {



    public List<String> addOperators(String s, int target) {
        List<String> res = new ArrayList<>();
        String path = "";
        dfs(res, path, s, target, 0, 0, 0);
        return res;
    }

    // val是path的值，pre是上一串数字
    private void dfs(List<String> res, String path, String s, int target, int start, long val, long pre) {
        if (start == s.length() && val == target) {
            res.add(path);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(start) == '0') {        // 首位是0
                return;
            }

            long num = Long.valueOf(s.substring(start, i + 1));
            if (start == 0) {
                dfs(res, path + num, s, target, i + 1, num, num);
            } else {
                dfs(res, path + "+" + num, s, target, i + 1, val + num, num);

                dfs(res, path + "-" + num, s, target, i + 1, val - num, -num);

                dfs(res, path + "*" + num, s, target, i + 1, val - pre + pre * num, pre * num);
            }
        }
    }
}
