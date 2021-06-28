package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 20:50
 * @Description:
 */
public class _1122_relativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        _1122_relativeSortArray solution = new _1122_relativeSortArray();

        int[] res = solution.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 首先求出arr1中元素的最大值
        int max = Integer.MIN_VALUE;
        for (int num: arr1) {
            max = Math.max(max, num);
        }

        // 计算arr1中各个元素出现的频率
        int[] freq = new int[max + 1];
        for (int num: arr1) {
            freq[num]++;
        }

        // 根据arr2的顺序把arr1中的元素依次添加到结果集中
        int[] ret = new int[arr1.length];
        int idx = 0;
        for (int num: arr2) {
            for (int i = 0; i < freq[num]; i++) {
                ret[idx++] = num;
            }
            freq[num] = 0;
        }

        // 把arr1中剩余元素添加到结果集中
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                for (int j = 0; j < freq[i]; j++) {
                    ret[idx++] = i;
                }
            }
        }

        return ret;
    }
}
