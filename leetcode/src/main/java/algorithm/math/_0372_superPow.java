package algorithm.math;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-24 09:54
 * @Description:
 */
public class _0372_superPow {

    public static void main(String[] args) {
        _0372_superPow solution = new _0372_superPow();

        int x = 2;
        int[] n = {3};
        System.out.println(solution.superPow(x, n));
    }



    int MOD = 1337;

    public int superPow(int x, int[] n) {
        int N = n.length;
        if (N == 0) return 1;
        return (int) (myPow(x, n[N - 1]) * myPow(superPow(x, Arrays.copyOf(n, N - 1)), 10) % MOD);
    }

    public long myPow(int x, int n) {
        if (n == 0) return 1;
        x %= MOD;
        if ((n & 1) == 1) {
            return x * myPow(x, n - 1) % MOD;
        } else {
            return myPow(x * x, n / 2) % MOD;
        }
    }
}
