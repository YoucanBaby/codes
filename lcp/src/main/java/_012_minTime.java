/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-08-14 08:44
 * @Description:
 */
public class _012_minTime {


    public int minTime(int[] times, int M) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(times, M, mid)) {      // 做题目的天数是否超过M天
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 每道题目所需时间，做题的最大天数M，当天最多用时limitTime
    private boolean possible(int[] times, int M, int limitTime) {
        int day = 1;                        // 做题目的天数
        int sum = 0;                        // 当天所做题目的耗时
        int max = 0;                        // 当天所做题目的最大耗时
        for (int time : times) {
            sum += time;
            max = Math.max(max, time);
            if (sum - max > limitTime) {
                day++;
                sum = time;             // 更新为下一天所作的题目
                max = time;
                if (day > M) {         // 做题目的天数超过M天，就不行
                    return false;
                }
            }
        }
        return true;
    }
}
