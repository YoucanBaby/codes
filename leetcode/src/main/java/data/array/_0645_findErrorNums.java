package data.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 18:04
 * @Description:
 */
public class _0645_findErrorNums {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,6};
        _0645_findErrorNums solution = new _0645_findErrorNums();

        int[] nums1 = solution.findErrorNums(nums);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = solution.findErrorNums2(nums);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = solution.findErrorNums3(nums);
        System.out.println(Arrays.toString(nums3));
    }

    private int[] findErrorNums3(int[] nums) {
        int N = nums.length;
        int[] ret = new int[2];     // {重复出现的整数, 丢失的整数}

        // 遍历 nums 中的所有数字，根据数字 i 找到 nums[∣i∣]
        for (int num: nums) {
            // 如果是第一次访问 nums[∣i∣]，将它反转为负数
            if (nums[Math.abs(num) - 1] >= 0) {
                nums[Math.abs(num) - 1] *= (-1);
            } else {    // 如果是第二次访问，则会发现它已经是负数。
                ret[0] = Math.abs(num);
            }
        }

        // 所有出现过的数字对应索引处的数字都是负数，只有缺失数字对应的索引处仍然是正数。
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                ret[1] = i + 1;
            }
        }
        return ret;
    }

    public int[] findErrorNums2(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i]) == false) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 2);
            }
        }
        System.out.println(map);
        int[] ret = new int[2];     // {重复出现的整数, 丢失的整数}
        for (int i = 0; i < N; i++) {
            if (map.containsKey(i + 1) == false) {
                ret[1] = i + 1;
            } else if (map.get(nums[i]) == 2) {
                ret[0] = nums[i];
            }
        }
        return ret;
    }

    public int[] findErrorNums(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            // 当前位置上的值不是对的 && 原位置上的值也不是对的
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);     // 交换当前位置和原位置上的值
            }
        }
        for (int i = 0; i < N; i++) {
            // 当前位置上的值不是对的
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};   // {重复出现的整数, 丢失的整数}
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
