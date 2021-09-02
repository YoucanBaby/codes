package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 03:13
 * @Description:
 */
public class _0306_isAdditiveNumber {


    public static void main(String[] args) {
        _0306_isAdditiveNumber solution = new _0306_isAdditiveNumber();

        String s = "11235813213455890144";
        System.out.println(solution.isAdditiveNumber(s));
    }

    public boolean isAdditiveNumber(String s) {
        List<Long> res = new ArrayList<>();
        return dfs(res, s, 0);
    }

    private boolean dfs(List<Long> res, String s, int start) {
        if (start == s.length()){
            return res.size() >= 3;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(start) == '0') {
                return false;
            }

            if (i + 1 - start >= 10) {
                return false;
            }
            long num = Long.valueOf(s.substring(start, i + 1));
            if (num > Long.MAX_VALUE) {
                return false;
            }
            if (res.size() >= 2 && num != res.get(res.size() - 1) + res.get(res.size() - 2)) {
                continue;
            }

            if (res.size() <= 1 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add(num);
                if (dfs(res, s, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
