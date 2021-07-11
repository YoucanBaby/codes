package algorithm.sort;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 00:56
 * @Description:
 */
public class _0275_hIndex {

    public int hIndex1(int[] citations) {
        int N = citations.length;
        int h = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (citations[i] <= h) {
                return h;
            }
            h++;
        }
        return h;
    }

    public int hIndex2(int[] citations) {
        int N = citations.length;
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int h = N - mid;
            if (h == citations[mid]) {
                return h;
            } else if (h < citations[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return N - left;
    }
}
