import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:30
 * @Description:
 */

public class test {

    public static void main(String[] args) {
        test test = new test();
        int[] nums = {2,3,6,1,2,2,4,2};
        int k = 2;
        System.out.println(Arrays.toString(test.change(nums, k)));
    }

    public int[] change(int[] nums, int k) {
        int N = nums.length;
        int l = 0, r = 0;
        while (r < N) {
            while (l < N && nums[l] == k) {
                l++;
            }
            while (l >= r || (r < N && nums[r] != k)) {
                r++;
            }
            if (l < N && r < N) {
                swap(nums, l, r);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
