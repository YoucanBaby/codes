package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-21 20:24
 * @Description:
 */
public class _0860_lemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            else if (bill == 10) {
                five--;
                ten++;
            } else {
                if (ten >= 1) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (ten < 0 || five < 0) {
                return false;
            }
        }
        return true;
    }
}
