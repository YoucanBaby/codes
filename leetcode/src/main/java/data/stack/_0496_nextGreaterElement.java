package data.stack;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-14 20:21
 * @Description:
 */
public class _0496_nextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        _0496_nextGreaterElement solution = new _0496_nextGreaterElement();

        int[] nums3 = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = solution.nextGreaterElement2(nums1, nums2);
        System.out.println(Arrays.toString(nums4));
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        // 求出每个元素右边第一个更大的元素的下标，即单调栈中存放的是下标
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.getFirst()]) {
                int j = stack.removeFirst();
                map.put(nums2[j], nums2[i]);
            }
            stack.addFirst(i);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.getOrDefault(nums1[i], -1);
        }
        return ret;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            ret[i] = nums2[k];
                            break;
                        } else {
                            ret[i] = -1;
                        }
                    }
                    break;
                }
            }
        }

        return ret;
    }
}
