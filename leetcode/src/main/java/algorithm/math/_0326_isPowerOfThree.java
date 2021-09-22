package algorithm.math;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 08:27
 * @Description:
 */
public class _0326_isPowerOfThree {


    public static void main(String[] args) {
        _0326_isPowerOfThree solution = new _0326_isPowerOfThree();
        System.out.println(solution.get3Max());
    }


    public boolean isPowerOfThree(int n) {
        return (n > 0) && (1162261467 % n == 0);
    }

    public int get3Max() {
        int n = 1;
        while (n < Integer.MAX_VALUE / 3) {
            n *= 3;
        }
        return n;
    }
}
