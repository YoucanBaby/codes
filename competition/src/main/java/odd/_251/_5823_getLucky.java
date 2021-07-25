package odd._251;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._251
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 10:30
 * @Description:
 */
public class _5823_getLucky {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(String.valueOf(c - 'a' + 1));
        }

        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char c : sb.toString().toCharArray()) {
                sum += c - '0';
            }
            sb = new StringBuilder(String.valueOf(sum));
        }

        return Integer.valueOf(sb.toString());
    }
}
