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
        int N = nums.length;
        int i = 0;
        int ret = 0;

        for (int j = 0; j < N; j++) {
            if(nums[j] == 1) {
                ret = Math.max(ret, (j - i + 1));
            } else {
                i = j + 1;
            }
        }
        return ret;
    }
}
