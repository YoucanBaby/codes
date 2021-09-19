package algorithm.twopoint;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 21:21
 * @Description:
 */
public class _0287_findDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        _0287_findDuplicate solution = new _0287_findDuplicate();

        System.out.println(solution.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
