package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-15 07:29
 * @Description:
 */
public class _1011_shipWithinDays {


    public int shipWithinDays(int[] weights, int limitDay) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(weights, limitDay, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 能否在limitDay天内运完所有的货物
    private boolean possible(int[] weights, int limitDay, int limitWeight) {
        int day = 1;                // 当前天数，不能超过limitDay
        int sum = 0;                // 当前负重，不能超过limitWeight
        for (int weight : weights) {
            if (weight > limitWeight) {
                return false;
            }
            if (sum + weight > limitWeight) {
                day++;
                sum = 0;
            }
            sum += weight;
        }
        return day <= limitDay;
    }
}
