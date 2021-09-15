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
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                next.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = next.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
