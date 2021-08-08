package odd._253;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._253
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 10:51
 * @Description:
 */
public class _5841_longestObstacleCourseAtEachPosition {

    public static void main(String[] args) {
        int[] nums = {3,1,5,6,4,2};
        _5841_longestObstacleCourseAtEachPosition solution = new _5841_longestObstacleCourseAtEachPosition();

        System.out.println(Arrays.toString(solution.longestObstacleCourseAtEachPosition(nums)));
    }

    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, 1);
        List<Integer> stack = new ArrayList<>();// 左边最小，右边最大
        stack.add(nums[0]);

        for (int i = 1; i < N; i++) {
            if (nums[i] >= stack.get(stack.size() - 1)) {
                stack.add(nums[i]);
                res[i] = stack.size();
            } else {
                int index = Collections.binarySearch(stack, nums[i]);
                stack.remove(stack.size() - 1);
                stack.add(nums[i]);
                res[i] = index + 1;
            }
            System.out.println(stack);
        }
        return res;
    }
}
