package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 11:54
 * @Description:
 */
public class _0485_findMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        _0485_findMaxConsecutiveOnes solution = new _0485_findMaxConsecutiveOnes();

        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                res = Math.max(res, right - left + 1);
            } else {
                left = right + 1;
            }
        }
        return res;
    }
}
