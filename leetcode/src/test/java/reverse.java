/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-10-11 18:48
 * @Description:
 */
public class reverse {


    public static void main(String[] args) {
        int num = 489;
        System.out.println(Integer.toBinaryString(num));

        int res = 0;
        while (num != 0) {
            int bit = (num & 1);
            num >>= 1;
            res |= bit;
            res <<= 1;
        }
        res >>= 1;
        System.out.println(Integer.toBinaryString(res));
    }
}
