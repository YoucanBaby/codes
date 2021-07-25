package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 06:10
 * @Description:
 */
public class _0621_leastInterval {


    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        // 出现次数最多的任务的出现次数
        int maxTimes = 0;
        for (int count : counts) {
            maxTimes = Math.max(maxTimes, count);
        }
        // 一共有多少个任务和出现最多的那个任务出现次数一样
        int maxCount = 0;
        for (int count : counts) {
            if (count == maxTimes) {
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxTimes - 1) * (n + 1) + maxCount);
    }
}
