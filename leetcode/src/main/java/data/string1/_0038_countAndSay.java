package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-24 17:15
 * @Description:
 */
public class _0038_countAndSay {


    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int count = 1;                      // 有相同字母的字符串长度
        for (int i = 0; i < pre.length(); i++) {
            if (i + 1 < pre.length() && pre.charAt(i) == pre.charAt(i + 1)) {
                count++;
            } else {
                res.append(count).append(pre.charAt(i));
                count = 1;
            }
        }
        return res.toString();
    }
}
