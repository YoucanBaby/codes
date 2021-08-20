package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-08-19 20:11
 * @Description:
 */
public class _01_06_compressString {


    public String compressString(String s) {
        if (s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(left) == s.charAt(right)) {
                continue;
            } else {
                sb.append(s.charAt(left));
                sb.append(right - left);
                left = right;
            }
        }
        sb.append(s.charAt(left));
        sb.append(s.length() - left);

        return sb.toString().length() < s.length() ? sb.toString() : s;
    }
}
