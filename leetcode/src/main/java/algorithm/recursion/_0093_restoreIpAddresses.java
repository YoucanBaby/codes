package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion
 * @Author: xuyifang
 * @CreateTime: 2021-07-17 21:56
 * @Description:
 */
public class _0093_restoreIpAddresses {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(s, 0, 0);
        return res;
    }

    // 字符串s，搜索的起始位置start，添加的逗号数量pointNum
    public void dfs(String s, int start, int pointNum) {
        // 剪枝：当path里超过四个逗号，就返回
        if (pointNum > 4) {
            return;
        }
        // 终止条件：start遍历到最后一位，path只有四个逗号
        if (start == s.length() && pointNum == 4) {
            res.add(path.toString().substring(1, path.length()));  // 第一位是逗号，需要去掉
        }

        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (temp.charAt(0) == '0' && temp.length() > 1) {
                continue;
            }
            if (Integer.valueOf(temp) >= 0 && Integer.valueOf(temp) <= 255) {
                path.append(".").append(temp);
                dfs(s, i + 1, pointNum + 1);
                path.delete(path.lastIndexOf("."), path.length());
            }
        }
    }


    class Solution {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() < 4 || s.length() > 12) {
                return res;
            }

            dfs(s, 0, 0);
            return res;
        }

        public void dfs(String s, int start, int pointNum) {
            if (pointNum > 4) {
                return;             // 剪枝
            }
            if (start == s.length() && pointNum == 4) {
                res.add(path.toString().substring(1, path.length()));       // 去掉第一个'.'
            }

            for (int i = start; i < start + 3 && i < s.length(); i++) {
                String str = s.substring(start, i + 1);
                if (str.charAt(0) == '0' && str.length() > 1) {     // 跳过前导0
                    continue;
                }
                if (Integer.valueOf(str) >= 0 && Integer.valueOf(str) <= 255) {
                    path.append('.').append(str);
                    dfs(s, i + 1, pointNum + 1);
                    path.delete(path.lastIndexOf("."), path.length());
                }
            }
        }
    }
}
