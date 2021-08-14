package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 05:44
 * @Description:
 */
public class _0769_maxChunksToSorted {

    public static void main(String[] args) {
        int[] arr1 = {4,3,2,1,0};
        int[] arr2 = {1,0,2,3,4};
        _0769_maxChunksToSorted solution = new _0769_maxChunksToSorted();

        System.out.println(solution.maxChunksToSorted(arr1));
        System.out.println(solution.maxChunksToSorted(arr2));
    }

    public int maxChunksToSorted(int[] arr) {
        int ret = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ret++;
            }
        }
        return ret;
    }
}
