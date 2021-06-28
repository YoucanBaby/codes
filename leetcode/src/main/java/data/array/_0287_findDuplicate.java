package data.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 21:21
 * @Description:
 */
public class _0287_findDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        _0287_findDuplicate solution = new _0287_findDuplicate();

        System.out.println(solution.findDuplicate1(nums));
        System.out.println(solution.findDuplicate2(nums));
        System.out.println(solution.findDuplicate3(nums));
        System.out.println(solution.findDuplicate4(nums));
    }

    private int findDuplicate4(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public int findDuplicate3(int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;   // 把mid看成是i就好了
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (nums[j] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num: nums) {
            if (set.contains(num)){
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
}
