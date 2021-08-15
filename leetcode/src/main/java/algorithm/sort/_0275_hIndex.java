package algorithm.sort;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 00:56
 * @Description:
 */
public class _0275_hIndex {


    public int hIndex(int[] citations) {
        if (citations[citations.length - 1] == 0) {     // 特殊情况，输入[0]，返回0
            return 0;
        }

        int N = citations.length;
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= N - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return N - left;
    }
}
