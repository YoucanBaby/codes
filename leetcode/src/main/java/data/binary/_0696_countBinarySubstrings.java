package data.binary;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.binary
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 21:04
 * @Description:
 */
public class _0696_countBinarySubstrings {

    public static void main(String[] args) {
        _0696_countBinarySubstrings solution = new _0696_countBinarySubstrings();

        String s = "00110011";
        System.out.println(solution.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String ss) {
        char[] s = ss.toCharArray();
        int res = 0;
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i - 1]) {
                cur++;
            }
            else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) res++;
        }
        return res;
    }

}
