package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-25 19:47
 * @Description:
 */
public class _0028_strStr {



    public int strStr(String s, String t) {
        int M = s.length(), N = t.length();
        if (N == 0) return 0;
        for (int i = 0; i < M - N + 1; i++) {
            if (t.equals(s.substring(i, i + N))) return i;
        }
        return -1;
    }
}
