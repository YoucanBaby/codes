package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 04:27
 * @Description:
 */
public class _0565_arrayNesting {

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        _0565_arrayNesting solution = new _0565_arrayNesting();

        System.out.println(solution.arrayNesting(nums));
    }

    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }
            int count = 0;
            int cur = i;
            while (nums[cur] != Integer.MAX_VALUE) {
                count++;
                int next = nums[cur];
                nums[cur] = Integer.MAX_VALUE;
                cur = next;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
