package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-23 23:21
 * @Description:
 */
public class _0008_myAtoi {



    public int myAtoi(String str) {
        char[] s = str.toCharArray();
        int i = 0;
        while (i < s.length && s[i] == ' ') i++;        // 去掉前面的空格
        if (i == s.length) return 0;

        int minus = 1;
        if (s[i] == '-') {
            minus = -1;
            i++;
        } else if (s[i] == '+') {
            minus = 1;
            i++;
        }

        long res = 0;
        while (i < s.length && Character.isDigit(s[i])) {
            res = res * 10 + s[i] - '0';
            i++;
            if (res > Integer.MAX_VALUE) break;
        }
        res *= minus;

        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }
}
