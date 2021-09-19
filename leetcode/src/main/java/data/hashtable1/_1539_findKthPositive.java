package data.hashtable1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-19 11:51
 * @Description:
 */
public class _1539_findKthPositive {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        _1539_findKthPositive solution = new _1539_findKthPositive();

        System.out.println(solution.findKthPositive1(arr, k));
        System.out.println(solution.findKthPositive2(arr, k));
        System.out.println(solution.findKthPositive(arr, k));
    }

    public int findKthPositive(int[] arr, int k) {

        if (arr[0] > k) {
            return k;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // k - pi - ai
        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }


    public int findKthPositive2(int[] nums, int k) {
        for (int num : nums) {
            if (num <= k) k++;
        }
        return k;
    }


    public int findKthPositive1(int[] arr, int k) {

        Set<Integer> set = new HashSet<>();
        for (int num: arr) {
            set.add(num);
        }

        int cnt = 0;
        for (int num = 1; num < k + arr.length + 1; num++) {
            if (set.contains(num)) {
                continue;
            } else {
                cnt++;
            }
            if (cnt == k) {
                return num;
            }
        }
        return 0;
    }
}
