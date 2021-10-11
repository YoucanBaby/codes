package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-10-02 09:53
 * @Description:
 */
public class _0405_toHex {

    public static void main(String[] args) {
        _0405_toHex toHex = new _0405_toHex();
        System.out.println(toHex.toHex(-20));
    }

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int l = num & 15;
            char c = (char) (l < 10 ? l + '0' : l - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
