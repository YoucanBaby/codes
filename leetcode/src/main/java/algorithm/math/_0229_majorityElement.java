package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 05:17
 * @Description:
 */
public class _0229_majorityElement {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }
            // 第一个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第二个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            list.add(cand1);
        }
        if (count2 > nums.length / 3) {
            list.add(cand2);
        }
        return list;
    }
}
