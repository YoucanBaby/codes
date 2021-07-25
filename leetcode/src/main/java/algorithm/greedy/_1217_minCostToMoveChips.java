package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 08:18
 * @Description:
 */
public class _1217_minCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        // 统计奇数与偶数的个数
        for (int num : position) {
            if ((num & 1) == 1) {
                odd++;
            }
            if ((num & 1) == 0) {
                even++;
            }
        }
        return Math.min(odd,even);
    }
}
