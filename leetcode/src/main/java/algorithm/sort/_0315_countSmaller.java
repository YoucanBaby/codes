package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-22 11:03
 * @Description:
 */
public class _0315_countSmaller {

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        // int[] nums = {8,7,6,5,4,3,2,1};

        _0315_countSmaller solution = new _0315_countSmaller();
        System.out.println(solution.countSmaller(nums));

        Solution solution1 = new Solution();
        System.out.println(solution1.countSmaller(nums));
    }

    int[] index;
    int[] res;

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        // 索引数组
        index = new int[N];
        // 初始化index [0,1,2,3..]
        for (int i = 0; i < N; i++) {
            index[i] = i;
        }

        // res记录右边小的数量
        res = new int[N];

        // 返回结果
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        mergeSort(nums, left, right);

        for (int i = 0; i < res.length; i++) {
            list.add(res[i]);
        }
        return list;
    }

    private void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;

        if (left < right) {
            // 左
            mergeSort(nums, left, mid);
            // 右
            mergeSort(nums, mid + 1, right);
            // 归并
            merge(nums, left, right, mid);
        }
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int[] tempIndex = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;

        // nums中的值保持不变，改变的是nums的下标，即索引数组index
        while (p1 <= mid && p2 <= right) {
            if (nums[index[p1]] <= nums[index[p2]]) {
                tempIndex[i++] = index[p1++];
            } else {

                res[index[i]] += mid - p1 + 1;
                tempIndex[i++] = index[p2++];
            }
        }

        while (p1 <= mid) {
            tempIndex[i++] = index[p1++];
        }

        while (p2 <= right) {
            res[index[i]] += mid - p1 + 1;
            tempIndex[i++] = index[p2++];
        }

        for (int j = 0; j < tempIndex.length; j++) {
            index[left + j] = tempIndex[j];
        }
    }
}

class Solution {
    private int[] temp;
    private int[] index;
    private int[] tempIndex;
    private int[] res;

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;

        // temp用于归并排序内部交换nums
        temp = new int[N];
        // index是索引数组
        index = new int[N];
        // tempIndex用于归并排序内部交换index
        tempIndex = new int[N];
        // res保存右边大的个数
        res = new int[N];

        // 初始化索引数组 [0,1,2,3...]
        for (int i = 0; i < N; ++i) {
            index[i] = i;
        }

        int left = 0;
        int right = N - 1;
        mergeSort(nums, left, right);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : res) {
            list.add(num);
        }
        return list;
    }

    public void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;

        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    public void merge(int[] nums, int left,int right, int mid) {
        int p1 = left;
        int p2 = mid + 1;
        int i = left;

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[i] = nums[p1];
                tempIndex[i] = index[p1];
                res[index[p1]] += (p2 - mid - 1);
                p1++;
                i++;
            } else {
                temp[i] = nums[p2];
                tempIndex[i] = index[p2];
                p2++;
                i++;
            }
        }

        while (p1 <= mid)  {
            temp[i] = nums[p1];
            tempIndex[i] = index[p1];
            res[index[p1]] += (p2 - mid - 1);
            p1++;
            i++;
        }

        while (p2 <= right) {
            temp[i] = nums[p2];
            tempIndex[i] = index[p2];
            p2++;
            i++;
        }

        for (int j = left; j <= right; j++) {
            nums[j] = temp[j];
            index[j] = tempIndex[j];
        }
    }
}

