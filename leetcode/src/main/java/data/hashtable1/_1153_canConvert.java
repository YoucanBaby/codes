package data.hashtable1;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-09-20 12:56
 * @Description:
 */
public class _1153_canConvert {


    public static void main(String[] args) {
        _1153_canConvert solution = new _1153_canConvert();

        String s = "aa";
        String t = "ab";
        System.out.println(solution.canConvert(s, t));
    }

    public boolean canConvert(String ss, String tt) {
        if (ss.equals(tt)) return true;

        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        int count = 0;
        boolean[] isShow = new boolean[128];
        for (char c : t) {
            if (!isShow[c]) {
                isShow[c] = true;
                count++;
            }
        }
        if (count == 26) return false;

        int[] last = new int[128];
        Arrays.fill(last, - 1);
        for (int i = 0; i < s.length; i++) {
            if (last[s[i]] == -1) {
                last[s[i]] = i;
                continue;
            }
            if (t[last[s[i]]] != t[i]) return false;
        }
        return true;
    }
}
