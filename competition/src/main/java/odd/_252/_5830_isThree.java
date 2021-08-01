package odd._252;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._252
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 10:44
 * @Description:
 */
public class _5830_isThree {

    public boolean isThree(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum++;
            }
        }
        return sum == 3;
    }
}
