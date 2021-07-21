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
        int ten = 0;
        int five = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else if (bill == 20){
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (ten == 0 && five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }

            if (ten < 0 || five < 0) {
                return false;
            }
        }
        return true;
    }
}
