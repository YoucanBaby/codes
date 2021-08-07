package even._058;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._058
 * @Author: xuyifang
 * @CreateTime: 2021-08-07 22:30
 * @Description:
 */
public class _5193_makeFancyString {

    public String makeFancyString(String s) {
        if (s.length() <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
