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
        for (int i = 0; i < strs[0].length(); i++) {
            for (int k = 1; k < strs.length; k++) {
                if (strs[k].length() <= i || strs[0].charAt(i) != strs[k].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}