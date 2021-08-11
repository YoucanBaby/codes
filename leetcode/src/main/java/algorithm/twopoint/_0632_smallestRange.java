package algorithm.twopoint;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-07-25 23:46
 * @Description:
 */
public class _0632_smallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        // 统计元素总数
        int N = 0;
        for (List<Integer> num : nums) {
            N += num.size();
        }
        // 记录每个数字所属的组
        int[][] ordered = new int[N][2];
        int index = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                ordered[index][0] = list.get(j);
                ordered[index][1] = i;
                index++;
            }
        }
        Arrays.sort(ordered, (o1, o2) -> o1[0] - o2[0]);    // 排序

        int[] res = new int[2];                 // 结果区间
        int[] count = new int[nums.size()];     // 每组有几个数字在滑动窗口内
        int size = 0;                           // 滑动窗口内有几组数
        int left = 0;
        for (int right = 0; right < N; right++) {
            count[ordered[right][1]]++;
            // 如果右指针对应的数，所对应的这一组数之前没有一个在区间内，则区间内的组数 + 1
            if (count[ordered[right][1]] == 1) {
                size++;
            }
            // 如果每一组都有数在区间内
            if (size == nums.size()) {
                // 就把左边界向右移动，但保证每一组都有数在区间内
                while (count[ordered[left][1]] > 1) {
                    count[ordered[left][1]]--;
                    left++;
                }
                // 如果结果区间未赋值 或者 当前结果区间长度 > 滑动窗口的长度，更新区间
                if ((res[0] == 0 && res[1] == 0) ||
                        res[1] - res[0] > ordered[right][0] - ordered[left][0]) {
                    res[0] = ordered[left][0];
                    res[1] = ordered[right][0];
                }
            }
        }
        return res;
    }



    public int[] smallestRange1(List<List<Integer>> nums) {
        int N = 0;          // 元素总数
        for (List<Integer> num : nums) {
            N += num.size();
        }

        int[][] ordered = new int[N][2];
        int index = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                ordered[index][0] = list.get(j);
                ordered[index][1] = i;
                index++;
            }
        }
        Arrays.sort(ordered, (o1, o2) -> o1[0] - o2[0]);

        int[] res = new int[2];
        int[] count = new int[nums.size()];
        int size = 0;
        int left = 0;
        for (int right = 0; right < N; right++) {
            count[ordered[right][1]]++;
            if (count[ordered[right][1]] == 1) {
                size++;
            }
            if (size == nums.size()) {
                while (count[ordered[left][1]] > 1) {
                    count[ordered[left][1]]--;
                    left++;
                }
                if ((res[0] == 0 && res[1] == 0) || res[1] - res[0] > ordered[right][0] - ordered[left][0]) {
                    res[0] = ordered[left][0];
                    res[1] = ordered[right][0];
                }
            }
        }
        return res;
    }
}
