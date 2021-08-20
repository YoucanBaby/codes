package algorithm.twopoint;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-21 00:10
 * @Description:
 */
public class _0524_findLongestWord {

    // 模拟
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String d : dictionary) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < d.length()) {
                if (s.charAt(i) == d.charAt(j)) {
                    j++;
                }
                if (j == d.length()) {
                    if (res.length() < d.length() ||
                            (res.length() == d.length() && res.compareTo(d) > 0) ) {
                        res = d;
                    }
                }
                i++;
            }
        }
        return res;
    }
}
