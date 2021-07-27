package algorithm.twopoints;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoints
 * @Author: xuyifang
 * @CreateTime: 2021-07-28 01:29
 * @Description:
 */
public class _0058_reverseWords {

    public String reverseWords(String s) {
        s = s.trim();       // 删除首尾空格
        String[] strs = s.split(" ");    // 以空格分割字符串s
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            if (str.equals("")) {
                continue;
            } else {
                sb.insert(0, " ");
                sb.insert(0, str);
            }
        }

        return sb.toString().trim();
    }
}
