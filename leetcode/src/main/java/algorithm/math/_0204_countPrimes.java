package algorithm.math;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-09-22 16:44
 * @Description:
 */
public class _0204_countPrimes {

    public static void main(String[] args) {
        _0204_countPrimes solution = new _0204_countPrimes();
        System.out.println(solution.countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }
}
