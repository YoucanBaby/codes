package data.binary;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.binary
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 21:04
 * @Description:
 */
public class _0696_countBinarySubstrings {


    public int countBinarySubstrings(String s) {
        int N = s.length();
        int res = 0;
        int last = 0;               // 上一组连续0或者连续1的个数

        int index = 0;
        while (index < N) {
            char c = s.charAt(index);
            int count = 0;
            while (index < N && s.charAt(index) == c) {     // 统计连续0或者连续1的个数
                index++;
                count++;
            }
            res += Math.min(count, last);
            last = count;
        }
        return res;
    }


    public int countBinarySubstrings1(String s) {
        int N = s.length();
        int res = 0;
        int last = 0;

        int index = 0;
        while (index < N) {
            char c = s.charAt(index);
            int count = 1;
            index++;
            while (index < N && s.charAt(index) == c) {
                index++;
                count++;
            }
            res += Math.min(count, last);
            last = count;
        }
        return res;
    }
}
