package algorithm;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 00:34
 * @Description:
 */
public class _17_10_majorityElement {

    public static void main(String[] args) {
        int[] nums = {3,3,4};
        _17_10_majorityElement solution = new _17_10_majorityElement();

        System.out.println(solution.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                if (candidate == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count >= (nums.length + 1) / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}
