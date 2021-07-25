package odd._251;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._251
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 10:38
 * @Description:
 */
public class _5824_maximumNumber {

    public String maximumNumber(String num, int[] change) {
        StringBuilder res = new StringBuilder();

        int index = 0;
        int N = num.length();
        while (index < N) {
            char c = num.charAt(index++);
            if (change[c - '0'] > c - '0') {
                res.append(change[c - '0']);
                break;
            }
            res.append(c);
        }

        while (index < N) {
            char c = num.charAt(index++);
            if (change[c - '0'] < c - '0') {
                res.append(c);
                break;
            }
            res.append(change[c - '0']);
        }

        while (index < N) {
            char c = num.charAt(index++);
            res.append(c);
        }

        return res.toString();
    }
}
