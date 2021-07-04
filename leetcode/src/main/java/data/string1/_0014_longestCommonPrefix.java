package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 18:17
 * @Description:
 */
public class _0014_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 排除特殊值
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 纵向扫描
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return strs[0].substring(0, i);
                }
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}