package odd._265;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._265
 * @author: xuyifang
 * @CreateTime: 2021-10-31-10:26
 * @description:
 * @version: 1.0
 */
public class _1 {

    public static void main(String[] args) {

    }

    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
