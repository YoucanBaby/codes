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


    int[] count;
    int[] index;

    int[] temp;
    int[] tempIndex;

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        count = new int[N];
        index = new int[N];
        for (int i = 0; i < N; i++) index[i] = i;
        temp = new int[N];
        tempIndex = new int[N];

        mergeSort(nums, 0, N - 1);

        List<Integer> res = new ArrayList<>();
        for (int c : count) res.add(c);
        return res;
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
                count[index[p1]] += p2 - mid - 1;
                temp[i] = nums[p1];
                tempIndex[i++] = index[p1++];
            } else {
                temp[i] = nums[p2];
                tempIndex[i++] = index[p2++];
            }
        }
        while (p1 <= mid) {
            count[index[p1]] += p2 - mid - 1;
            temp[i] = nums[p1];
            tempIndex[i++] = index[p1++];
        }
        while (p2 <= right) {
            temp[i] = nums[p2];
            tempIndex[i++] = index[p2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j];
            index[j] = tempIndex[j];
        }
    }
}
