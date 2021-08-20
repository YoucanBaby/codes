package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 15:08
 * @Description:
 */
public class _0777_canTransform {


    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int j = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(j) != 'L') {
                    j++;
                }
                if (i < j) {
                    return false;
                }
                j++;
            }
        }

        j = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                while (end.charAt(j) != 'R') {
                    j++;
                }
                if (i > j) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }
}
