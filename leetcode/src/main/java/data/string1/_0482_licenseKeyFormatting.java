package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-10-05 21:39
 * @Description:
 */
public class _0482_licenseKeyFormatting {

    public static void main(String[] args) {
        _0482_licenseKeyFormatting solution = new _0482_licenseKeyFormatting();

        String s = "5F3Z-2e-9-w";
        System.out.println(solution.licenseKeyFormatting(s, 4));
    }

    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            count++;
            if (count == k && i != 0) {
                sb.append("-");
                count = 0;
            }
        }
        return sb.reverse().toString();
    }
}
