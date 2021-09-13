package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 03:30
 * @Description:
 */
public class _0881_numRescueBoats {


    public int numRescueBoats(int[] people, int limit) {
        int[] weights = new int[limit + 1];
        for (int weight : people) {
            weights[weight]++;
        }

        int res = 0;
        int left = 0;
        int right = limit;
        while (left <= right) {
            // weights[left] <= 0，是因为当left和right相等且left+right<=limit的时候，weights[i]是可能是-1
            while (left <= right && weights[left] <= 0) {
                left++;
            }
            while (left <= right && weights[right] <= 0) {
                right--;
            }
            if (left <= right) {
                if (left + right <= limit) {
                    weights[left]--;
                    weights[right]--;
                } else {
                    weights[right]--;
                }
                res++;
            }
        }
        return res;
    }


    public int numRescueBoats1(int[] people, int limit) {
        int[] weights = new int[limit + 1];
        for (int weight : people) {
            weights[weight]++;
        }

        int res = 0;
        int left = 0;
        int right = limit;
        while (left <= right) {
            while (left <= right && weights[left] <= 0) {
                left++;
            }
            while (left <= right && weights[right] <= 0) {
                right--;
            }
            if (left <= right) {
                if (left + right <= limit) {
                    weights[left]--;
                    weights[right]--;
                } else {
                    weights[right]--;
                }
                res++;
            }
        }
        return res;
    }
}
