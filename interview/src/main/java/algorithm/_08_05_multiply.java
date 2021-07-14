package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm
 * @Author: xuyifang
 * @CreateTime: 2021-07-14 09:26
 * @Description:
 */
public class _08_05_multiply {

    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        if (B == 1) {
            return A;
        }
        if (B % 2 == 1) {
            return A + multiply(A << 1, B >> 1);
        } else {
            return multiply(A << 1, B >> 1);
        }
    }
}
