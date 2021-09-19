package odd._258;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._258
 * @Author: xuyifang
 * @CreateTime: 2021-09-12 10:31
 * @Description:
 */
public class _5867_reversePrefix {


    public String reversePrefix(String s, char c) {
        int index = s.indexOf(c);
        if (index == -1) return s;

        String t1 = s.substring(0, index + 1);
        String t2 = s.substring(index + 1, s.length());
        StringBuilder sb = new StringBuilder(t1);
        sb.reverse();

        return sb.toString() + t2;
    }
}
