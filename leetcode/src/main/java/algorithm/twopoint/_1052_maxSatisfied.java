package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-18 11:26
 * @Description:
 */
public class _1052_maxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        int windowValue = 0;                            // 生气的x分钟里，会让多少顾客不满意
        for (int right = 0; right < X; right++) {       // 先计算[0,X-1]范围内的生气的顾客数量
            if (grumpy[right] == 1) {
                windowValue += customers[right];
            }
        }
        int maxValue = windowValue;

        for (int right = X; right < customers.length; right++) {
            if (grumpy[right] == 1) {
                windowValue += customers[right];
            }
            int left = right - X;
            if (grumpy[left] == 1) {
                windowValue -= customers[left];
            }
            maxValue = Math.max(maxValue, windowValue);
        }
        return sum + maxValue;
    }
}
