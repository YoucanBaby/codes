package algorithm.find;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.find
 * @Author: xuyifang
 * @CreateTime: 2021-08-13 09:19
 * @Description:
 */
public class _0875_minEatingSpeed {

    public static void main(String[] args) {
        _0875_minEatingSpeed solution = new _0875_minEatingSpeed();
        int[] piles = {3,6,7,11};
        int H = 8;

        System.out.println(solution.minEatingSpeed(piles, H));
    }


    public int minEatingSpeed(int[] piles, int H) {
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getTime(piles, mid) <= H) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getTime(int[] piles, int mid) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / mid);
        }
        return time;
    }
}
