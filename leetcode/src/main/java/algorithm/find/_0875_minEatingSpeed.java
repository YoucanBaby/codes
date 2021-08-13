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
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(piles, H, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 珂珂能否在H小时内以速度K吃完所有的香蕉
    private boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / K);
        }
        return time <= H;
    }
}
