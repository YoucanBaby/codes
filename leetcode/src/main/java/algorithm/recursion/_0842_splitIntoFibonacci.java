package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 02:49
 * @Description:
 */
public class _0842_splitIntoFibonacci {


    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> res = new ArrayList<>();
        dfs(res, s, 0);
        return res;
    }

    private boolean dfs(List<Integer> res, String s, int start) {
        if (res.size() >= 3 && start == s.length()) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(start) == '0') {
                return false;
            }

            long num = Long.valueOf(s.substring(start, i + 1));
            if (num > Integer.MAX_VALUE) {
                return false;
            }
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) {
                return false;
            }

            if (res.size() <= 1 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add((int) num);
                if (dfs(res, s, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
