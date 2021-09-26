package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-26 07:28
 * @Description:
 */
public class _0459_repeatedSubstringPattern {


    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        return t.substring(1, t.length() - 1).contains(s);
    }
}
