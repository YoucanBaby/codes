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
    }

    int[] temp;         // temp用于归并排序内部交换nums
    int[] index;        // index是索引数组
    int[] tempIndex;    // tempIndex用于归并排序内部交换index
    int[] res;          // res保存右边大的个数

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        temp = new int[N];
        index = new int[N];
        tempIndex = new int[N];
        res = new int[N];

        // 初始化索引数组 [0,1,2,3...]
        for (int i = 0; i < N; ++i) {
            index[i] = i;
        }
        mergeSort(nums, 0, N - 1);

        List<Integer> list = new ArrayList<Integer>();
        for (int num : res) {
            list.add(num);
        }
        return list;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    public void merge(int[] nums, int left,int right, int mid) {
        int p1 = left;
        int p2 = mid + 1;
        int i = left;

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                tempIndex[i] = index[p1];
                res[index[p1]] += (p2 - mid - 1);
                temp[i++] = nums[p1++];
            } else {
                tempIndex[i] = index[p2];
                temp[i++] = nums[p2++];
            }
        }
        while (p1 <= mid)  {
            tempIndex[i] = index[p1];
            res[index[p1]] += (p2 - mid - 1);
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            tempIndex[i] = index[p2];
            temp[i++] = nums[p2++];
        }
        // 更新下标数组和原数组
        for (int j = left; j <= right; j++) {
            index[j] = tempIndex[j];
            nums[j] = temp[j];
        }
    }

    class Solution {
        int[] temp;
        int[] tempIndex;
        int[] index;
        int[] res;

        public List<Integer> countSmaller(int[] nums) {
            int N = nums.length;
            temp = new int[N];
            tempIndex = new int[N];
            index = new int[N];
            res = new int[N];
            for (int i = 0; i < N; i++) {
                index[i] = i;
            }
            
            mergeSort(nums, 0, N - 1);
            List<Integer> list = new ArrayList<Integer>();
            for (int num : res) {
                list.add(num);
            }
            return list;
        }

        public void mergeSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }

        public void merge(int[] nums, int left, int right, int mid) {
            int p1 = left;
            int p2 = mid + 1;
            int i = left;

            while (p1 <= mid && p2 <= right) {
                if (nums[p1] <= nums[p2]) {
                    tempIndex[i] = index[p1];
                    res[index[p1]] += p2 - mid - 1;
                    temp[i++] = nums[p1++];
                } else {
                    tempIndex[i] = index[p2];
                    temp[i++] = nums[p2++];
                }
            }
            while (p1 <= mid) {
                tempIndex[i] = index[p1];
                res[index[p1]] += p2 - mid - 1;
                temp[i++] = nums[p1++];
            }
            while (p2 <= right) {
                tempIndex[i] = index[p2];
                temp[i++] = nums[p2++];
            }
            for (int j = left; j <= right; j++) {
                index[j] = tempIndex[j];
                nums[j] = temp[j];
            }
        }
    }
}
